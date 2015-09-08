/* domain types */
  CHAR(n)       -- fixed-length character string, with user-specified length.
  VARCHAR(n)    -- variable-length character string, with user-specified maximum length.
  INT           -- (also: INTEGER) an integer (length is machine-dependent).
  DATE          -- a calendar date, containing four digit year, month, and day of the month.
  TIMESTAMP     -- the time of the day in hours, minutes, and seconds.
  FLOAT(n)      -- floating-point, with user-specified precision of at least n digits.
  SMALLINT      -- a small integer (length is machine-dependent).
  NUMERIC(p, d) -- a fixed-point number with user-specified precision, consists of p digits (plus a sign) and d of p digits are to the right of the decimal point. E.g., numeric(3, 1) allows 44.5 to be stored exactly but not 444.5.
  REAL          -- (also: DOUBLE PRECISION) floating-point or double-precision floating-point numbers, with machine-dependent precision.

/*  operator order */
  SELECT
  FROM
  WHERE
  GROUP BY
  HAVING
  ORDER BY

/*  basic create */
  CREATE TABLE book(
    title VARCHAR(256),
    authors VARCHAR(256),
    format CHAR(9) DEFAULT 'paperback',
    pages INT,
    year DATE,
    ISBN13 CHAR(14)
  );

/* basic insert */
  INSERT INTO student VALUES(...);                        -- insert all values in the order defined during table creation

  INSERT INTO student (email, name, faculty, department)  -- insert only values indicated by the ones list and in that order
  VALUES (...);

/* delete table */
  DROP TABLE loan;

/* querying */
  SELECT * FROM table_name;       -- display all columns from table

  SELECT column_name, column_name -- display indicated columns from table
  FROM table_name;

  SELECT name, email              -- display indicated columns from table with condition
  FROM student
  WHERE department='CS';

  SELECT student.name, book.title -- select from multiple tables
  FROM student, copy, book
  WHERE student.email=copy.owner
  AND copy.book=book.ISBN13;

  SELECT s.name AS owner          -- renaming colums for output (purely cosmetic)
  FROM loan l, student s
  WHERE s.email=l.owner
    AND l.returned > '2010-03-04'
    AND l.borrower = 'abc@mail.com';

  SELECT DISTINCT nationality     -- removing duplicates in a single row
  FROM student;
  
  SELECT DISTINCT nationality, last_name -- selecting only unique tuples
  FROM student;

  SELECT name                     -- ordering (default asc)
  FROM student
  ORDER BY matric_num DESC;

  SELECT name                     -- multiple ordering (default asc)
  FROM student
  ORDER BY nationality, name;     -- order first by nationality then by name within same nationality

  SELECT book, price * 1.17       -- arithmetic
  AS priceGST
  FROM catalog;

  /* union */
    -- Note: The UNION operator selects only distinct values by default. To allow duplicate values, use "UNION ALL"
    SELECT column_name(s) FROM table1
    UNION
    SELECT column_name(s) FROM table2;
  /* minus */
    

  /* grouping: split up table into buckets */
    -- note: whatever columns that appear in SELECT must also appear in GOUP BY
    SELECT book        -- selects the book from each book bucket (works exactly like UNIQUE)
    FROM loan
    GROUP BY book;

    SELECT borrower, borrowed_date, COUNT(book)
    FROM loan
    GROUP BY borrower, borrowed_date;  -- unlike ORDER BY, order doesn't matter here

    SELECT l.borrower
    FROM loan l
    GROUP BY l.borrowed, l.borrower
    HAVING COUNT(l.book) > 1;          -- aggregate conditionals on GROUP BY (cannot use WHERE). It applies to each group bucket

  /* aggregate queries: MAX(), MIN(), AVG(), STD(), SUM() etc. */ 
    -- NOTE: aggregate functions cannot be used in the WHERE clause
    SELECT COUNT(*) FROM book;                          -- counts all entries in book

    SELECT COUNT(title) from book;                      -- counts non NULL entries in title

    SELECT COUNT(DISTINCT column_name) FROM table_name; -- counts number of distinct values from table

    SELECT NATIONALITY, AVG(SALARY)                     -- prints the average salary of entries for each nationality bucket
    FROM EMPLOYEE
    GROUP BY NATIONALITY;

/* basic update */
  UPDATE table_name
  SET column1=value1, column2=value2, ...
  WHERE some_column=some_value;

/* delete entries */
  DELETE FROM table_name;  -- delete all of table entires but keep table 
  
  DELETE FROM table_name   -- delete entries that falls within condition
  WHERE some_column=some_value; -- note: quotes have to be placed also on boolean values. e.g. some_bool='TRUE'

/* modify entries */
  ALTER TABLE table_name        -- add new column
  ADD column_name domain_type;

  ALTER TABLE table_name        -- modify exisitng column
  MODIFY column_name datatype

  ALTER TABLE table_name        -- delete column
  DROP COLUMN column_name

/* integrity constraints */
  /* primary key (also enforces NOT NULL and UNIQUE) */
    ISBN13 CHAR(14) PRIMARY key     -- singular
    PRIMARY KEY (owner, book, copy) -- composite

  /* foreign key */
    column_name VARCHAR(256) REFERENCES other_table(other_table_PK)     -- singular
    FOREIGN KEY (owner, book, copy) REFERENCES copy(owner, book, copy)  -- composite
    -- ON UPDATE/DELETE
      CASCADE
      NO ACTION
      SET DEFAULT 
      SET NULL

  /* not null */
    ISBN10 CHAR(10) NOT NULL
  
  /* unique (do not enforce NOT NULL. i.e. permits multiple null values) */
    ISBN10 CHAR(10) UNIQUE          -- singular
    UNIQUE (first_name, last_name)  -- composite
  
  /* check */
    age INT CHECK(age>0)                                  -- column check

    check (death_date > birth_date OR death_date is NULL) -- table constraint without naming

    CONSTRAINT positive_val CHECK(age>0)                  -- table constraint with naming to help identify violations
    
    CREATE ASSERTION no_student_staff                     -- CHECK constraints that are declared outside tables
      CHECK(NOT EXISTS (SELECT * FROM staff, student WHERE staff.id = student.id))

/* tuple variables (alias) */
  SELECT s.name, b.title
  FROM student s, copy c, book b
  WHERE s.email=c.owner
  AND c.book=b.ISBN13;

/* conditionals */
  email like('%@%.com') -- where % is the wildcard character
  format = 'paperback' OR format = 'hardcover'

/* NLS_DATE_FORMAT (specifies the default date format to use with the TO_CHAR and TO_DATE functions) */
alter session set NLS_DATE_FORMAT = 'YYYY-MM-DD'

/* triggers */
  /* a trigger is a piece of SQL to execute either before or after an update, insert, or delete in a database */
  CREATE TRIGGER trigger_name
  AFTER UPDATE
    INSERT INTO CustomerLog (column1, ...)
    SELECT column1, ... FROM deleted

/* misc */
  -- conitionals can be TRUE/FALSE or UNKNOWN for cases dealing with NULL values
  set define off  -- disable special character such as '&'
  O''reilly       -- single quotes are escaped by doubling
