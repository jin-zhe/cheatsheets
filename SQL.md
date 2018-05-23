# SQL Cheatsheet

## Domain types
```sql
CHAR(n)       -- fixed-length character string, with user-specified length.
VARCHAR(n)    -- variable-length character string, with user-specified maximum length.
INT           -- (also: INTEGER) an integer (length is machine-dependent).
DATE          -- a calendar date, containing four digit year, month, and day of the month.
TIMESTAMP     -- the time of the day in hours, minutes, and seconds.
FLOAT(n)      -- floating-point, with user-specified precision of at least n digits.
SMALLINT      -- a small integer (length is machine-dependent).
NUMERIC(p, d) -- a fixed-point number with user-specified precision, consists of p digits (plus a sign) and d of p digits are to the right of the decimal point. E.g., numeric(3, 1) allows 44.5 to be stored exactly but not 444.5.
REAL          -- (also: DOUBLE PRECISION) floating-point or double-precision floating-point numbers, with machine-dependent precision.
```

## Operator order
```sql
SELECT
FROM
WHERE
GROUP BY
HAVING
ORDER BY
```

## Basic create
```sql
CREATE TABLE book(
  title VARCHAR(256),
  authors VARCHAR(256),
  format CHAR(9) DEFAULT 'paperback',
  pages INT,
  year DATE,
  ISBN13 CHAR(14)
);
```

## Basic insert
```sql
INSERT INTO student VALUES(...), (...), ...;            -- insert all values in the order defined during table creation
```
```sql
INSERT INTO student (email, name, faculty, department)  -- insert only values indicated by the ones list and in that order
VALUES (...), (...), ...;
```

## Delete table
```sql
DROP TABLE loan;
```

## Querying
Display all columns from table:
```sql
SELECT * FROM table_name;
```
Display indicated columns from table:
```sql
SELECT column_name, column_name
FROM table_name;
```
Display indicated columns from table with condition:
```sql
SELECT name, email
FROM student
WHERE department='CS';
```
Select from multiple tables:
```sql
SELECT student.name, book.title
FROM student, copy, book
WHERE student.email=copy.owner
AND copy.book=book.ISBN13;
```
Renaming colums for output (purely cosmetic):
```sql
SELECT s.name AS owner
FROM loan l, student s
WHERE s.email=l.owner
  AND l.returned > '2010-03-04'
  AND l.borrower = 'abc@mail.com';
```
Removing duplicates in a single row:
```sql
SELECT DISTINCT nationality
FROM student;
```
Selecting only unique tuples:
```sql
SELECT DISTINCT nationality, last_name
FROM student;
```
Ordering (default asc):
```sql
SELECT name
FROM student
ORDER BY matric_num DESC;
```
Multiple ordering (default asc):
```sql
SELECT name
FROM student
ORDER BY nationality, name;     -- order first by nationality then by name within same nationality
```
Arithmetic:
```sql
SELECT book, price * 1.17
AS priceGST
FROM catalog;
```

## Union
Note: The UNION operator selects only distinct values by default. To allow duplicate values, use `UNION ALL`
```sql
SELECT column_name(s) FROM table1
UNION
SELECT column_name(s) FROM table2;
```
## Minus
TODO

## Group
Splitting up table into buckets.  
**Note: whatever columns that appear in SELECT must also appear in `GROUP BY`**
```sql
SELECT book        -- selects the book from each book bucket (works exactly like UNIQUE)
FROM loan
GROUP BY book;
```
```sql
SELECT borrower, borrowed_date, COUNT(book)
FROM loan
GROUP BY borrower, borrowed_date;  -- unlike ORDER BY, order doesn't matter here
```
```sql
SELECT l.borrower
FROM loan l
GROUP BY l.borrowed, l.borrower
HAVING COUNT(l.book) > 1;          -- aggregate conditionals on GROUP BY (cannot use WHERE). It applies to each group bucket
```

## Aggregate queries
E.g. `MAX()`, `MIN()`, `AVG()`, `STD()`, `SUM()` etc  
**NOTE: aggregate functions cannot be used in the `WHERE` clause**
```sql
SELECT COUNT(*) FROM book;                          -- counts all entries in book
```
```sql
SELECT COUNT(title) from book;                      -- counts non NULL entries in title
```
```sql
SELECT COUNT(DISTINCT column_name) FROM table_name; -- counts number of distinct values from table
```
```sql
SELECT NATIONALITY, AVG(SALARY)                     -- prints the average salary of entries for each nationality bucket
FROM EMPLOYEE
GROUP BY NATIONALITY;
```

## Basic update
```sql
UPDATE table_name
SET column1=value1, column2=value2, ...
WHERE some_column=some_value;
```

## Delete entries
```sql
DELETE FROM table_name;  -- delete all of table entires but keep table 
```
```sql
DELETE FROM table_name   -- delete entries that falls within condition
WHERE some_column=some_value; -- note: quotes have to be placed also on boolean values. e.g. some_bool='TRUE'
```

## Modify entries
```sql
ALTER TABLE table_name        -- add new column
ADD column_name domain_type;
```
```sql
ALTER TABLE table_name        -- modify exisitng column
MODIFY column_name datatype
```
```sql
ALTER TABLE table_name        -- delete column
DROP COLUMN column_name
```

## Integrity constraints
### Primary key
Automatically enforces `NOT NULL` and `UNIQUE`
```sql
ISBN13 CHAR(14) PRIMARY key     -- singular
PRIMARY KEY (owner, book, copy) -- composite
```
### Foreign key
Singular:
```sql
column_name VARCHAR(256) REFERENCES other_table(other_table_PK)     -- singular
```
Composite
```sql
FOREIGN KEY (owner, book, copy) REFERENCES copy(owner, book, copy)  -- composite
```
Update/delete rules:
```sql
-- ON UPDATE/DELETE
  CASCADE
  NO ACTION
  SET DEFAULT 
  SET NULL
```
### NOT NULL
```sql
ISBN10 CHAR(10) NOT NULL
```
### Unique
NOTE: Does not enforce `NOT NULL`. i.e. permits multiple null values)  
Singular:
```sql
ISBN10 CHAR(10) UNIQUE
```
Composite:
```sql
UNIQUE (first_name, last_name)
```

### Check
Column check:
```sql
age INT CHECK(age>0)
```
Table constraint without naming:
```sql
check (death_date > birth_date OR death_date is NULL)
```
Table constraint with naming to help identify violations:
```sql
CONSTRAINT positive_val CHECK(age>0)
```
`CHECK` constraints that are declared outside tables:
```sql
CREATE ASSERTION no_student_staff
  CHECK(NOT EXISTS (SELECT * FROM staff, student WHERE staff.id = student.id))
```

## Tuple variables (alias)
```sql
SELECT s.name, b.title
FROM student s, copy c, book b
WHERE s.email=c.owner
AND c.book=b.ISBN13;
```

## Conditionals
```sql
email like('%@%.com') -- where % is the wildcard character
format = 'paperback' OR format = 'hardcover'
```

## Date format
specifies the default date format to use with the `TO_CHAR` and `TO_DATE` functions
```sql
alter session set NLS_DATE_FORMAT = 'YYYY-MM-DD'
```

## Triggers
A trigger is a piece of SQL to execute either before or after an update, insert, or delete in a database
```sql
CREATE TRIGGER trigger_name
AFTER UPDATE
  INSERT INTO CustomerLog (column1, ...)
  SELECT column1, ... FROM deleted
```

## Misc
Conitionals can be `TRUE/FALSE` or `UNKNOWN` for cases dealing with `NULL` values
```sql
set define off  -- disable special character such as '&'
O''reilly       -- single quotes are escaped by doubling
```
