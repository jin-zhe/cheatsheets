# Python Cheatsheet
Unless specified otherwise, the following is written for Python 3.

## General
* Python is indentation-based language i.e. indentation defines scope
* Paramenters in Python function are **passed by reference** so modifying their attributes within the function will change them.

### Running Python
```py
python some_code.py               # interpets python code
```
#### Module option
Python has a [`-m` command-line flag](https://docs.python.org/3/using/cmdline.html#cmdoption-m) which when used will import a module or package for you, then run it as a script
```py
python -m http.server 8080        # runs python localhost:8080 using http.server module script
python -m -v doctest filename.py  # doctests are a quick way of writing tests (v: verbose)
```
When you don't use the `-m` flag in regular scenarios, the file you named is run as just a script.
#### Shebang
[See here](https://github.com/jin-zhe/cheatsheets/blob/master/UNIX.md#shebang) for the purpose of the shebang (`#!`) in Unix systems. You may include the shebang at the top of a Python script to execute it without having to type `python` before the code name when running the code from the terminal. After proper configuration of the file manager, shebang also allows for running a python script via double-clicking its file within the file-manager interface.  
For latest version of Python 3 scripts:
```py
#!/usr/bin/env python3
```
For latest version of Python 2 scripts:
```py
#!/usr/bin/env python2
```
For both Python 2 and 3 scripts (NOT RECOMMENDED):
```py
#!/usr/bin/env python
```
### Comments
```py
# Single line comment
"""
Multiple
Line
Comment
"""
```

### Semicolon
Unlike other languages such as C, C++, Java, Javascript etc. Python does not require semi-colons to terminate statements. Semicolons are instead used to delimit statements if you wish to put multiple statements on the same line. For example:
```py
var_1 = 1; var_2 = 2; var_3 = 3;
```

### Continuation charater
`\` is the continuation character. The line following the continuation character is considered a continuation of the current line:
```py
print("hello" + \
  "word")

if x not in range(8) or \
  y not in range(3):
```

### Main method
```py
def main():
  # do something
  
if __name__ == "__main__": main()
```

## I/O
### File
#### Opening and closing
Python uses the following modes when invoking the `open()` function:
* `r`: read (default)
* `rb`: read bytes
* `w`: write
* `wb`: write bytes
* `r+`: read and write

File objects contain a special pair of built-in methods: `__enter__()` and `__exit__()`. When a file object's `__exit__()` method is invoked, it automatically closes the file. Files are typically opened and closed with the following commands:
```py
some_file = open(some_file_path, mode)  # opening a file
some_file.close()                       # closing a file
some_file.closed                        # check if a file is closed
```

The opening and closing of a file can be conveniently handled with a **with-as** clause:
```py
with open(some_file_path, mode) as some_file:
  # do something with some_file
```
Note: `some_file` is automatically closed when the with-as clause upon completion of the containing block. It is also closed when a `return` is made from within the block.

#### Reading
Read the entire file as a string (or otherwise)
```py
with open(some_file_path, mode) as some_file:
  file_contents = some_file.read()
```
Read the file line by line:
```py
with open(some_file_path, read_mode) as some_file:
  for line in some_file:
    # do something with line
```
#### Writing
```py
contents = 'something'
with open(some_file_path, write_mode) as some_file:
  some_file.write(contents)
```
Note: During the I/O process, data is buffered. this means that it is held in a temporary location before being written to the file. Python doesn't flush the buffer—that is, write data to the file—until it's sure you're done writing
One way to do this is to close the file. **If you write to a file without closing, the data won't make it to the target file.**

### Printing
```py
print("Welcome to Python!")         # ends with newline
print("Welcome to Python!", end='') # ends without the default ending newline
print(str1, str2)                   # prints the 2 strings separated by a space
print(arr)                          # prints an array
```

### User input
```py
name = raw_input("What is your name?")  # read in string
num = int(raw_input("give a number"))   # read in number
```

### Selection statement
```py
if condition_1:
  # do something 1
elif condition_2:
  # do something 2
else:
  # do something else
```
Note: There are no switch statements in Python

### Conditional assignment
```py
x = 10 if a > b else 11
```
This is analogous to the more common conditional assigment syntax in other languages:
```rb
x = a > b ? 10 : 11
```

## Built-in Types
### Check types
```py
type('spam')    #=> <type 'str'>
type(1) is int  #=> True
```
### Typecasting
```py
int("1010", 2) == 2
str(2) == "2"         # parse to string
float(2)              # case int 2 into float
```
### Boolean
```py
myBool = True
```
### Boolean operators
```py
and
or
not
```
### Binary
```py
bin(10)       #=> 0b1010
10 == 0b1010  #=> True
```
### Bit manipulation
Note that they return in decimal format
```py
5 >> 4  # Right Shift
5 << 1  # Left Shift
8 & 5   # Bitwise AND
9 | 4   # Bitwise OR
12 ^ 42 # Bitwise XOR
~88     # Bitwise NOT
```
### Strings
```py
s = "String"              # single-line string
s = '''This is a          # multi-lin string
  mutli-line string'''
s[0]        #=> 'S'       # retrieve character
s[1:4]      #=> 'tri'     # slice
len(s)      #=> 6         # string length
s.lower()   #=> "string"  # downcase
s.upper()   #=> "STRING"  # upcase
s.isalpha() #=> True      # Alpha numeric check 
s.startswith('Str') #=> True
s.endswith('ing')   #=> True
','.join('abc')           #=> 'a,b,c'
','.join(['a', 'b', 'c']) #=> 'a,b,c' # For this to work, the argument has to be a list of strings
```
#### Formatting
Old style not recommended:
```py
'%s %s' % ('one', 'two')  #=> 'one two'
'%d %d' % (1, 2)          #=> '1 2'
```
New recommended style:
```py
'{} {}'.format('one', 'two')  #=> 'one two'
'{} {}'.format(1, 2)          #=> '1 2'
'{0} {0} {1}'.format(1, 2)    #=> '1 1 2'
```

## Loops
### For loop
```py
for i in some_list:
  # do something
```
### For-else loop
The else block will execute only when the loop condition is evaluated to `False`. i.e. it will only run once at the end
```py
for number in numbers: 
  # do something
else:
  # do something else
```
### While loop
```py
while condition:
  # do something
```
### While-else loop
Just like for-else loops, the else block is executed only when the while-loops terminates formally
```py
while condition: 
  # do something
else:
  # do something else
```
### Control flow
```py
break     # breaks out of current loop
continue  # continues to next iteration in loop
```

## Data Structures
These are some common data structures used in Python

### List
In python, list, array and stack are equivalent data structures. For the sake of consistency, they shall be referred to as *arrays* for the rest of this cheatsheet and our variable name for the array is `arr`.

#### Declaration and initialization
Single-dimensional array:
```py
arr = [5, 6, 7, 8]            #=> [5, 6, 7, 8] # explicit assignment
arr = [1] * 4                 #=> [1, 1, 1, 1] # generative assignment
arr = list(range(5,9))        #=> [5, 6, 7, 8] # generative assignment using range
arr = [x for x in range(5,9)] #=> [5, 6, 7, 8] # generative assignment using range and list comprehension (see list comprehension section below)
```
Multi-dimensional array:
```py
arr = [[1,2,3],[4,5,6]]   #=> [[1, 2, 3], [4, 5, 6]]    # explicit assignment
arr = [[1]*2]*3           #=> [[1, 1], [1, 1], [1, 1]]  # generative assignment
# The methods using range and list comprehension for single-dimensional array works for multi-dimensions as expected and is left out for brevity
```
#### Range
`range(start, stop, step)` provides a convenient construct for generating an ordered list of numbers
```py
range(6)            #=> [0,1,2,3,4,5]
range(1,6)          #=> [1,2,3,4,5]
range(1,6,3)        #=> [1,4]
range(10,-1,-1)     #=> [10,9,8,7,6,5,4,3,2,1,0]

3 in range(1,4)     #=> True
3 not in range(1,4) #=> False
```

#### Membership
```py
arr.count(item)         # counts the number of times item appears in array 
arr.index(item)         # returns index of first occurence of the item
arr.insert(index, item) # inserts item at position index, suceeding elements are pushed down | in-place | does not return
arr.append(item)        # append item to end of list | in-place | does not return
arr.remove(item)        # remove item | in-place | does not return
arr.pop(index)          # removes object at index and returns it (if not index provided, will pop last) | in-place | returns popped item
del(arr[index])         # same as pop exept it doesn't return the object
```
#### Slicing
Slicing is achieved with the `[start:end:stride]` operator

* `start` describes where the slice starts (inclusive)
  * If not provided, value defaults *0*
* `end` is where it ends (exclusive)
  * If not provided, value defaults *length of array*. I.E. Operation defaults to `[start:length:1]`
  * If value is negative, Python interpreter will subtract that value off the length of array. For example `a[start:-x]` is translated to `arr[start:length-x]`
* `stride` indicates the interval between items in the sliced list
  * If not provided, value defaults to *1*. I.E. Operation defaults to `[start:end:1]`
  * `start` and `end` defines the sequence for stride to traverse
  * `stride` indicates the interval in sequence for which objects are picked. For example, a stride of 2 will skip 1 item in sequence at every interval.
  * a positive stride length traverses the sequence in sequential order
  * a negative stride traverses the sequence in reverse order
```py
arr = [0, 1, 2, 3, 4, 5, 6, 7, 8 ,9]
arr[:2]   #=> [0, 1]
arr[3:6]  #=> [2, 3, 4]
arr[:-5]  #=> [0 ,1, 2, 3, 4] # Python interpreter translates to arr[0:5]
arr[::2]  #=> [0, 2, 4, 6, 8]
arr[::-1] #=> [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
```

#### Concatenating
```py
arr1 = [1, 2, 3]
arr2 = [4, 5, 6]
arr1 + arr2       #=> [1, 2, 3, 4, 5, 6]
```

#### List comprehension
List comprehension is commonly used as a shorthand for creating a new list by iterating over a given list.

It is commonly used as a filter by applying a condition over the given list:
```py
a = [1, 2, 3, 4]
odd_a = [x for x in a if i%2 == 0] #=> [2, 4]
```
It is also commonly used for modifying each item in the given list:
```py 
a = [1, 2, 3, 4]
squared_a = [x**2 for x in a] #=> [1, 4, 9, 16]
```
We can also nest lists within the comprehension to iterate through multi-dimensional arrays. One application for this is to flatten out a multi-dimensional array:
```py
arr_2d = [[1, 2, 3], [4, 5, 6]]
flattened_arr = [x for row in arr_2d for x in row ]
```

#### Iterating
To iterate over all items in the array:
```py
for item in arr:
  # do something with item
```
To iterate over all indices for items in the array:
```py
for index in range(len(arr)):
  # do something with index
```
To iterate over all indicies and their accompanying items in the array:
```py
for index, item in enumerate(arr):
  # do something with index, item
```
To iterate all items in the array in reversed order (without using slice):
```py
for item in reversed(arr):
  # do something with item
```
use `zip` to iterate over multiple lists at once (terminating on the shorter list):
```py
for item_1, item_2, item_3 in zip(arr_1, arr_2, arr_3):
  # do something with item_1, item_2, item_3
```
#### Sorting
```py
arr.sort()                          # in-place sorting
tuples = [(5,99), (4,54), (3,12), (2,44)]
sorted(tuples)                      # returns (2,44), (3,12), (4,54), (5,99)
sorted(tuples, key=lambda x: x[1])  # returns (3,12), (2,44), (4,54), (5,99)
```

### Dictionary
In Python dictionary is equivalent to hashmap

#### Declaration and initialization
Declaring an empty dictionary:
```py
dic = {}
dic = dict()  # using contructor
```

Declaring and initializing with values:
```py
dic = {'key_1' : val_1, 'key_2' : val_2}          # via explicit assignment
dic = dict([('key_1', val_1), ('key_2', val_2)])  # via key,val pair list
dic = dict(key_1=val_1, key_2=val_2)              # via keyword arguments
dic = {x: x**2 for x in (1, 2, 3)}                # via dict comprehensions 
```

#### Membership
Common methods to check and update members
```py
key in dic        # check if key is in dic
dic[key] = value  # adding/updating value. Note key can be a number
del dic[key]      # delete (key, val) from dic
```
Common methods to extract members:
```py
dic.items()   # returns an array of (key, value) tuples, not in any order
dic.keys()    # returns an array of keys, not in any order
dic.values()  # return an array of values, not in any order
```
#### Iterating
```py
# Iterates each key (not guaranteed same order everytime)
for key in hashmap:
  # Do something with key
  
# Iterates each key, value pair
for key, value in hashmap.items():
  # Do something with key, value
```
#### Sorting
To get a sorted list of keys:
```py
sorted(hashmap)
```
#### Shorthands
```py
dic = {'a': 1, 'b': 2, 'c': 3}
[value for (key, value) in sorted(dic.items())] #=> [1, 2, 3]
```

## Math
Python contains useful inbuilt math functions
```py
a = [2,3,4,5]
max(a)  #=> 5
min(a)  #=> 2
sum(a)  #=> 14
b = -1
abs(b)  #=> 1
```

## Importing
```py
import math                   # import math module
from datetime import datetime # import datetime function from datetime module
from math import *            # import all functions from math module into global namespace
```
Note of caution for `from math import *`: If you have a function of your very own named sqrt and you `import math`,      your function is safe: there is your `sqrt` and there is `math.sqrt`. However if you do from `math import *`, you have a problem, namely, two different functions with the exact same name.

To return an array of strings listing all the function names in module:
```py
dir(module)
```

### Common modules
#### os
```
import os
os.getcwd()                     # get current working directory
os.chdir("d/jinzhe")            # change directory
os.listdir(".")                 # list files in current working directory
os.path.join(par_dir, rel_path) # join par_dir and rel_path together
os.path.abspath(rel_path)       # get the absolute path give relative path
```
#### datetime
```py
import datetime
date = datetime.now()   # current date and time
date.year
date.month
date.day
date.hour
date.minute
date.second
```
#### random
```py
from random import randint
randint(low, high)  # generates random interger between low to high inclusive
```
#### enum (only available on Python 3.4 onwards)
```py
from enum import Enum
class EdgeDetector(Enum):
  prewit = 0
  sobel = 1
```

## Functions
The default function return value in Python is `None`
```py
def some_function(param_1, kwarg_1=default_kwarg_1_val):
  # do something
  return ans
```
### Lambda: anonymous functions
```py
arr = [0, 1, 2, 3, 4, 5, 6]
filter(lambda x: x % 3 == 0, arr) #=> [0, 3, 6]
```
## Class
### Declaration
There are multiple ways to declare a class.

Python 3: Delcare a class with implicit inheritance of `object` class:
```py
class MyClass:
  pass
```

Python 3: Declare a class with implicit inheritance of `object` class:

Python 2: Declare an old-style class:
```py
class MyClass():
 pass
```

Python 3: Declare a class with explicit inheritance of `object` class:

Python 2: Declare a new-style class:
```py
class MyClass(object):
  pass
```
See here on [old-style and new-style classes](https://docs.python.org/release/2.5.2/ref/node33.html)

### Instantiation
```py
my_class_object = MyClass(attr1, attr2, attr3) # instantiating MyClass
```

### Methods
#### Constructor
The first argument `__init__()` gets is used to refer to the instance object by convention, that argument is called `self`. If you add additional arguments in the body of `__init__()`, you need to give each instance those attributes. `self` is only passed as an argument when defining methods, but are left out when calling them.

#### Class representation
By providing a return value in this method, we can tell Python how to represent an object of our class (for instance, when using a print statement)
```py
__repr__(self):  
  return "(#{}, #{}, #{})" % (self.attr_1, self.attr_2, self.attr_3)
```

### Class example
```py
class MyClass(object):
  # class attributes or "member variables", information that belongs to the class object
  attr_1 = attr_1_val  # Note: must be referenced later via self.attr_1

  # constructor with instance attributes
  def __init__(self, attr1, attr2, attr3):
    self.attr1 = attr1
    self.attr2 = attr2
    self.attr3 = attr3

    # methods (need to pass in self)
    def method_1(self, param_1, param_2):
      return doSum
```
### Inheritance example
```py
class MyOtherClass(MyClass):
  # new constructor
  def __init__(self, attr1, attr2, attr3, attr4):
    super(MyOtherClass, self).__init__(attr1, attr2, attr3) # super method (don't have to include self)
    self.attr4 = attr4

  # override method_1 from MyClass
  def method_1(self):
    return doSum2

  def oldMethod(self):
    return super(MyOtherClass, self).aMethod()  # super method. Note the return statement
```

### Misc
```py
len(some_object) # returns length attribute of the object
```
## Other libraries
### NLTK
```py
s = '''' Good muffins cost $3.88\nin New York.  Please buy me\n    ... two of them.\n\nThanks. '''
[word_tokenize(t) for t in sent_tokenize(s)]  #=> [['Good', 'muffins', 'cost', '$', '3.88', 'in', 'New', 'York', '.'], ['Please', 'buy', 'me', 'two', 'of', 'them', '.'], ['Thanks', '.']]
```

### Pyplot
```py
import matplotlib.pyplot as plt
  
# plot histogram
plt.hist(values, cumulative=True, bins=256)
plt.title("%s CDF" % image_name)
plt.xlabel("Intensity")
plt.ylabel("Cumulative Frequency")
plt.show()
```
### openCV
```py
import cv2
# read image as np array
cv2.imread(path, cv2.CV_LOAD_IMAGE_GRAYSCALE) # read image as grayscale

# write np array as image
cv2.imwrite(path, image)

# display an image
cv2.imshow('image',image)
cv2.waitKey(0)
cv2.destroyAllWindows()
```
