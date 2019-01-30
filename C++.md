# C++ Cheatsheet
This is a work in progress

## General
Importing
```cpp
#include <package_name>
using namespace std;
```

## Strings

### Import
```cpp
#include <string>
````

### Declaration
```cpp
// Assignment via string literal
std::string str = "Hello world!";

// Initialization using char array
char arr[] = "Hello world!";
std::string str(arr);
str.at(0); //=> 'H'
```

### Parsing
```cpp
std::to_string(42); //=> "42"
std::stoi("42");    //=> 42
```

### Info
In C++ and C, a string is an array of `char` terminated with the null character `\0`.
To convert `char` to string:
```cpp
char c = 'c';

// Method 1
std::string str = std::string() + c; //=> "c"

// Method 2
std::string str;
str.push_back(c);
```

### Overview
```cpp
std::string str = "Hello World!";
int len = str.length();                 //=> 12
std::string str2 = str.substr(6, 5);   //=> "World"
std::size_t pos = str.find("World");    //=> 6
std::size_t pos = str.find("Hey");      //=> std::string::npos
std::string str3 = str.substr(6);       //=> "World!"
std::string str4 = str + " Hey!";       //=> "Hello World! Hey!"
int comp = str.compare("Hello World!"); //=> 0
```

### Self-implementations
```cpp
// Returns the index of the first occurence of the substring, else -1
int find(std::string str, std::string subStr) {
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
for (auto a : s) {
  std::cout << a << " ";
}  
```

### Iterators
```cpp
for (std::vector<int>::iterator it=myvector.begin(); it!=myvector.end(); ++it) {
    std::cout << ' ' << *it;
}
```

## Data structures
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
std::array<int, 10> s = {5, 7, 4, 2, 8, 6, 1, 9, 0, 3};
```

### std::vector
Import:
```cpp
#include <vector>
```
#### Overview
Initialization
```cpp
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
vect.erase (myvector.begin() + 5);                    // erase the 6th element
vect.erase (myvector.begin(), myvector.begin() + 3);  // erase the first 3 elements:
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
std::sort(s.begin(), s.end());
```
Descending order
```cpp
// sort using a standard library compare function object
std::sort(s.begin(), s.end(), std::greater<int>());
```

Custom order
```cpp
struct {
    bool operator()(int a, int b) const{   
        return a < b;
    }   
} customComparator;
std::sort(s.begin(), s.end(), customComparator);

// sort using a lambda expression 
std::sort(s.begin(), s.end(), [](int a, int b) {
    return a < b;   
});
```
Note: default `std::sort` doesn't guarantee stable sorting. For stable sorting, use `std::stable_sort`

## Pointers
```cpp
int *ptr;
int a = 3;
ptr = &a;
std::cout << *ptr;
```

## I/O
### Overview
```cpp
#include <iostream>
#include <string>

int main() {
  int l, r;
  std::cin >> l >> r;
  std::cout << l << ' ' << r << std::endl;
}
```

### Reading until EOF
```cpp
std::string line; 
std::stringstream ss;
while(std::getline(std::cin, line)){
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
      std::cin >> Array2D[r][c];
    }
  }
}
```

## Library
### Tuple
```cpp
#include <tuple>
// ...
std::tuple<int, int, int> triplet = std::make_tuple(1, 2, 3);
int first = std::get<0>(triplet); //=> 1
```
