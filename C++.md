



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
