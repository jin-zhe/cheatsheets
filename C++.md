## Strings
### Import
```cpp
#include <string>
````

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
std::string str2 = str.substr(6, 11);   //=> "World"
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

## Arrays
### Initializations
```cpp
int arr[3] = {1, 2, 3}; //=> [1, 2, 3]
int arr[5] = {1, 2, 3}; //=> [1, 2, 3, 0, 0]  // unspecified values are assigned default values
int arr[5] = {};        //=> [0, 0, 0, 0, 0]
int arr[] = {1, 2, 3}   //=> [1, 2, 3]        // implicit size understood by compiler
int arr[] {1, 2, 3}     //=> [1, 2, 3]        // universal initialization
```

### Overview
```cpp
```

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
