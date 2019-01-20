## Strings
Import:
```cpp
#include <string>
````

```cpp
std::string str = "We think in generalities, but we live in details.";
int len = str.length();               //=> 49
std::string str2 = str.substr(3,5);   //=> "think"
std::size_t pos = str.find("live");   //=> 34
std::size_t pos = str.find("hello");  //=> std::string::npos
std::string str3 = str.substr(34);    //=> "live in details."
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
```cpp
int []arr = {1, 2, 3};
sizeof(arr); //=> 3
```

## Pointers
```cpp
  int *ptr;
  int a = 3;
  ptr = &a;
  std::cout << *ptr;
```

## I/O
### Reading and printing
```cpp
#include <iostream>
#include <string>

int main() {
  int l, r;
  std::cin >> l >> r;
  std::cout << l << ' ' << r << std::endl;
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
