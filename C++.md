# C++ Cheatsheet

Unless otherwise specified, this is written for C++11.

---
## Table of Contents
- [General](#general)
  - [Importing](#importing)
  - [Primitive data types](#primitive-data-types)
    - [Character](#character)
    - [Type casting](#type-casting)
  - [Other data types](#other-data-types)
    - [C-Style Array](#c-style-array)
    - [Strings](#strings)
    - [Pointer](#pointer)
    - [Reference](#reference)
  - [Operators](#operators)
    - [Assignment](#assignment)
    - [Arithmetic](#arithmetic)
    - [Compound Assignment](#compound-assignment)
    - [Increment and Decrement](#increment-and-decrement)
    - [Relational and comparison operators](#relational-and-comparison-operators)
    - [Logical operators](#logical-operators)
    - [Conditional ternary operator](#conditional-ternary-operator)
    - [Bitwise operators](#bitwise-operators)
  - [Type alias](#type-alias)
  - [Macro definitions](#macro-definitions)
  - [Control flow](#control-flow)
    - [Selection](#selection)
    - [Repetition](#repetition)
  - [Math libraries](#math-libraries)
    - [`cmathh`](#cmath)
    - [`numeric_limits`](#numberic_limits)
- [STL](#stl)
  - [Utility](#utility)
    - [`std::pair`](#stdpair)
    - [`std::tuple`](#stdtuple)
  - [Containers](#containers)
    - [Operators](#operators-1)
    - [Structured bindings](#structured-bindings)
    - [Common functions](#common-functions)
    - [Sequence Containers](#sequence-containers)
      - [`std::array`](#stdarray)
      - [`std::vector`](#stdvector)
      - [`std::list`](#stdlist)
      - [`std::deque`](#stddeque)
    - [Container adaptors](#container-adaptors)
      - [`std::queue`](#stdqueue)
      - [`std::priority_queue`](#stdpriority_queue)
      - [`std::stack`](#stdstack)
    - [Associative containers](#associative-containers)
      - [`std::set`, `std::multiset`](#stdset-stdmultiset)
      - [`std::map`, `std::multimap`](#stdmap-stdmultimap)
    - [Unordered associative containers](#unordered-associative-containers)
      - [`std::unordered_set`, `std::unordered_multiset`](#stdunordered_set-stdunordered_multiset)
      - [`std::unordered_map`, `std::unordered_multimap`](#stdunordered_map-stdunordered_multimap)
  - [Algorithm](#algorithm)
    - [`std::binary_search`](#stdbinary_search)
    - [`std::copy`, `std::copy_if`](#stdcopy-stdcopy_if)
    - [`std::count`, `std::count_if`](#stdcount-stdcount_if)
    - [`std::equal_range`](#stdequal_range)
    - [`std::fill`](#stdfill)
    - [`std::max`](#stdmax)
    - [`std::max_element`](#stdmax_element)
    - [`std::random_shuffle`](#stdrandom_shuffle)
    - [`std::remove`, `std::remove_if`](#stdremove-stdremove_if)
    - [`std::reverse`](#stdreverse)
    - [`std::sort`, `std::stable_sort`](#stdsort-stdstable_sort)
    - [`std::lower_bound`](#stdlower_bound)
    - [`std::upper_bound`](#stdupper_bound)
  - [Iterators](#iterators)
    - [Iterating an iterable](#iterating-an-iterable)
    - [Common manipulations](#common-manipulations)
- [I/O](#io)
  - [`iostream`](#iostream)
    - [Optimization for competitive programming](#optimization-for-competitive-programming)
    - [`std::cin`](#stdcin)
    - [`std::cout`](#stdcout)
  - [`stdio.h`](#stdioh)
    - [`printf`](#printf)
    - [`scanf`](#scanf)
  - [`sstream`](#sstream)
    - [`std::stringstream`](#stdstringstream)
    - [`std::istringstream`](#stdistringstream)
    - [`freopen`, `fclose`](#freopen-fclose)
- [OOP](#oop)
  - [Struct](#struct)
- [Custom utils](#custom-utils)
  - [String to char array](#string-to-char-array)
  - [Substring](#substring)
  - [Tokenize](#tokenize)
  - [Reading until empty line](#reading-until-empty-line)
  - [Reading 2D char array](#reading-2d-char-array)
  - [Printing 1D int array](#printing-1d-int-array)
  - [Index to iterator](#index-to-iterator)
  - [Iterator to index](#iterator-to-index)
  - [Binary search](#binary-search)


---

## General
### Importing
```cpp
#include <package_name>
using namespace std;      // This will be assumed for the remaining of this cheatsheet
```

Sometimes you may want to import everything available to your compiler. This is usually a bad idea in the case of software engineering, but may be convenient for quick testing and simple codes. To do so:
```cpp
#include <bits/stdc++.h>
```
For a list of what libraries are included with that import, see [here](https://gcc.gnu.org/onlinedocs/gcc-4.6.2/libstdc++/api/a01040_source.html)



### Primitive data types
Below are some commonly used primitive types. For the full list, please refer to [here](https://en.cppreference.com/w/cpp/language/types).

| Data Type   | Size (Bytes)  | Typical Range*            |
| ----------- |:-------------:| :------------------------:|
| `bool`      | 1             | \[`false`, `true`\]       |
| `char`      | 1             | ±127 OR \[0, 255\]        |
| `int`       | 4             | ±(2^16 - 1) OR ±(2^32 - 1)|
| `long`      | 4             | ±(2^32 - 1) OR ±(2^64 - 1)|
| `long long` | 8             | ±(2^64 - 1)               |
| `float`     | 4             | ±3.4e(±38)  (~7 digits)   |
| `double`    | 8             | ±1.7e(±308) (~15 digits)  |

* \*: Range can differ due to implementation specific definitions
* (2^16 - 1) = 65,535
* (2^32 - 1) = 2,147,483,648
* (2^64 - 1) = 18,446,744,073,709,551,615

#### Character
Checking for space `' '`, horizontal tab `'\t'`, newline (LF) `'\n'`, vertical tab (VT) `'\v'`, feed (FF) `'\f'`, carriage return (CR) `'\r'`
```cpp
char sp = ' ';
char tb = '\t';
char lf = '\n';
char vt = '\v';
char ff = '\f';
char cr = '\r';
assert(isspace(sp), 8192);  //=> assertion: true
assert(isspace(tb), 8192);  //=> assertion: true
assert(isspace(lf), 8192);  //=> assertion: true
assert(isspace(vt), 8192);  //=> assertion: true
assert(isspace(ff), 8192);  //=> assertion: true
assert(isspace(cr), 8192);  //=> assertion: true
```

Converting between character of numbers to character:
```cpp
char char_five = '5';
int  int_five  = char_five - '0'; //=> 5
```
#### Type casting
```cpp
int i;
float pi = 3.14;

// Both methods below are equivalent
i = (int) pi;
i = int (pi);
```



### Other data types
#### C-Style Array
##### Initializations
```cpp
int arr[3] = {1, 2, 3}; //=> [1, 2, 3]
int arr[5] = {1, 2, 3}; //=> [1, 2, 3, 0, 0]  // unspecified values are assigned default values
int arr[5] = {};        //=> [0, 0, 0, 0, 0]
int arr[5];             //=> [?, ?, ?, ?, ?]
int arr[] = {1, 2, 3}   //=> [1, 2, 3]        // implicit size understood by compiler
int arr[] {1, 2, 3}     //=> [1, 2, 3]        // universal initialization
```
Note array size cannot be initialized with a variable. i.e. the following is illegal
```cpp
int n = 100;
int arr[n] = {0};
```
Instead, consider using [`std::vector`](#stdvector)
##### Common operations
Array size
```cpp
int size = int n = sizeof(arr) / sizeof(arr[0]);
```
Array copy 
* items exceeding size of dest will be ignored
* `begin()` and `end()` only works for arrays and not array pointer/references
```cpp
copy(begin(src), end(src), begin(dest));
```
Note that C-style arrays does not enjoy the convenience of C++11's foreach loop. Instead consider using `std::array`

#### Strings
In C++ and C, a string is an array of `char` terminated with the null character `\0`.

However `std::string` is treated differently from `c-string`

Strings are mutable in C++. This behaviour differs from other languages such as Java.

##### Import
```cpp
#include <string>
````

##### Initialization and declaration
```cpp
// Assignment via string literal
string str = "Hello world!";

// Initialization using char array
char arr[] = "Hello world!";
string str(arr);
```
##### Accessing chars
```cpp
string hello = "Hello";
str.at(0); //=> 'H'
str[0];    //=> 'H'
```
##### Parsing
`int` <-> `string`
```cpp
to_string(42); //=> "42"
stoi("42");    //=> 42
```
Parse `char` as string:
```cpp
char c = 'c';

// Method 1
string str = std::string() + c; //=> "c"

// Method 2
string str;
str.push_back(c);
```
##### Length
Both `.length()` and `.size()` (UTF-8) may be used.
```cpp
string str = "Hello";
str.length(); //=> 5
str.size();   //=> 5
```
##### Concatenation
C++ strings can be concatenated simply using the `+` operator
```cpp
string str = "Hello" + " " + "World!";
assert(str, "Hello World!");  //=> assertion true
```
##### Appending
The `+=` operator is the most straightforward and generalised form of appending. However you may also use `push_back(c)` for appending a character or `apppend(str)` for appending a string.
```cpp
string str = "Hello";
str += " World";      // str: "Hello World"
str.push_back('!');   // str: "Hello World!"
str.append(" Hi!");   // str: "Hello World! Hi!"
```
##### Comparison
Either the relational operators or the function `compare` may be used
```cpp
string str = "Hello";
assert(str == "Hello");       //=> assertion true
assert(str < "Hello World!"); //=> assertion true
assert(str < "hello");        //=> assertion true
str.compare("Hello");         //=> 0
str.compare("I");             //=> -1
str.compare("J");             //=> -2
```
##### Search
[find](http://www.cplusplus.com/reference/string/string/find/)
```cpp
string str = "Hello World";
size_t pos = str.find("World");         //=> 6
size_t pos = str.find("o", 6);          //=> 7
size_t pos = str.find("Hey");           //=> string::npos
```
[rfind](http://www.cplusplus.com/reference/string/string/rfind/)
```cpp
string str = "Hello World";
size_t pos = str.rfind("o");            //=> 7
size_t pos = str.rfind("o", 6);         //=> 4
```

[find_last_of](http://www.cplusplus.com/reference/string/string/find_last_of/)
```cpp
string str = "Hello World";
size_t pos = str.find_last_of('o');     //=> 7
```

[find_last_not_of](http://www.cplusplus.com/reference/string/string/find_last_not_of/)
```cpp
string str = "Hello World       ";
size_t pos = str.find_last_not_of(' '); //=> 10
```
##### [Substring](http://www.cplusplus.com/reference/string/string/substr/)
Note that the second argument for `substr` is the length of substring to take and **not** the past-the-end index!
```cpp
string str = "Hello World!";
string str2 = str.substr(6, 5);         //=> "World"
string str3 = str.substr(6);            //=> "World!"
```
Quick and dirty way of getting a substring from an index to the end of string:
```cpp
string a = "abc";
string b = &a[1];
assert(b, "bc");  //=> assertion true
```
##### [Erase](http://www.cplusplus.com/reference/string/string/erase/)
```cpp
str.erase(pos_begin, length);   // Erase a range of characters via (size_t) pos_begin, (size_t) length
str.erase(it_begin, it_end);    // Erase a range of characters via (iterator) it_begin, (iterator) it_end
str.erase(it);                  // Erase a single character via iterator
```
##### [Replace](http://www.cplusplus.com/reference/string/string/replace/)
Using positions
```cpp
// Replace position range [start_pos_1, start_pos_1 + length_1) in str1 with str2
str1.replace(start_pos_1, length_1, str2); 

// Replace position range [start_pos_1, start_pos_1 + length_1) in str1 with position range [0, length_2) in str2
str1.replace(start_pos_1, length_1, str2, length_2);

// Replace position range [start_pos_1, start_pos_1 + length_1) in str1 with position range [start_pos_2, start_pos_2 + length_2) in str2
str1.replace(start_pos_1, length_1, str2, start_pos_2, length_2);
```
Using iterators
```cpp
// Replace iterator range [it_start_1, it_end_1) in str1 with str2
str1.replace(it_start_1, it_end_1, str2);

// Replace iterator range [it_start_1, it_end_1) in str1 with position range [0, length_2) in str2
str1.replace(it_start_1, it_end_1, str2, length_2);

// Replace iterator range [it_start_1, it_end_1) in str1 with iterator range [it_start_2, it_end_2) in str2
str1.replace(it_start_1, it_end_1, str2, it_start_2, it_end_2);
```

#### Pointer
##### Basics
```cpp
int a = 3;
int *ptr1;              // Declaration
ptr1 = &a;              // Assignment
cout << *ptr1 << endl;  // De-reference to retrieve value
*ptr1 = 4;              // Modify value
cout << a << endl;      //=> 4

int b = 6;
int *ptr2 = &b;
ptr1 = ptr2;            // Re-assignment
cout << *ptr1 << endl;  //=> 6
cout << a << endl;      //=> 4
```
##### Object pointers
```cpp
MyObject* my_object = new MyObject();

/* The following are equivalent when accessing attributes of an object pointer */
(*my_object).attr1;
my_object->attr1;
```
#### Reference
[Pointers vs references](https://stackoverflow.com/questions/57483/what-are-the-differences-between-a-pointer-variable-and-a-reference-variable-in)
##### Basics
```cpp
int a = 3;
int &ref = a;
cout << ref;    // Acess value of reference
```
##### Examples
Swap function
```cpp
void swap(int &a, int &b) {
  int temp = a;
  a = b;
  b = temp;
}
```
By default C++ passes by value (i.e make copy). Thus when writing functions to modify objects, be sure to pass (and return) them via reference!
```cpp
void update_val(vector<int> &vect, int index, int val) {
  vect[index] = val;
}

queue<int> & get_curr_queue(bool on_left, queue<int> &left_queue, queue<int> &right_queue) {
  return (on_left)? left_queue : right_queue;
}
queue<int> &curr_queue = get_curr_queue(on_left, left_queue, right_queue); // Important! If not assigning to a reference, a copy is made instead
```



### Operators
See [here](http://www.cplusplus.com/doc/tutorial/operators/) for the full list of C++ operators.
#### Assignment
```cpp
y = x;
```
Assigns variable y with the value of x. Note however that if `Y` is [copy assignable](https://en.cppreference.com/w/cpp/named_req/CopyAssignable), then `=` will be a [copy assignment operator](https://en.cppreference.com/w/cpp/language/copy_assignment) so `Y` will take on a copy of `x` at the end of the operation.

#### Arithmetic
| Operator | Description   |
|:--------:|:-------------:|
| `+`      | Addition      |
| `-`      | Subtraction   |
| `*`      | Multiplication|
| `/`      | Division      |
| `%`      | Modulo        |

#### Compound Assignment
|Expression | Equivalence  |
|:---------:|:------------:|
| `y += x;` | `y = y + x;` |
| `y -= x;` | `y = y - x;` |
| `y *= x;` | `y = y * x;` |
| `y /= x;` | `y = y / x;` |
| `y %= x;` | `y = y % x;` |

#### Increment and Decrement
|Expression | Equivalence        |
|:---------:|:------------------:|
| `y = ++x;` | `x += 1; y  = x;` |
| `y = x++;` | `y  = x; x += 1;` |
| `y = --x;` | `x -= 1; y  = x;` |
| `y = x--;` | `y  = x; x -= 1;` |

#### Relational and comparison operators
| Operator | Description              |
|:--------:|:------------------------:|
| `==`     | Equal to                 |
| `!=`     | Not equal to             |
| `<`      | Less than                |
| `>`      | Greater than             |
| `<=`     | Less than or equal to    |
| `>=`     | Greater than or equal to |

#### Logical operators
| Operator | Description  |
|:--------:|:------------:|
| `!`      | Logical NOT  |
| `&&`     | Logical AND  |
| `\|\|`   | Logical OR   |

#### Conditional ternary operator
```cpp
x = (predicate)? consequent: alternative;
```
Is equivalent to:
```cpp
if (predicate)
  x = consequent;
else
  x = alternative;
```
#### Comma operator
> In the C and C++ programming languages, the comma operator (represented by the token ,) is a binary operator that evaluates its first operand and **discards the result**, and then evaluates the second operand and returns this value (and type). The use of the comma token as an operator is distinct from its use in function calls and definitions, variable declarations, enum declarations, and similar constructs, where it acts as a separator. [source](https://en.wikipedia.org/wiki/Comma_operator)

Example:
```cpp
int a,b;
a = (b=3, b+2); //=> a = 5;
```
This can be particularly useful for reading inputs that are terminated by a given condition, for instance:
```cpp
// While loop terminates when a == b == c == d == 0
while(cin >> a >> b >> c >> d, a || b || c || d) {
  // Do something
}
```
#### Bitwise operators
| Operator | Description     |
|:--------:|:---------------:|
| `&`      | Bitwise AND     |
| `\|`     | Bitwise OR      |
| `^`      | Bitwise XOR     |
| `~`      | NOT             |
| `<<`     | Bit-shift left  |
| `>>`     | Bit-shift right |



### Type alias
* Type alias using `typddef` is a means for us to provide alternative naming for a type
* This is often done to provide a convenient shorthand for referring to verbose types
* It also serve as a basic way of providing data abstraction
```cpp
typedef string nusnet_id;
typedef string name;
typedef string grade;
typedef vector<tuple<nusnet_id, name, grade>> grades;
// ...
grades CS2040C;
CS2040C.push_back(make_tuple("A0123456I", "Kattis", "A+"));
```
### Macro definitions
* Preprocessor macro is indicated by the directive `#define <identifier> <replacement>`
* Preprocessor will replace any subsequent occurence of `<identifier>` in the code with the `<replacement>`
* `<replacement>` can be an expression, a statement, a block or simply any code snippet
* Note that preprocessor do not check for C++ syntax! It simply carries out pattern matching and replacement!
* You can unset a preprocessor macro using `#undefine <identifier>`

The following is an example of defining a shorthand for for-loop using preprocessor macro:
```cpp
#define loop(n) for(int i=0; i<n; i++)
loop(5) {
  cout << i << ", ";  // Prints: 0, 1, 2, 3, 4
}
```



### Control flow
#### Selection
##### If-else statement
```cpp
if (condition_1) {
  // Do something
}
else if (condition_2) {
  // Do something
}
else {
  // Do something
}
```
##### Switch statement
```cpp
int test = 1;
switch(test) {
  case 1 : cout << '1'; // prints "1"
           break;       // and exits the switch
  case 2 : cout << '2';
           break;
  // ...
  default:
           cout << 'Default case';
           break;
}
```
If declaration statement exists within a case, it has to be scoped. e.g.
```cpp
switch(1) {
  case 1: {  int x = 0;
             std::cout << x << '\n';
             break;
          } // scope of 'x' ends here
  default: std::cout << "default\n"; // no error
           break;
}
```

#### Repetition
##### For-loop
```cpp
for (int i=0; i<n; ++i) {
  // ...
}

// a is a copy of the items we are iterating over
for (auto a : s) {
  cout << a << " ";
}

// a is a reference of the items we are iterating over
for (auto &a : s) {
  cout << a << " ";
}  
```
##### While-loop
```cpp
while(loop_conditon) {
   // ...
}

int n = 5;
while(--n) {
  // n = 4, 3, 2, 1
}

int m = 5;
while(m--) {
  // m = 4, 3, 2, 1, 0
}
```
##### Do-while-loop
```cpp
do {
   // ...
}
while (loop_condition);
```

### Math libraries
#### [`cmath.h`](https://en.cppreference.com/w/cpp/numeric/math)
```cpp
#import <math.h>
```
##### [`floor`](https://en.cppreference.com/w/cpp/numeric/math/floor)
```cpp
floor(+2.7);      //=> 2.000000
floor(-2.7);      //=> -3.000000
floor(-0.0);      //=> -0.000000
floor(-INFINITY); //=> -INFINITY
```
##### [`ceil`](https://en.cppreference.com/w/cpp/numeric/math/ceil)
```cpp
ceil(+2.4);       //=> 3.000000
ceil(-2.4);       //=> -2.000000
ceil(-0.0);       //=> -0.000000
ceil(-INFINITY);  //=> -INFINITY
```
##### [`pow`](https://en.cppreference.com/w/cpp/numeric/math/pow)
```cpp
pow(2, 10);   //=> 1024
pow(2, 10.0); //=> 1024.0
```
##### [`Infinity`](https://en.cppreference.com/w/c/numeric/math/INFINITY)
`INFINITY` is a macro for numberic types supporting floating-point infinites.
```cpp
int     inf_int = INFINITY; //=> 4196512 (unsupported)
long    inf_lng = INFINITY; //=> 160     (unsupported)
float   inf_flt = INFINITY; //=> inf
double  inf_dbl = INFINITY; //=> inf
```

#### [`numberic_limits`](https://en.cppreference.com/w/cpp/types/numeric_limits/infinity)
Example
```cpp
#include <limits>
double max = numeric_limits<double>::max();
double inf = numeric_limits<double>::infinity();
assert(inf > max);  //=> assertion true
```

---

## [STL](http://www.cplusplus.com/reference/stl/)
The C++ Standard Template Library (STL) is a set of template classes that provides standard data structures (DS) and their associated ADT operations. It is a library consisting of the following:

* Algorithm (e.g. sorting, searching etc.)
* Containers: Stores objects and data
  * Sequence Containers: DS for accessing data in sequential manner
    * `arrays`, `vector`, `list`, `deque`, `forward_list`
  * Container Adaptors: Provides abstracted interface for sequential containers
    * `queue`, `priority_queue`, `stack`
  * Associative Containers: Ordered DS where an item can be searched in O(log n) time
    * `set`, `multiset`, `map`, `multimap`
  * Unordered Associative Containers: Unordered DS where an item is supported by random access
    * `unordered_set`, `unordered_multiset`, `unordered_map`, `unordered_multimap`
* Utility Library: `pair`
* Iterators
* Functions
* Numeric algorithms



### [`utility`](https://en.cppreference.com/w/cpp/utility)
#### [`std::pair`](https://en.cppreference.com/w/cpp/utility/pair)
##### Import
```cpp
#include <utility>
```
##### Declaration and initialization
```cpp
pair<int,int> p(1,2);
pair<int,int> p = make_pair(1,2);
pair<int,int> p = {1,2};
```
##### Accessor
```cpp
int first = p.first;  //=> 1
int first = p.second; //=> 2
```
##### Modifier
```cpp
p.first = 0;
```

#### [`std::tuple`](https://en.cppreference.com/w/cpp/utility/tuple)
##### Import
```cpp
#include <tuple>
```
##### Declaration and initialization
```cpp
tuple<int,int,int> triplet(1,2,3);
tuple<int,int,int> triplet = make_tuple(1,2,3);
tuple<int,int,int> triplet = {1,2,3};
```
##### Accessor
```cpp
int first = get<0>(triplet); //=> 1
```
##### Modifier
```cpp
get<0>(triplet) = 0;
```



### [Containers](https://en.cppreference.com/w/cpp/container)
#### Operators
Containers of primitive types can be directly compared using relational and comparison operators, for instance:
``` cpp
pair<int,int> p1(1,2);
pair<int,int> p2(1,2);
pair<int,int> p3(1,4);
assert(p1 == p2);   //=> assertion true
assert(p3 > p1);    //=> assertion true

tuple<int,int> t1(1,2,3);
tuple<int,int> t2(1,2,3);
tuple<int,int> t3(1,2,4);
assert(t1 == t2);   //=> assertion true
assert(t3 > t1);    //=> assertion true

vector<int> v1 = {1,2,3,4,5};
vector<int> v2 = {1,2,5,6,7};
vector<int> v3 = {2};
assert(v2 > v1);    //=> assertion true
assert(v3 > v2)     //=> assertion true
```
STL containers are [copy assignable](https://en.cppreference.com/w/cpp/named_req/CopyAssignable) and so `=` operator will serve as [copy assignment operator](https://en.cppreference.com/w/cpp/language/copy_assignment) if LHS of the expression is not a pointer or reference. To illustrate:
```cpp
vector<int> vect1  = {1,2,3};
vector<int> vect2  = vect1; // vect2 is a copy of vect1
vector<int> &vect3 = vect1; // vect3 refers to the same vector as vect1 
```
#### Structured bindings
Since C++17, [strutcured bindings](https://en.cppreference.com/w/cpp/language/structured_binding) provide a convenient way to unpack values in containers.
```cpp
tuple<int,float,string> t_iii = {1,3.14,"Hello"};
auto [first, second, third] = t_iii;
assert(first, 1);         //=> Assertion true
assert(second, 3.14);     //=> Assertion true
assert(third, "Hello");   //=> Assertion true
```
#### Common functions
##### `insert`
`<container>.insert(it, val)` inserts the reference of given argument `val` into container at position specified by iterator `it`. It returns an iterator pointing to the inserted value. For `<vector>` this is a O(N) procedure. For `<list>` this is O(1).
```cpp
vector<int>::iterator it;
vector<int> vect = {1,2,4,5};

/* Prepending to the front */
it = vect.begin();
it = vect.insert(it, 0);  // vect: {0,1,2,4,5}
cout << *it << endl;      //=> 0

/* Inserting in bewteen */
it = vect.begin() + 3;
it = vect.insert(it, 3);  // vect: {0,1,2,3,4,5}
cout << *it << endl;      //=> 3

/* Appending to the back */
it = vect.end();
it = vect.insert(it, 6);  // vect: {0,1,2,3,4,5,6}
cout << *it << endl;      //=> 6
```
###### Pitfall
> Causes reallocation if the new `<container>.size()` is greater than the old `<container>.capacity()`. **If the new `size()` is greater than `<container>.capacity()`,  all iterators and references are invalidated. Otherwise, only the iterators and references before the insertion point remain valid.** The past-the-end iterator is also invalidated. [source](https://en.cppreference.com/w/cpp/container/vector/insert)

So it is important to update relevant iterator(s) with the returned iterator or re-assign them after calling `.insert()`!

##### `emplace`
`<container>.emplace(it, args...)` inserts a new element constructed by given construction argument(s) into container at position specified by iterator `it`. Unlike `<container>.insert(...)` which receives a reference as argument and then copies the contents of referenced object into the new element, `<container>.emplace(...)` constructs the new element in-place using the given construction argument(s) and inserts it into the container. It returns an iterator pointing to the newly constructed element.

The operations and pitfalls are identical to `<container>.insert(...)` so refer to [`insert`](#insert) for specifics.

For containers of primitives, it doesn't really matter if `emplace` or `insert` is used, but for objects, use of `emplace` is preferred for efficiency reasons. This is highlighted in the following example:
```cpp
vector<pair<int,int>> vect;
vect.emplace(vect.begin(),1,2);             // new pair to be inserted is constructed in-place
vect.insert (vect.begin(),make_pair(3,4));  // pair is first constructed, then passed as arugment, then its value copied to newly inserted element. So initial construction before passing in as arugment is wasteful
```
##### `erase`
`<container>.erase(start, end)` removes all items from `start` inclusive to `end` exclusive. i.e. `\[start, end)`. If `end` is not supplied as arugment, just remove the single item at `start`. It returns iterator following the last removed element. If the iterator position refers to the last element, the `<container>.end()` iterator is returned. For `<vector>` this is a O(N) procedure. For `<list>` this is O(1).
```cpp
vector<int> vect = {0,1,2,3,4,5};
vector<int>::iterator it;

/* If erasing iterator item at non-last position, returned iterator is automatically advanced to the next item */
it = vect.begin() + 2;
it = vect.erase(it);          // vect: {0,1,3,4,5}
cout << *it << endl;          //=> 3

it = vect.begin() + 1;
it = vect.erase(it, it + 3);  // vect: {0,5}
cout << *it << endl;          //=> 5

/* If erasing iterator item at last position, returned iterator is new end iterator */
it = vect.end() - 1;
it = vect.erase(it);          // vect: {0}
assert(it == vect.end());     //=> assertion true
```
###### Pitfall
> Invalidates iterators and references at or after the point of the erase, including the end() iterator.[Source](https://en.cppreference.com/w/cpp/container/vector/erase)

So it is important to update relevant iterator(s) with the returned iterator or re-assign them after calling `<container>.erase(...)`!

#### [Sequence Containers](https://en.wikipedia.org/wiki/Sequence_container_(C%2B%2B))
##### [`std::array`](https://en.cppreference.com/w/cpp/container/array)
A thin wrapper around C-style arrays
###### Import
```cpp
#include <array>
```
###### Declaration and initialization
```cpp
array<int, 10> a = {5, 7, 4, 2, 8, 6, 1, 9, 0, 3};
```
###### Capacity
```cpp
a.empty();
a.size();
```
###### Accessors
```cpp
a[i];
```
###### Modifiers
```cpp
// Assignment
a[i] = x;

// Increment
a[i]++;
```

##### [`std::vector`](https://en.cppreference.com/w/cpp/container/vector)
###### Import
```cpp
#include <vector>
```
###### Declaration and initialization
```cpp
// Initialization
vector<int> vect;               // Initialize empty vector
vector<int> vect(n);            // Initialize vector of size n
vector<int> vect(n, 10);        // Initialize vector of size n with all values being 10
vector<int> vect{1, 2, 3};      // Initialize with items {1, 2, 3}
vector<int> vect({1, 2, 3});    // Initialize with items {1, 2, 3}
vector<int> vect = {1, 2, 3};   // Initialize with items {1, 2, 3}

// Initialize using array
int arr[3] = {10, 20, 30};
vector<int> vect(arr, arr + 3); // Initialize with items {10, 20, 30} 
```
###### Capacity
```cpp
vect.empty();
vect.size():
```
###### Accessors
```cpp
vect[i];
```
###### Modifiers
```cpp
// Assignment
vect[i] = x;

// Increment
vect[i]++;

// Append
vect.push_back(99);
vect.emplace_back(100);

// Mass assign
vect.assign(n, val); // assign first n items with value val

// Remove
vect.erase(vect.begin() + 5);                // erase the 6th element
vect.erase(vect.begin(), vect.begin() + 3);  // erase the first 3 elements:

// Empty
vect.clear();
```

##### [`std::list`](https://en.cppreference.com/w/cpp/container/list)
###### Import
```cpp
#include <list>
```
###### Declaration and initialization
```cpp
list<int> lst;              
list<int> lst({1, 2, 3});   // Initialize with items {1, 2, 3}
list<int> lst = {1, 2, 3};  // Initialize with items {1, 2, 3}
```
###### Capacity
```cpp
lst.empty();    // Checks if list is empty
lst.size();     // Returns size of list
```
###### Accessors
```cpp
lst.front();    // Get head item
lst.back();     // Get tail item
```
###### Modifiers
```cpp
lst.clear();            // clear all contents of list
lst.push_back(item);    // Appends item to the rear
lst.push_front(item);   // Prepends item at head
lst.insert(it, item);   // Inserts item before iterator position
lst.pop_back();         // Removes last item
lst.reverse();          // Reverses the entire list
lst.remove(v);          // Removes all elements equal to v
lst.remove_if([](int x){ return x > 10; }); // Removes all elements greater than 10
```
[Splice](http://www.cplusplus.com/reference/list/list/splice/)
```cpp
list<int> lst1 = {1, 2, 3};
list<int> lst2 = {4, 5, 6};
lst1.splice(lst1.end(), lst2); // O(1)
list<int> lst3 = {1, 2, 3, 4, 5, 6};
assert(lst1 == lst3); //=> assertion true
```

##### [`std::deque`](https://en.cppreference.com/w/cpp/container/deque)
###### Import
```cpp
#include <deque>
```
###### Declaration and initialization
```cpp
deque<int> deq;
```
###### Capacity
```cpp
deq.empty();    // Checks if deque is empty
deq.size();     // Returns current size on deque
```
###### Accessors
```cpp
deq.front();  // Returns front item of deque
deq.back();   // Returns rear item of deque
deq.at(i);    // Returns the item at position i in O(1)
```
###### Modifiers
```cpp
deq.push_front(item);   // Push item to front of deque
deq.pop_front(item);    // Pop item from front of deque
deq.push_back(item);    // Inject item at rear of deque
deq.pop_back(item);     // Eject item at rear of deque
```
###### Iterator
```cpp
for (auto it = deq.begin(); it != deq.end(); ++it) {
  // ...
}
```

#### Container adaptors
##### [`std::queue`](https://en.cppreference.com/w/cpp/container/queue)
###### Import
```cpp
#include <queue>
```
###### Declaration and initialization
```cpp
queue<int> q;
```
###### Capacity
```cpp
q.empty();    // Checks if queue is empty
q.size();     // Returns current size on queue
```
###### Accessors
```cpp
q.front();  // Returns front item of queue
q.back();   // Returns rear item of queue
```
###### Modifiers
```cpp
q.push(item); // enqueue item to rear of queue
q.pop(item);  // dequeue item from front of queue
```
###### Misc
```cpp
print_queue(q);
```

##### [`std::priority_queue`](https://en.cppreference.com/w/cpp/container/priority_queue)
###### Import
```cpp
#include <queue>
```
###### Declaration and initialization
```cpp
priority_queue<int> pq;                             // Creates a max-heap
priority_queue<int, vector<int>, greater<int>> pq;  // Creates a min-heap

priority_queue<int> pq(less<int>(), {1,2,3});       // Initialize max-heap with {1,2,3} | O(N)

vector<int> vect = {1,2,3};
priority_queue<int> pq(less<int>(), vect);          // Initialize max-heap with vector | O(N)
```
To create a priority queue with custom comparator:
```cpp
struct CustomCompare {
  bool operator()(const int& lhs, const int& rhs) {
    return lhs < rhs; // This entails a max heap
  }
};
// ...
priority_queue<int, vector<int>, CustomCompare > pq;
```
###### Capacity
```cpp
pq.empty();
pq.size();
```
###### Accessors
```cpp
pq.top();
```
###### Modifiers
```cpp
pq.push(item);  // Add
pq.pop();       // Remove
```
###### Misc
```cpp
print_queue(q);
```

##### [`std::stack`](https://en.cppreference.com/w/cpp/container/stack)
###### Import
```cpp
#include <stack>
```
###### Declaration and initialization
```cpp
stack<int> stk;
stack<int> stk(vector<int>{1,2,3,4});
```
###### Capacity
```cpp
stk.empty();    // Checks if stack is empty
stk.size();     // Returns current size on stack
```
###### Accessors
```cpp
stk.top();      // Returns the topmost element
```
###### Modifiers
```cpp
stk.push(item); // Push item to top of stack
stk.pop(item);  // Pop item off top of stack
```

#### [Associative containers](https://en.wikipedia.org/wiki/Associative_containers)

##### [`std::set`](https://en.cppreference.com/w/cpp/container/set), [`std::multiset`](https://en.cppreference.com/w/cpp/container/multiset)
The STL BBST implementation for storing keys. `set` can only store a single occurence of a unique key whereas `multiset` can store multiple occurences of the same key. As the functions for the 2 containers are identical, they shall be listed in the following subsections without the loss of generality.

###### Import
```cpp
#include <set>
```
###### Declaration and initialization
```cpp
set<int> s({1,2,3});
set<int> s = {1,2,3};

// Using vector
vector<int> v = {1,2,3};
set<int> s(v.begin(), v.end());
```
Ordering:
```cpp
set<int, std::less> s;    // Order ascending (default)
set<int, std::greater> s; // Order descending
```
Use custom comparator:
```cpp
// Custom comparator to order descending
struct custom_cmp {
  bool operator() (const int & l, const int & r) const {
    return l > r;
  }
};
set<int, custom_cmp> s;
```
###### Capacity
```cpp
s.empty();
s.size();
```
###### Accessors
```cpp
// Count
s.count(key);

// Find
auto it = s.find(key);    // For multiset, this returns one key out of all the equivalent keys. O(log N)
auto ancestor = it + 1;   // O(log N)
auto descendant = it - 1; // O(log N)

// Bound
/*
 * Important note! Using std::lower_bound incurs O(N log N) compexity!
 * Please use the member functon lower_bound as shown below!
 */
auto it = s.lower_bound(key); // O(log N)
auto it = s.upper_bound(key); // O(log N)

// Iterator range for equivalent keys (only for multiset)
auto [it_begin, it_end] = s.equal_range(key);
```
###### Modifier
```cpp
// Add
s.insert(key);
s.emplace(key);

// Remove
s.erase(it);
```
###### Iteration
The following 2 loops are equivalent in looping over key values, in the order of keys dictated by the comparator. Both are in *O(N)*  
Caveat: Keys iterated will be unique for `set` but may not be for `multiset`
```cpp
for (auto &key: s)
  cout << key << endl;
```
```cpp
for (auto it = s.begin(); it != s.end(); ++it)
  cout << *it << endl;
```
To loop over unique keys in multiset:
```cpp
for (auto it = s.begin(); it != s.end(); it = s.upper_bound(*it))
  cout << *it << endl;
```

##### [`std::map`](https://en.cppreference.com/w/cpp/container/map), [`std::multimap`](https://en.cppreference.com/w/cpp/container/multimap)
The STL BBST implementation for storing (key, value) pairs. `map` can only store a single occurence of (key, value) for the given key whereas `multimap` can store multiple occurences of (key, value) pairs for the same key. As the functions for the 2 containers are identical, they shall be listed in the following subsections without the loss of generality.
###### Import
```cpp
#include <map>
```
###### Declaration and initialization
```cpp
map<string, int> m({{"John",25}, {"Alice",19}, {"Bob",30}});
map<string, int> m = {{"John",25}, {"Alice",19}, {"Bob",30}};

// Using vector
vector<pair<string, int>> v = {{"John",25}, {"Alice",19}, {"Bob",30}};
map<string, int> m(v.begin(), v.end());
```
Ordering:
```cpp
map<string, int, std::less> m;    // Order ascending (default)
map<string, int, std::greater> m; // Order descending
```
Use custom comparator:
```cpp
// Custom comparator to order descending
struct custom_cmp {
  bool operator() (const string & l, const string & r) const {
    return l > r;
  }
};
map<string, int, custom_cmp> m;
```
###### Capacity
```cpp
m.empty();
m.size();
```
###### Accessors
```cpp
// Count
m.count(key);

// Find
auto it = m.find(key);    // For multimap, this returns one (key, value) pair out of all the equivalent keys. O(log N)
auto ancestor = it + 1;   // O(log N)
auto descendant = it - 1; // O(log N)

// Bound
/*
 * Important note! Using std::lower_bound incurs O(N log N) compexity!
 * Please use the member functon lower_bound as shown below!
 */
auto it = m.lower_bound(key); // O(log N)
auto it = m.upper_bound(key); // O(log N)

// Resolving key and value from iterator
auto &[key, value] = *it;                      // Using C++17 structured binding
auto key = it->first; auto value = it->second; // From the pair the iterator points to

// Iterator range for equivalent keys (only for multimap)
auto [it_begin, it_end] = m.equal_range(key);
```
###### Operator
For `map`, the `[]` operator may be used to obtain the value directly given the key.  
**Important**: The caveat is that if the key does not yet exist in the `(multi)map`, this will insert (key, default value) pair into it and return that default value.
```cpp
auto value = m[key]; // O(log N)
```
###### Modifier
```cpp
// Add
m[key] = value;
m.insert({key, value});
m.emplace(key, value);

// Remove
m.erase(it);
```
###### Iteration
The following 2 loops are equivalent in looping over (key, value), in the order of keys dictated by the comparator. Both are in *O(N)*
```cpp
for (auto &[key, value]: m)
  cout << key << ', ' << value << endl;
```
```cpp
for (auto it = m.begin(); it != m.end(); ++it)
  cout << it->first << ', ' << it->second << endl;
```
To loop over unique keys in `multimap`:
```cpp
for (auto it = m.begin(); it != m.end(); it = m.upper_bound(*it))
  cout << it->first << endl;
```

#### [Unordered associative containers](https://en.wikipedia.org/wiki/Unordered_associative_containers_(C%2B%2B))

##### [`std::unordered_set`](https://en.cppreference.com/w/cpp/container/unordered_set), [`std::unordered_multiset`](https://en.cppreference.com/w/cpp/container/unordered_multiset)
The STL Hash Table implementation for storing keys. `unordered_set` can only store a single occurence of a unique key whereas `unordered_multiset` can store multiple occurences of the same key. As the functions for the 2 containers are identical, they shall be listed in the following subsections without the loss of generality.

###### Import
```cpp
#include <unordered_set>
```
###### Declaration and initialization
```cpp
unordered_set<int> us({1,2,3});
unordered_set<int> us = {1,2,3};

// Using vector
vector<int> v = {1,2,3};
set<int> us(v.begin(), v.end());
```
Use custom hash function:
```cpp
// Method 1: Function object
struct custom_hash
{
  size_t operator()(const int & key) const {
    return key * 2; // Return hashed value here
  }
};
unordered_set<int, custom_hash> us;

// Method 2: Lambda
auto custom_hash = [](const int & key) {
    return key * 2; // Return hashed value here
};
unordered_set<int, decltype(custom_hash)> us(n, custom_hash); // Where n is the minimum number of initial buckets
```
###### Capacity
```cpp
us.empty();
us.size();
```
###### Accessors
```cpp
// Count
us.count(key);

// Find
auto it = us.find(key);    // For unordered_multiset, this returns one key out of all the equivalent keys. O(1)

// Iterator range for equivalent keys (only for unordered_multiset)
auto [it_begin, it_end] = us.equal_range(key);
```
###### Modifier
```cpp
// Add
us.insert(key);
us.emplace(key);

// Remove
us.erase(it);
```
###### Iteration
The following 2 loops are equivalent in looping over key values, in no particular order. Both are in *O(N)*  
Caveat: Keys iterated will be unique for `unordered_set` but may not be for `unordered_multiset`
```cpp
for (auto &key: us)
  cout << key << endl;
```
```cpp
for (auto it = us.begin(); it != us.end(); ++it)
  cout << *it << endl;
```
To loop over unique keys in `unordered_multiset`:
```cpp
for (auto it = us.begin(); it != us.end(); it = us.equal_range(*it)->second)
  cout << *it << endl;
```

##### [`std::unordered_map`](https://en.cppreference.com/w/cpp/container/unordered_map), [`std::unordered_multimap`](https://en.cppreference.com/w/cpp/container/unordered_multimap)
The STL Hash Table implementation for storing (key, value) pairs. `unordered_map` can only store a single occurence of (key, value) pair for the given key whereas `unordered_multimap` can store multiple occurences of (key, value) pairs for the same key. As the functions for the 2 containers are identical, they shall be listed in the following subsections without the loss of generality.

###### Import
```cpp
#include <unordered_map>
```
###### Declaration and initialization
```cpp
unordered_map<string, int> um({{"John",25}, {"Alice",19}, {"Bob",30}});
unordered_map<string, int> um = {{"John",25}, {"Alice",19}, {"Bob",30}};

// Using vector
vector<pair<string, int>> v = {{"John",25}, {"Alice",19}, {"Bob",30}};
unordered_map<string, int> um(v.begin(), v.end());
```
Use custom hash function:
```cpp
// Method 1: Function object
struct custom_hash
{
  size_t operator()(const string & key) const {
    return key[0] * 2; // Return hashed value here
  }
};
unordered_map<string, int, custom_hash> um;

// Method 2: Lambda
auto custom_hash = [](const string & key) {
    return key[0] * 2; // Return hashed value here
};
unordered_map<string, int, decltype(custom_hash)> um(n, custom_hash); // Where n is the minimum number of initial buckets
```
###### Capacity
```cpp
um.empty();
um.size();
```
###### Accessors
```cpp
// Count
um.count(key);

// Find
auto it = um.find(key);   // For unordered_multimap, this returns one (key, value) pair out of all the equivalent keys. O(1)

// Resolving key and value from iterator
auto &[key, value] = *it;                      // Using C++17 structured binding
auto key = it->first; auto value = it->second; // From the pair the iterator points to

// Iterator range for equivalent keys (only for unordered_multimap)
auto [it_begin, it_end] = m.equal_range(key);
```
###### Operator
For `unordered_(multi)(multi)map`, the `[]` operator may be used to obtain the value directly given the key.  
**Important**: The caveat is that if the key does not yet exist in the `unordered_(multi)map`, this will insert (key, default value) pair into it and return that default value.
```cpp
auto value = um[key]; // O(log N)
```
###### Modifier
```cpp
// Add
um[key] = value;
um.insert({key, value});
um.emplace(key, value);

// Remove
um.erase(it);
```
###### Iteration
The following 2 loops are equivalent in looping over (key, value), in no particular order. Both are in *O(N)*
```cpp
for (auto &[key, value]: um)
  cout << key << ', ' << value << endl;
```
```cpp
for (auto it = um.begin(); it != um.end(); ++it)
  cout << it->first << ', ' << it->second << endl;
```
To loop over unique keys in `unordered_multimap`:
```cpp
for (auto it = um.begin(); it != um.end(); it = um.equal_range(*it)->second)
  cout << *it << endl;
```

### [Algorithm](https://en.cppreference.com/w/cpp/algorithm)
Import:
```cpp
#include <algorithm>
#include <functional> // if using lambda
```
#### [`std::binary_search`](https://en.cppreference.com/w/cpp/algorithm/binary_search)
Checks if a given value exists in the container.  
Note: Caller is responsible of ensuring iterator range \[first, last\) is fully ordered prior to calling `binary_search`. Parital ordering is also possible if iterator range meets certain ordering criteria (see documentation page).
```cpp
vector<int> v = {1,2,4,5,9};
bool found_4 = binary_search(v.begin(), v.end(), 4);  //=> true
bool found_3 = binary_search(v.begin(), v.end(), 3);  //=> false
```
#### [`std::copy`, `std::copy_if`](https://en.cppreference.com/w/cpp/algorithm/copy)
```cpp
vector<int> v1{1,2,3,4,5};
vector<int> v2(5);
copy(v1.begin(), v1.end(), v2.begin());
assert(v1 == v2);     //=> assertion true

vector<int> v_geq3{3,4,5};
vector<int> v3(3);
copy_if(v1.begin(), v1.end(), v3.begin(), [](int i){ return i >= 3;});
assert(v3 == v_geq3); //=> assertion true
```
#### [`std::count`, `std::count_if`](https://en.cppreference.com/w/cpp/algorithm/count)
```cpp
vector<int> v{1,2,1,3,1,4,1,5,1,6};
int count_eq1   = count(v.begin(), v.end(), 1);                               //=> 5
int count_geq3  = count_if(v.begin(), v.end(), [](int i){ return i >= 3; });  //=> 4
```
#### [`std::equal_range`](https://en.cppreference.com/w/cpp/algorithm/equal_range)
Returns an iterator range containing all elements equivalent to value in the range \[first, last\).  
Note: Caller is responsible of ensuring iterator range \[first, last\) is fully ordered prior to calling `equal_range`. Parital ordering is also possible if iterator range meets certain ordering criteria (see documentation page).
```cpp
vector<pair<int, char>> v_ic = { {1,'A'}, {2,'B'}, {2,'C'}, {2,'D'}, {4,'G'}, {3,'F'} };
pair<int, char> value = {2, '?'};
auto [it_begin, it_end] = equal_range(v_ic.begin(), v_ic.end(), value);
auto it_lower = lower_bound(v_ic.begin(), v_ic.end(), value);
auto it_upper = upper_bound(v_ic.begin(), v_ic.end(), value);
assert(it_begin == it_lower);
assert(it_end == it_upper);
```
#### [`std::fill`](https://en.cppreference.com/w/cpp/algorithm/fill)
Note: `vector` has member function `assign` to achieve the same behaviour.
```cpp
vector<int> v1{1,2,3,4,5};
vector<int> v2{8,8,8,8,8};
fill(v1.begin(), v1.end(), 8);
assert(v1 == v2);   //=> assertion true
```
#### [`std::max`](https://en.cppreference.com/w/cpp/algorithm/max)
```cpp
max_xy = max(x, y);
```
The above is equivalent to:
```cpp
if (x > y)
  max_xy = x;
 else
  max_xy = y;
```
#### [`std::max_element`](https://en.cppreference.com/w/cpp/algorithm/max_element)
```cpp
vector<int> v{3,1,-14,1,5,9};
auto it_max = max_element(v.begin(), v.end());
assert(*it_max == 9); //=> assertion true

auto it_abs_max = max_element(v.begin(), v.end(), [](int a, int b){ return abs(a) < abs(b); });
assert(*it_abs_max == -14); //=> assertion true
```
#### [`std::random_shuffle`](https://en.cppreference.com/w/cpp/algorithm/random_shuffle)
```cpp
vector<int> v = {1,2,3,4,5,6,7};
srand(time(NULL));
random_shuffle(v.begin(), v.end());
```
#### [`std::remove`, `std::remove_if`](https://en.cppreference.com/w/cpp/algorithm/remove)
Removes all elements satisfying specific criteria from the range \[first, last\) and returns a past-the-end iterator for the new end of the range.
```cpp
string str1 = "Hello   World!";
str1.erase(remove(str1.begin(), str1.end(), ' '), str1.end());
assert(str1 == "HelloWorld!");  //=> assertion true

string str2 = " Hello \t World! \n";
str2.erase(remove(str2.begin(), str2.end(), [](char x){ return isspace(x); }), str2.end());
assert(str2 == "HelloWorld!");  //=> assertion true
```
#### [`std::reverse`](https://en.cppreference.com/w/cpp/algorithm/reverse)
```cpp
vector<int> v = {1,2,3};
reverse(v.begin(), v.end());
vector<int> rv = {3,2,1};
assert(v == rv);  //=> assertion true
```
#### [`std::sort`](https://en.cppreference.com/w/cpp/algorithm/sort), [`std::stable_sort`](https://en.cppreference.com/w/cpp/algorithm/stable_sort)
STL sorting functions are namely [`sort`](https://en.cppreference.com/w/cpp/algorithm/sort) and [`stable_sort`](https://en.cppreference.com/w/cpp/algorithm/stable_sort). As their names suggest, the former is not guaranteed to be stable while the latter is.
##### Sorting arrays
```cpp
sort(arr, arr+n);                 // Sorts ascending (default)
sort(arr, arr+n, less<int>());    // Sorts descending
sort(arr, arr+n, greater<int>()); // Sorts descending
stable_sort(arr, arr+n);          // Stable sorts ascending
```
##### Sorting STL containers
To perform sorting on containers, we will have to use iterators.

Sort using the default comparator for given type
```cpp
sort(vect.begin(), vect.end());
stable_sort(vect.begin(), vect.end());
```
sort using a standard library compare function object
```cpp
sort(vect.begin(), vect.end(), greater<int>()); // sorts descending
```
##### Custom ordering
A comparator function is a function that takes in 2 parameters, say `a` and `b`, which simply returns a `bool` that answers the question: **must `a` come before `b` after sorting?** The comparator function is simply a binary function that is designated to replace the default `<` relationship between `a` and `b`, where it returns `true` iff `a < b` and `false` otherwise (`>=`). In other words, if the comparator returns `false` for a given pair of `a` and `b`, it's saying that we don't care about their relative order. I.E. if a case in your comparator wants to treat `a` and `b` as non-distinct (i.e. equal), you should return `false` for that case.

###### Lambda (anonymous) function
```cpp
sort(s.begin(), s.end(), [](int a, int b) {
    return a < b;   
});
```
###### Custom (named) function
```cpp
bool customComparator(int a, int b) {
  return a > b;
}
//...
sort(s.begin(), s.end(), customComparator);
```
###### Function object
```cpp
struct {
    bool operator()(int a, int b) const{   
        return a < b;
    }   
} customComparator;
//...
sort(s.begin(), s.end(), customComparator);
```

#### [`std::lower_bound`](https://en.cppreference.com/w/cpp/algorithm/lower_bound)
Returns an iterator to the first item in container encountered that is greater or equal to given value. i.e. `>= val`. If no items qualify in the container, return iterator pointing to `.end()` of container. Performance is O(log N). Note that for this operation to be meangingful, the items should be sorted in some ordering.
```cpp
vector<int>::iterator it;
vector<int> vect1 = {0,1,2,3,3,5};
vector<int> vect2 = {0,1,2,4,5,6};

/* Case 1: When value exists in container */
it = lower_bound(vect1.begin(), vect1.end(), 3);  //=> iterator poiting at index position 3
cout << *it << endl;                              //=> 3

/* Case 2: When only items greater than or equal to val exists in container */
it = lower_bound(vect2.begin(), vect2.end(), 3);  //=> iterator poiting at index position 3
cout << *it << endl;                              //=> 4

/* Case 3: All items in container strictly lower than val */
it = lower_bound(vect2.begin(), vect2.end(), 7);
assert(it == vect2.end());                        //=> assertion true
```

#### [`std::upper_bound`](https://en.cppreference.com/w/cpp/algorithm/upper_bound)
Returns an iterator to the first item in container encountered that is **strictly greater than** than given value. i.e. `> val`. If no items qualify in the container, return iterator pointing to `.end()` of container. Performance is O(log N). Note that for this operation to be meangingful, the items should be sorted in some ordering.
```cpp
vector<int>::iterator it;
vector<int> vect1 = {0,1,2,3,3,5};
vector<int> vect2 = {0,1,2,4,5,6};

/* Case 1: When value exists in container */
it = upper_bound(vect1.begin(), vect1.end(), 3);  //=> iterator poiting at index position 5
cout << *it << endl;                              //=> 5

/* Case 2: When only items greater than or equal to val exists in container */
it = upper_bound(vect2.begin(), vect2.end(), 3);  //=> iterator poiting at index position 3
cout << *it << endl;                              //=> 4

/* Case 3: All items in container strictly lower than val */
it = upper_bound(vect2.begin(), vect2.end(), 7);
assert(it == vect2.end());                        //=> assertion true
```



### [Iterators](https://en.cppreference.com/w/cpp/header/iterator)
Available to the following STL container types
```cpp
#include <array>
#include <deque>
#include <forward_list>
#include <list>
#include <map>
#include <regex>
#include <set>
#include <span>         // (since C++20)
#include <string>
#include <string_view>  // (since C++17)
#include <unordered_map>
#include <unordered_set>
#include <vector>
```
Iterators are typically initialized via STL container functions, which comes in 2 forms
* Forward iterators (most common)
  * `<container>.begin()` returns the iterator pointing to the first item, 
  * `<container>.end()` returns the iterator pointing to past-the-last element
  * Increment of iterator progresses it forward toward the end
* [Reverse iterators](https://en.cppreference.com/w/cpp/iterator/reverse_iterator)
  * `<container>.rbegin()` returns the iterator pointing to the last item, 
  * `<container>.rend()` returns the iterator pointing to past-the-first element
  * Increment of iterator progresses it backwards toward the beginning

#### Iterating an iterable
For-loop:
```cpp
for (vector<int>::iterator it=vect.begin(); it!=vect.end(); ++it) {
    // Do something with *it;
}
```
While-loop:
```cpp
vector<int>::iterator it=vect.begin();
while(it != vect.end()) {
  // Do something with *it
  ++it;
}
```

#### Common manipulations
##### Conversion
Index to iterator:
```cpp
vector<int>::iterator it;
vector<int> vect = {0,1,2,3,4,5};
int index = 4;
it = vect.begin() + index;
cout << *it << endl;    //=> 4
```

Iterator to index:
```cpp
vector<int> vect = {0,1,2,3,4,5};
vector<int>::iterator it = lower_bound(vect.begin(), vect.end(), 2);
int index = it - vect.begin(); // alternatively: distance(vect.begin(), it);
cout << index << endl;  //=> 2
```
##### Advancement
```cpp
++it            // Advance iterator to the next item
it += k;        // Advance iterator by k items. We can do this without worring about size of item
advance(it, k); // Advance iterator by k items 
```
##### Distance
```cpp
distance(it, it + 10);  //=> 10
```
---

## I/O
### [`iostream`](https://en.cppreference.com/w/cpp/io/basic_iostream)
Import
```cpp
#include <iostream>
```
#### Optimization for competitive programming
If only `cin`/`cout` will be used in place of `printf`/`scanf`, I/O can be optimized via:
```cpp
ios:sync_with_stdio(false); cin.tie(NULL);
```
See [here](https://www.geeksforgeeks.org/fast-io-for-competitive-programming/) for the reason.

#### [`std::cin`](https://en.cppreference.com/w/cpp/io/cin)
##### Integers
```cpp
// Read 2 numbers
int l, r;
cin >> l >> r;
```
##### Strings
```cpp
string str;
// Read a word (terminated with space/tab)
cin >> str;

// Read an entire line
getline(cin, str);
```
##### [`get`](https://en.cppreference.com/w/cpp/io/basic_istream/get)
Low level input that extracts a single character from stream:
```cpp
char c; cin.get(c);
```
It is also a common method to consume the newline character:
```cpp
cin.get(); // Consumed character discarded when no arguments given
```

#### [`std::cout`](https://en.cppreference.com/w/cpp/io/cout)
```cpp
cout << "Hello World!" << endl;
```
##### [`std::setprecision`]
Sets the desired output precision format for real number representations e.g. `float`, `double` etc.
```cpp
std::cout << std::setprecision(5) << 1.123456789 << endl;  //=> 1.12345
```

### [`stdio.h`](https://en.cppreference.com/w/cpp/header/cstdio)
#### Import
```cpp
#include <stdio.h>
```
#### [`printf`](https://en.cppreference.com/w/cpp/io/c/fprintf)
```cpp
printf("Hello World!\n");
printf ("Characters: %c %c \n", 'a', 65);
printf ("Decimals: %d %ld\n", 1977, 650000L);
printf ("Preceding with blanks: %10d \n", 1977);
printf ("Preceding with zeros: %010d \n", 1977);
printf ("Some different radices: %d %x %o %#x %#o \n", 100, 100, 100, 100, 100);
printf ("floats: %4.2f %+.0e %E \n", 3.1416, 3.1416, 3.1416);
printf ("Width trick: %*d \n", 5, 10);
printf ("%s \n", "A string");
```
Outputs the following
```sh
Characters: a A
Decimals: 1977 650000
Preceding with blanks:       1977
Preceding with zeros: 0000001977
Some different radices: 100 64 144 0x64 0144
floats: 3.14 +3e+000 3.141600E+000
Width trick:    10
A string
```

#### [`scanf`](https://en.cppreference.com/w/cpp/io/c/fscanf)
```cpp
int l, r;
scanf("%d %d", &l, &r);
```

### [`sstream`](https://en.cppreference.com/w/cpp/header/sstream)
#### Import
```cpp
#include <sstream>
```
#### [`std::stringstream`](https://en.cppreference.com/w/cpp/io/basic_stringstream)
Output
```cpp
stringstream ss;
ss << "Hello";
ss << " ";
ss << "World!";
cout << s.str();  /=> Hello World!
```
Input
```cpp
string str = "John Doe Johnson Mary";
stringstream ss(str);
string word;
while(ss >> word) {
  cout << word; //=> John, Doe, Johnson, Mary
}
```
#### [`std::istringstream`](https://en.cppreference.com/w/cpp/io/basic_istringstream)
```cpp
string line = "5 6 22 8";
istringstream iss;
iss.clear();
iss.str(line);
int num1, num2, num3, num4;
iss >> num1 >> num2 >> num3 >> num4;
```

#### [`freopen`](https://en.cppreference.com/w/cpp/io/c/freopen), [`fclose`](https://en.cppreference.com/w/cpp/io/c/fclose)
##### Reading
```cpp
freopen("input.txt", "r", stdin);   // redirects standard input
string x;
cin >> x;                           // reads from input.txt
```
##### Writing
```cpp
freopen("output.txt", "w", stdout); // redirects standard output
string x = "Write this out to file";
cout << x << endl;                  // writes to output.txt
fclose(stdout);                     // end standard output redirection to file
```
---

## OOP
### Struct
All attributes in a struct are publicly accessible
```cpp
struct Human {
  string name;
  int age;
  Human* father;
  Human* mother;
  
  /* Constructors */
  Human() {}
  Human(string name, int age) {
    this->name = name;
    this->age = age;
  }
  
  /* Function */
  void print() {
    cout << "Hello I am " << name << " and I am " << age << " years old!" << endl;
  }
};
```
#### Declaration and initialization
Using `new` constructor
```cpp
Human* someone = new Human;    // Attributes are NOT initialized.
Human* someone = new Human();  // Attributes are zero-initialized
Human  someone = new Human{};  // From C++14: New Brace initializer (Members are zero-initialized)
```
Using struct constructor
```cpp
Human  someone;                 // Attributes are NOT initialized.
Human  someone = Human();       // Attributes are zero-initialized
Human  someone{};               // From C++14: New Brace initializer (Members are zero-initialized)
```
#### Example
```cpp
Human* jack = new Human("jack", 55);
Human* mary = new Human("mary", 52);
Human* john = new Human("john", 25);
john->father = jack;
john->mother = mary;
```

---

## Custom utils
#### String to char array
```cpp
char* to_char_array(string str) {
    int n = str.length();
    char* char_array = new char[n+1];
    strcpy(char_array, str.c_str());
    return char_array;
}
```

#### Substring
```cpp
// Returns the index of the first occurence of the substring, else -1
int find(string str, string subStr) {
  for (int i = 0; i < str.length() - subStr.length() + 1; i++) {
    bool match = true;
    for (int j = 0; j < subStr.length(); j++) {
      if (str[i + j] != subStr[j]) {
        match = false;
        break;
      }
    }
    if (match) return i;
  }
  return -1;
}
```

#### Tokenize
For single delimiter
```cpp
#include <sstream>
// ...
vector<string> tokenizer(string str, char delimiter) {
  string token;
  istringstream iss(str);
  vector<string> tokens(str.length());
  while(getline(iss, token, delimiter)) {
    tokens.push_back(token);
  }
  return tokens;
}
```
For multiple delimiters
```cpp
vector<string> tokenizer(string str, string delimiters) {
    vector<string> tokens;
    char* str_chars = to_char_array(str);
    char* del_chars = to_char_array(delimiters);
    char *token = strtok(str_chars, del_chars); 
    while (token != NULL) {
        tokens.push_back(token);
        token = strtok(NULL, del_chars);
    }
    return tokens;
}
```
#### Reading until empty line
```cpp
vector<string> read_till_empty() {
  vector<string> lines;
  string line; 
  while(getline(cin, line), line.length()){
    lines.push_back(line);
  }
  return lines;
}
```

#### Reading 2D char array
```cpp
char** read_2D_char_array(int rows, int cols) {
  char **char_array_2D = new char *[rows];
  for (int r=0; r<rows; r++) {
    char_array_2D[r] = new char[cols];
    for (int c=0; c<cols; c++) {
      cin >> char_array_2D[r][c];
    }
  }
  return char_array_2D;
}
```

#### Printing 1D int array
```cpp
void print_array(int* arr, int n) {
  for (int* i=arr; i<arr+n; i++) {
    cout << *i;
    if (i<arr+n-1) cout << ", ";
  }
  cout << endl;
}
```

#### Index to iterator
```cpp
vector<int>::iterator get_iterator(int index, vector<int> & vect) {
  return vect.begin() + index;
}
```

#### Iterator to index
```cpp
int get_index(vector<int>::iterator it, vector<int> & vect) {
  return distance(vect.begin(), it);
}
```

#### Binary search
```cpp
int binary_search(vector<int> & sorted_vect, int val) {
  vector<int>::iterator it = lower_bound(sorted_vect.begin(), sorted_vect.end(), val);
  return (it == sorted_vect.end())
    ? -1
    : (*it == val)
      ? distance(sorted_vect.begin(), it)
      : -1;
}
```
