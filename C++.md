# C++ Cheatsheet
*This is a work in progress*
## TODO
* http://www.cplusplus.com/reference/algorithm/binary_search/
* https://en.cppreference.com/w/cpp/algorithm/remove
* https://en.cppreference.com/w/cpp/algorithm/copy
* http://www.cplusplus.com/reference/algorithm/reverse/
* https://en.cppreference.com/w/cpp/algorithm/count

Unless otherwise specified, this is written for C++11.

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

### Primitives
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

##### Comma operator
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

##### Bitwise operators
| Operator | Description     |
|:--------:|:---------------:|
| `&`      | Bitwise AND     |
| `\|`     | Bitwise OR      |
| `^`      | Bitwise XOR     |
| `~`      | NOT             |
| `<<`     | Bit-shift left  |
| `>>`     | Bit-shift right |

##### Casting
```cpp
int i;
float pi = 3.14;

// Both methods below are equivalent
i = (int) pi;
i = int (pi);
```

### Type alias
* Type alias using `typddef` is a means for us to provide alternative naming for a type
* This is often done to provide a convenient shorthand for referring to verbose types
* It also serve as a basic way of providing data abstraction
```cpp
typedef string nusnet_id;
typedef string name;
typedef string grade;
typedef vector<tuple<nusnet_id, name, grade>> grades;
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

### Switch statement
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

## Strings
In C++ and C, a string is an array of `char` terminated with the null character `\0`.

However `std::string` is treated differently from `c-string`

Strings are mutable in C++. This behaviour differs from other languages such as Java.

### Import
```cpp
#include <string>
````

### Overview
#### Declaration
```cpp
// Assignment via string literal
string str = "Hello world!";

// Initialization using char array
char arr[] = "Hello world!";
string str(arr);
```
#### Accessing chars
```cpp
string hello = "Hello";
str.at(0); //=> 'H'
str[0];    //=> 'H'
```
#### Parsing
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
#### Length
Both `.length()` and `.size()` (UTF-8) may be used.
```cpp
string str = "Hello";
str.length(); //=> 5
str.size();   //=> 5
```
#### Concatenation
C++ strings can be concatenated simply using the `+` operator
```cpp
string str = "Hello" + " " + "World!";
assert(str, "Hello World!");  //=> assertion true
```
#### Appending
The `+=` operator is the most straightforward and generalised form of appending. However you may also use `push_back(c)` for appending a character or `apppend(str)` for appending a string.
```cpp
string str = "Hello";
str += " World";      // str: "Hello World"
str.push_back('!');   // str: "Hello World!"
str.append(" Hi!");   // str: "Hello World! Hi!"
```
#### Comparison
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
#### Find
```cpp
string str = "Hello World";
size_t pos = str.find("World");         //=> 6
size_t pos = str.find("Hey");           //=> string::npos
size_t pos = str.find_last_of('o');     //=> 7
```
#### Substring
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
#### Erasing
```
TODO
sequence (1): string& erase(size_t pos = 0, size_t len = npos);
character (2): iterator erase(const_iterator p);
range (3): iterator erase(const_iterator first, const_iterator last);
```

## Iteration
### Loops
#### For
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
#### While
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
#### Do-while
```cpp
do {
   // ...
}
while (loop_condition);
```

### Pointer
#### Basics
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
#### Object pointers
```cpp
MyObject* my_object = new MyObject();

/* The following are equivalent when accessing attributes of an object pointer */
(*my_object).attr1;
my_object->attr1;
```

### Reference
[Pointers vs references](https://stackoverflow.com/questions/57483/what-are-the-differences-between-a-pointer-variable-and-a-reference-variable-in)
#### Basics
```cpp
int a = 3;
int &ref = a;
cout << ref;    // Acess value of reference
```
#### Examples
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

## STL
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

### Containers

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

Note that C-style arrays does not enjoy the convenience of C++11's foreach loop. Instead consider using `std:array`

#### `std::array`
A thin wrapper around C-style arrays
```cpp
array<int, 10> s = {5, 7, 4, 2, 8, 6, 1, 9, 0, 3};
```

#### `std::pair`
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
##### Operation
Equaliy via `==` is supported:
```cpp
pair<int,int> p1(1,2);
pair<int,int> p2(1,2);
assert(p1 == p2);   //=> assertion true
```

#### `std::tuple`
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
##### Operation
Equaliy via `==` is supported:
```cpp
tuple<int,int> t1(1,2);
tuple<int,int> t2(1,2);
assertion(t1 == t2); //=> assertion true
```

#### `std::vector`
##### Import
```cpp
#include <vector>
```
##### Declaration and initialization
```cpp
// Initialization
vector<int> vect;           // init empty vector
vector<int> vect(n);        // init vector of size n
vector<int> vect(n, 10);    // init vector of size n with all values being 10
vector<int> vect(1, 2, 3);  // init vector with items {1, 2, 3}

// Init using array
int arr[3] = {10, 20, 30};
vector<int> vect(arr, arr + 3); // init vector with items {10, 20, 30} 
```
##### Capacity
```cpp
vect.size():
```
##### Accessors
```cpp
vect[i] = x;
```
##### Modifiers
```cpp
vect[i]++;
vect.push_back(99); // Appending

// Removing
vect.erase(vect.begin() + 5);                // erase the 6th element
vect.erase(vect.begin(), vect.begin() + 3);  // erase the first 3 elements:
```

#### `std::list`
##### Import
```cpp
#include <list>
```
##### Declaration and initialization
```cpp
list<int> lst;              
list<int> lst({1, 2, 3});   // Initialize with items
```
##### Capacity
```cpp
lst.empty();    // Checks if list is empty
lst.size();     // Returns size of list
```
##### Accessors
```cpp
lst.front();    // Get head item
lst.back();     // Get tail item
```
##### Modifiers
```cpp
lst.clear();            // clear all contents of list
lst.push_back(item);    // Appends item to the rear
lst.push_front(item);   // Prepends item at head
lst.insert(it, item);   // Inserts item before iterator position
lst.pop_back();         // Removes last item
```

#### `std::stack`
##### Import
```cpp
#include <stack>
```
##### Declaration and initialization
```cpp
stack<int> stk;
stack<int> stk(vector<int>{1,2,3,4});
```
##### Capacity
```cpp
stk.empty();    // Checks if stack is empty
stk.size();     // Returns current size on stack
```
##### Accessors
```cpp
stk.top();      // Returns the topmost element
```
##### Modifiers
```cpp
stk.push(item); // Push item to top of stack
stk.pop(item);  // Pop item off top of stack
```

#### `std::queue`
##### Import
```cpp
#include <queue>
```
##### Declaration and initialization
```cpp
queue<int> q;
```
##### Capacity
```cpp
q.empty();    // Checks if queue is empty
q.size();     // Returns current size on queue
```
##### Accessors
```cpp
q.front();  // Returns front item of queue
q.back();   // Returns rear item of queue
```
##### Modifiers
```cpp
q.push(item); // enqueue item to rear of queue
q.pop(item);  // dequeue item from front of queue
```
##### Misc
```cpp
print_queue(q);
```

#### `std:deque`
##### Import
```cpp
#include <deque>
```
##### Declaration and initialization
```cpp
deque<int> deq;
```
##### Capacity
```cpp
deq.empty();    // Checks if deque is empty
deq.size();     // Returns current size on deque
```
##### Accessors
```cpp
deq.front();  // Returns front item of deque
deq.back();   // Returns rear item of deque
deq.at(i);    // Returns the item at position i in O(1)
```
##### Modifiers
```cpp
deq.push_front(item);   // Push item to front of deque
deq.pop_front(item);    // Pop item from front of deque
deq.push_back(item);    // Inject item at rear of deque
deq.pop_back(item);     // Eject item at rear of deque
```

##### Iterator
```cpp
for (auto it = deq.begin(); it != deq.end(); ++it) {
  // ...
}
```

#### `std:priority_queue`
##### Import
```cpp
#include <queue>
```
##### Declaration and initialization
```cpp
priority_queue<int> pq;                             // Creates a max heap
priority_queue<int, vector<int>, greater<int>> pq;  // Creates a min heap
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

##### Capacity
```cpp
pq.empty();
pq.size();
```
##### Accessors
```cpp
pq.top();
```
##### Modifiers
```cpp
pq.push(item);
pq.pop();
```
#### Misc
```cpp
print_queue(q);
```

### Algorithm
Import:
```cpp
#include <algorithm>
#include <functional> // if using lambda
```
#### Sorting
Note: default `sort` is not stable. For stable sorting, use `stable_sort`
#### For containers
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
#### For arrays
```cpp
sort(arr, arr+n);
stable_sort(arr, arr+n);
```
sort using a standard library compare function object
```cpp
sort(arr, arr+n, greater<int>()); // sorts descending
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

#### Bounds
##### `lower_bound`
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

##### `upper_bound`
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

### Iterators
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

## I/O
### `iostream`
Import
```cpp
#include <iostream>
```
#### `std::cin`
Integers
```cpp
// Read 2 numbers
int l, r;
cin >> l >> r;
```
Strings
```cpp
string str;
// Read a word (terminated with space/tab)
cin >> str;

// Read an entire line
getline(cin, str);
```
#### `std::cout`
```cpp
cout << "Hello World!" << endl;
```
### `stdio.h`
Import
```cpp
#include <stdio.h>
```
#### `printf`
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

#### `scanf`
```cpp
int l, r;
scanf("%d %d", &l, &r);
```

### `sstream`
Import
```cpp
#include <sstream>
```
#### `stringstream`
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
#### `istringstream`
```cpp
string line = "5 6 22 8";
istringstream iss;
iss.clear();
iss.str(line);
int num1, num2, num3, num4;
iss >> num1 >> num2 >> num3 >> num4;
```

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
  while(getline(cin, line)){
    if (!line.length()) break;
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
