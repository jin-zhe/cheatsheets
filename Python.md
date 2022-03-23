# Python Cheatsheet
TODO: This cheatsheet will be converted into a Python notebook in the future.

Unless specified otherwise, the following is written for Python 3.

## TODO
* `any() and all()`
* `Pathlib`
* Variable scope

## General
* Python is indentation-based language i.e. indentation defines scope
* Arguments in Python function are **passed by reference** so modifying their attributes within the function will change them.

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
print(lst)                          # prints an list
```

### User input
See [here](https://stackabuse.com/getting-user-input-in-python/) for more info.
#### Python 2
```py
name = raw_input("What is your name?")  # read in string
num = int(raw_input("give a number"))   # read in number
```
#### Python 3
```py
name = input("What is your name?")  # read in string
num = float(input("give a number")) # read in number
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
int('1010', 2)  #=> 2     # cast from binary to decimal int
str(2)          #=> "2"   # cast to string
float(2)        #=> 2.0   # cast int 2 into float
```
### Binary
```py
bin(10)       #=> 0b1010
10 == 0b1010  #=> True
```
### Boolean
```py
myBool = True
```
### Operations
#### Boolean
```py
x and y # CONJUNCTION
x or y  # DISJUNCTION
not x   # NEGATION
```
#### Bitwise
Note that they return in decimal format
```py
x | y   # bitwise OR of x and y
x ^ y   # bitwise EXCLUSIVE OR of x and y 
x & y   # bitwise AND of x and y
~x      # NOT of the bits of x
x << n  # x shifted left by n bits
x >> n  # x shifted right by n bits
```
#### Numeric
```py
x + y   # sum of x and y
x - y   # difference of x and y
x * y   # product of x and y
x / y   # quotient of x and y
x // y  # floored quotient of x and y
x % y   # remainder of x / y
-x      # x negated
+x      # x unchanged
x ** y  # x to the power y
```
See [PEP 238](https://www.python.org/dev/peps/pep-0238/) regarding floor division operator.

### Math
Python contains useful inbuilt math functions
```py
a = [2,3,4,5]
max(a)        #=> 5
min(a)        #=> 2
sum(a)        #=> 14
abs(-1)       #=> 1
pow(x, y)     #=> x ** y
divmod(x, y)  #=> (x // y, x % y)
complex(re, im)   # a complex number with real part re, imaginary part im. im defaults to zero.
c.conjugate()     # conjugate of the complex number c
```
### Strings
```py
s = "String"              # single-line string
s = '''This is a
  mutli-line string'''
s[0]        #=> 'S'       # retrieve character
s[1:4]      #=> 'tri'     # slice
len(s)      #=> 6         # string length
s.lower()   #=> "string"  # downcase
s.upper()   #=> "STRING"  # upcase
s.isalpha() #=> True      # Alpha numeric check 
s.startswith('Str') #=> True
s.endswith('ing')   #=> True
'hello ' + 'world'  #=> 'hello world' # concatenation
','.join('abc')           #=> 'a,b,c'
','.join(['a', 'b', 'c']) #=> 'a,b,c' # For this to work, the argument has to be a list of strings
```
#### Formatting
Old style not recommended:
```py
'%s %s' % ('one', 'two')      #=> 'one two'
'%d %d' % (1, 2)              #=> '1 2'
'%2.2f%%' % (0.93788 * 100)   #=> '93.79%'
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

## Iterators
### Iterator basics
```py
lst = [3,1,4,1,5,9,2,6,5]
lst_itr = iter(lst) # creates a fresh iterator over lst

# Simple function that advances the iterator until exhaustion, priting each value along the way
def print_iter(itr):
  while True:
    value = next(itr, None) # this will advance the iterator and return the item itr is currently pointing to. Here we explicitly stated that when itr reaches past the last item, we want it to return None. If second argument is not provided, Python will throw the StopIteration error.
    if value: # if not None
      print(value)
    else:
      break
```
### Casting iterators
```py
print_iter(lst_itr)
print('Empty List:', list(lst_itr)) # At this point in time the iterator has exhausted and therefore this will return an empty list
lst_itr = iter(lst) # re-assign fresh iterator
print('Casting fresh iterator as list:',list(lst_itr)) # You can cast a fresh iterator as a list. Doing so will exhaust the iterator!
print('Exhausted iterable casted as list will be empty:',list(lst_itr)) # This will print [] because the iterator has exhausted again at this point
```
### Map object is an iterator
```py
doubled = map(lambda x: 2*x, lst)
print_iter(doubled) # proves that map object is just an iterator
print('Exhausted map iterable casted as list will be empty:', list(doubled))
```

## Data Structures
These are some common data structures used in Python

### List
In python, lists are variable length arrays much like `ArrayList` in C++ and `Vector` in Java. Lists offer random access and has similar time complexities (see [here](https://wiki.python.org/moin/TimeComplexity)) as variable length arrays in other languages. For the sake of consistency, we shall reserve the variable `lst` to refer to a list in the given context.

#### Declaration and initialization
##### Single-dimensional list:
```py
lst = [5, 6, 7, 8]            #=> [5, 6, 7, 8] # explicit assignment
lst = [1] * 4                 #=> [1, 1, 1, 1] # generative assignment
lst = list(range(5,9))        #=> [5, 6, 7, 8] # generative assignment using range
lst = [x for x in range(5,9)] #=> [5, 6, 7, 8] # generative assignment using range and list comprehension (see list comprehension section below)
```
##### Multi-dimensional lists:
```py
# Explicit assignment
lst = [[1,2,3],[4,5,6]] #=> [[0, 0], [0, 0], [0, 0]] 

# Generative assignment
cols = 2; rows = 3
lst = [[0] * cols for i in range(rows)] #=> [[0, 0], [0, 0], [0, 0]] 
```
Caveat (see [here](https://stackoverflow.com/questions/17636567/python-initialize-multi-dimensional-list)):
```py
cols = 2; rows = 3
lst = [[0] * cols] * rows #=> [[0, 0], [0, 0], [0, 0]]
lst[0][1] = 1
print(lst)                #=> [[0, 1], [0, 1], [0, 1]]
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
lst.count(item)         # counts the number of times item appears in list 
lst.index(item)         # returns index of first occurence of the item
lst.insert(index, item) # inserts item at position index, suceeding elements are pushed down | in-place | does not return
lst.append(item)        # append item to end of list | in-place | does not return
lst.remove(item)        # remove item | in-place | does not return
lst.pop(index)          # removes object at index and returns it (if not index provided, will pop last) | in-place | returns popped item
del(lst[index])         # same as pop exept it doesn't return the object
del lst[index]          # same as above
```
#### Slicing
Slicing is achieved with the `[start:end:stride]` operator

* `start` describes where the slice starts (inclusive)
  * If not provided, value defaults to *0*
* `end` is where it ends (exclusive)
  * If not provided, value defaults to *length of list*. I.E. Operation defaults to `[start:length:1]`
  * If value is negative, Python interpreter will subtract that value off the length of list. For example `a[start:-x]` is translated to `lst[start:length-x]`
* `stride` indicates the interval between items in the sliced list
  * If not provided, value defaults to *1*. I.E. Operation defaults to `[start:end:1]`
  * `start` and `end` defines the sequence for stride to traverse
  * `stride` indicates the interval in sequence for which objects are picked. For example, a stride of 2 will skip 1 item in sequence at every interval.
  * a positive stride length traverses the sequence in sequential order
  * a negative stride traverses the sequence in reverse order
```py
lst = [0, 1, 2, 3, 4, 5, 6, 7, 8 ,9]
lst[:2]   #=> [0, 1]
lst[3:6]  #=> [2, 3, 4]
lst[:-5]  #=> [0 ,1, 2, 3, 4] # Python interpreter translates to lst[0:5]
lst[::2]  #=> [0, 2, 4, 6, 8]
lst[::-1] #=> [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
```

#### Concatenating
```py
lst1 = [1, 2, 3]
lst2 = [4, 5, 6]
lst1 + lst2       #=> [1, 2, 3, 4, 5, 6]
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
squared_even_a = [x**2 if x%2 == 0 else x for x in a] #=> [1, 4, 3, 16]
```
We can also nest lists within the comprehension to iterate through multi-dimensional lists. One application for this is to flatten out a multi-dimensional list:
```py
lst_2d = [[1, 2, 3], [4, 5, 6]]
flattened_lst = [x for row in lst_2d for x in row ] #=> [1, 2, 3, 4, 5, 6] 
```

#### Iterating
To iterate over all items in the list:
```py
for item in lst:
  # do something with item
```
To iterate over all indices for items in the list:
```py
for index in range(len(lst)):
  # do something with index
```
To iterate over all indicies and their accompanying items in the list:
```py
for index, item in enumerate(lst):
  # do something with index, item
```
To iterate all items in the list in reversed order (without using slice):
```py
for item in reversed(lst):
  # do something with item
```
use `zip` to iterate over multiple lists at once (terminating on the shorter list):
```py
for item_1, item_2, item_3 in zip(lst_1, lst_2, lst_3):
  # do something with item_1, item_2, item_3
```
#### Sorting
```py
lst.sort()                          # in-place sorting
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
dic.items()   # returns an list of (key, value) tuples, not in any order
dic.keys()    # returns an list of keys, not in any order
dic.values()  # return an list of values, not in any order
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

## Importing
```py
import math                   # import math module
from datetime import datetime # import datetime function from datetime module
from math import *            # import all functions from math module into global namespace
```
Note of caution for `from math import *`: If you have a function of your very own named sqrt and you `import math`,      your function is safe: there is your `sqrt` and there is `math.sqrt`. However if you do from `math import *`, you have a problem, namely, two different functions with the exact same name.

To return an list of strings listing all the function names in module:
```py
dir(module)
```

### Common modules
#### os
```py
import os
os.getcwd()                     # get current working directory
os.chdir("d/jinzhe")            # change directory
os.listdir(".")                 # list files in current working directory
os.path.join(par_dir, rel_path) # join par_dir and rel_path together
os.path.abspath(rel_path)       # get the absolute path give relative path
```
#### sys
```py
import sys
```
Getting arguments:
```py
sys.argv[1] # first argument
```
Pythonpath stores the list of directories Python scans through when locating modules and files. You may append directories to your Pythonpath via `sys.path.append` instead of appending to `$PYTHONPATH` environment variable:
```py
sys.path.append(some_path) 
```
#### argparse
See [here](https://docs.python.org/3/library/argparse.html#the-add-argument-method) for all available arugments of `add_argument()` method
```py
import argparse

parser = argparse.ArgumentParser(description="Description of script")
parser.add_argument('--flag', '-f', action='store_true')
parser.add_argument('--input', '-i', type=int, default=1, help='Help text for input argument')
args = parser.parse_args()
args.flag   # gets boolean if flag was indicated
args.input  # gets argument for --input
```
#### pickle
##### Python 2
```py
import cPickle as pkl
loaded_pickle = pkl.load(open(pickle_path, "r" ))   # loading
pkl.dump(payload, open(pickle_path, "w" ))          # dumping
```
##### Python 3
```py
import pickle as pkl
loaded_pickle = pkl.load(open(pickle_path, "rb" ))  # loading
pkl.dump(payload, open(pickle_path, "wb" ))         # dumping
```
#### defaultdict
```py
from collections import defaultdict

# int type: non-existent keys will have default value 0 when first called
dic = defaultdict(int)
dic[key] += n

# list type: non-existent keys will have default value list() when first called
dic = defaultdict(list)
dic[key].append(n)

# set type: non-existent keys will have default value set() when first called
dic = defaultdict(set)
dic[key].add(n)
```
#### namedtuple
TODO
```py
from collections import namedtuple
```
#### ordereddict
TODO
```py
from collections import OrderedDict
```
#### re
```py
import re
re.search(r'\d+\.\d*N','1.312740N, 103.779490E').group(0) #=> '1.312740N'
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

#### multiprocessing.Pool
See [API](https://docs.python.org/3/library/multiprocessing.html#module-multiprocessing.pool)

Importing:
```py
from multiprocessing import Pool
```
Pool:
```py
pool = Pool() # If processes is None then the number returned by multiprocessing.cpu_count()
# do something
pool.close()

# Using `with` clause
with Pool(processes=4) as pool:
  # do something
```
* Make sure function is defined before Pool istantiates! Otherwise the worker cannot see the function

Using `pool.apply_async`:
```py
result_1 = pool.apply_async(f, 1)    # evaluate `f(1)` asynchronously
result_2 = pool.apply_async(f, 2)    # evaluate `f(2)` asynchronously
answer_1 = result_1.get(timeout=10)
answer_2 = result_2.get(timeout=10)
```
Using `pool.map`:
```py
result_1, result_2 = pool.map(f, [1,2])
```
* This function only works for single argument functions! Use a function wrapper which takes in a single tuple if parallelizing multi argument functions

#### multiprocessing.Process
```py
from multiprocessing import Pool

def f(arg):
  # do something

args_list = [1,2,3,4]
for arg in args_list:
  p = Process(target=f, args=(arg,))
  p.start()
  p.join()
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
lst = [0, 1, 2, 3, 4, 5, 6]
filter(lambda x: x % 3 == 0, lst) #=> [0, 3, 6]
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
      # do something
```
### Inheritance example
Note that the following calls `super` in Python 3 syntax. Click [here](https://powerfulpython.com/blog/main-difference-python-3/) for a comparison between the `super` syntax for Python 2 vs 3.
```py
class MyOtherClass(MyClass):
  # new constructor
  def __init__(self, attr1, attr2, attr3, attr4):
    super().__init__(attr1, attr2, attr3) # super method (don't have to include self)
    self.attr4 = attr4

  # override method_1 from MyClass
  def method_1(self):
    # do something new

  def old_method_1(self):
    return super().method_1()  # super method. Note the return statement
```

### kwargs
```py
def func(**kwargs):
  # do stuff with kwargs['a'] and kwargs['b']

func(a=1, b=3)
```
```py
def func(a, b):
  print(a, b)

func(**{'a': 1, 'b': 2}) # same as func(1, 2)
#=> 1 2
```
### Tuples
Tuples are immutable in Python
```py
uniple = (1,)
pair = (1, 2)
triplet = (1, 2) + (3,) # creates a new tuplet
```

### Misc
```py
len(some_object) # returns length attribute of the object
```

## Exception handling
### Common exceptions
Exception | Description
--- | ---
`IOError` | Raised when a file cannot be opened
`ImportError` | Raised when python cannot find the module
`ValueError` | Raised when a built-in operation or function receives an argument that has the right type but an inappropriate value
`ZeroDivisionError` | Raised when division by zero occurs
`EOFError` | Raised when one of the built-in functions (input() or raw_input()) hits an end-of-file condition (EOF) without reading any data
`KeyboardInterrupt` | Raised when the user hits the interrupt key (normally Control-C or Delete)
`ValueError` | Raised when a built-in operation or function receives an argument that has the right type but an inappropriate value

See [Built-in Exceptions](https://docs.python.org/3/library/exceptions.html) for the full list of Python exceptions that come out of the box.

### Catching exceptions
try-except:
```py
try:
  # something dangerous

except IOError:
  # do something
  
except (RuntimeError, TypeError, NameError): # multiple exceptions
  # do something
  
# Generic exception: Catches all exceptions
except Exception as e: # access exception variable with `as e`
  # do something. e.g `print(str(e))`
```

Else:
```py
try:
  # something dangerous
  
except KeyboardInterrupt:
  # do something

# ONLY WHEN preceding except clauses did not catch anything
else:
  # do something
  # NOTE: Code in this block may raise exceptions of its own
```

Finally:
```py
try:
  # something dangerous

except KeyboardInterrupt:
  # do something

else:
  # do something

# Always executed before leaving the try statement, regardless if an exception occurred or not
finally:
  # do something
  
```
### Raising exceptions
Raising pre-defined exceptions:
```py
raise IOError
raise SyntaxError("Oops!") # Add a custom message
```
Raising custom exception:
```py
class MyException(Exception):
  pass

raise MyException("Truly exceptional!")
```
