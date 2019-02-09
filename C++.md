# C++ Cheatsheet
This is a work in progress

## General
Importing
```cpp
#include <package_name>
using namespace std;      // This will be assumed for the remaining of this cheatsheet
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
Strings are mutable in C++
### Import
```cpp
#include <string>
````

### Overview
Declaration
```cpp
// Assignment via string literal
string str = "Hello world!";

// Initialization using char array
char arr[] = "Hello world!";
string str(arr);
```
Accessing chars
```cpp
string hello = "Hello";
str.at(0); //=> 'H'
str[0];    //=> 'H'
```

Parsing
```cpp
to_string(42); //=> "42"
stoi("42");    //=> 42
```

### Info
In C++ and C, a string is an array of `char` terminated with the null character `\0`.
To convert `char` to string:
```cpp
char c = 'c';

// Method 1
string str = std::string() + c; //=> "c"

// Method 2
string str;
str.push_back(c);
```

### Overview
```cpp
string str = "Hello World!";
int len = str.length();                 //=> 12
string str2 = str.substr(6, 5);         //=> "World"
size_t pos = str.find("World");         //=> 6
size_t pos = str.find("Hey");           //=> string::npos
string str3 = str.substr(6);            //=> "World!"
string str4 = str + " Hey!";            //=> "Hello World! Hey!"
int comp = str.compare("Hello World!"); //=> 0
```

### Self-implementations
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

## Iteration
```cpp
// a is a copy of the items we are iterating over
for (auto a : s) {
  cout << a << " ";
}

// a is a reference of the items we are iterating over
for (auto &a : s) {
  cout << a << " ";
}  
```

### Iterators
```cpp
for (vector<int>::iterator it=vect.begin(); it!=vect.end(); ++it) {
    cout << ' ' << *it;
}
```

## Data structures

### Tuple
Import:
```cpp
#include <tuple>
```
#### Overview
```cpp
// Declaration and initialization
tuple<int, int, int> triplet = make_tuple(1, 2, 3);

// Accessor
int first = get<0>(triplet); //=> 1

// Mutator
get<0>(triplet) = 0;
```

### Array
#### Initializations
```cpp
int arr[3] = {1, 2, 3}; //=> [1, 2, 3]
int arr[5] = {1, 2, 3}; //=> [1, 2, 3, 0, 0]  // unspecified values are assigned default values
int arr[5] = {};        //=> [0, 0, 0, 0, 0]
int arr[5];             //=> [?, ?, ?, ?, ?]
int arr[] = {1, 2, 3}   //=> [1, 2, 3]        // implicit size understood by compiler
int arr[] {1, 2, 3}     //=> [1, 2, 3]        // universal initialization
```
Note: The value within square brackets must be a literal or a constant, it cannot be a variable! I.E. The following is illegal
```cpp
int n = 5;
int arr[n];
```

#### Overview
```cpp
int size = int n = sizeof(arr) / sizeof(arr[0]);
```

### std::array
```cpp
array<int, 10> s = {5, 7, 4, 2, 8, 6, 1, 9, 0, 3};
```

### std::vector
Import:
```cpp
#include <vector>
```

#### Overview
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

```cpp
// Length
vect.size():

// Appending
vect.push_back(99);

// Accessor
vect[i];

// Mutator
vect[i] = x;
vect[i]++;

// Removing
vect.erase(myvector.begin() + 5);                    // erase the 6th element
vect.erase(myvector.begin(), myvector.begin() + 3);  // erase the first 3 elements:
```

## Sorting
Import:
```cpp
#include <algorithm>
#include <functional> // if using lambda
```

### Overview
Default order
```cpp
// sort using the default operator<
sort(s.begin(), s.end());
```
Descending order
```cpp
// sort using a standard library compare function object
sort(s.begin(), s.end(), greater<int>());
```

Custom order
```cpp
// Using function object
struct {
    bool operator()(int a, int b) const{   
        return a < b;
    }   
} customComparator;
sort(s.begin(), s.end(), customComparator);

// Using a lambda expression 
sort(s.begin(), s.end(), [](int a, int b) {
    return a < b;   
});
```
Note: default `sort` is not stable. For stable sorting, use `stable_sort`

## Pointers
```cpp
int *ptr;
int a = 3;
ptr = &a;
cout << *ptr;
```

## I/O
### Overview
```cpp
#include <iostream>
#include <string>

int main() {
  int l, r;
  cin >> l >> r;
  cout << l << ' ' << r << endl;
}
```

### Reading until EOF
```cpp
string line; 
stringstream ss;
while(getline(cin, line)){
  if (line.length() == 0) break;
  ss.clear();
  ss.str(line);

  // Read in data
  int num;
  ss >> num;
  // ...
}
```

### Reading 2D array
Here's an example of reading in a 2D `char` array.
```cpp
// Global vars
int maxSize = 200;
char **Array2D;

// Function to read user input
void readArr2D(int rows, int cols) {
  Array2D = new char *[maxSize];
  for (int r=0; r<rows; r++) {
    Array2D[r] = new char[maxSize];
    for (int c=0; c<cols; c++) {
      cin >> Array2D[r][c];
    }
  }
}
```

## OOP
### Struct
```cpp
struct Human {
  string name;
  int age;
  Human* father;
  Human* mother;
};

int main() {
  Human* jack = new Human();
  jack->name = "jack";
  jack->age = 55;

  Human* mary = new Human();
  mary->name = "mary";
  mary->age = 52;

  Human* john = new Human();
  john->name = "john";
  john->age = 25;
  john->father = jack;
  john->mother = mary;
}
```
