# running python
  python filename.py
  python -m -v doctest filename.py  # doctests are a quick way of writing tests (v: verbose)
# single line comment
"""
  Phyton is indentation-based i.e. indentation indicates scope
"""
print "Welcome to Python!"  # newline
print "foo %s bar %s" % (string_1, string_2)
print str1, print str2    # prints on same line seperated by space
print str1, str2      # same as above
print anArray       # prints an array

#  \ continuation character, following line is considered a continuation of the current line
  print "hello" + \
  "word"

  if x not in range(8) or \
    y not in range(3):

# userinput
  name = raw_input("What is your name?")  # read in string
  num = int(raw_input("give a number"))   # read in number

# typecast
  int("1010", 2) == 2
  str(2) == "2" # parse to string
  float(2)    # case int 2 into float

# inbuilt functions
  max(*args)  # e.g. max(2,3,4,5)
  min(*args)  # e.g. min(2,3,4,5)
  abs(arg)
  sum(array)
  type(arg) # e.g. type('spam') returns <type 'str'>, type(1) is int == True

# modules
  import math           # import math module
  from datetime import datetime # import datetime function from datetime module
  from math import *        # import all functions from math module
  """
     you have a function of your very own named sqrt and you import math, 
     your function is safe: there is your sqrt and there is math.sqrt.
     If you do from math import *, however, you have a problem:
     namely, two different functions with the exact same name.
  """
  dir(module) # returns an array of strings listing all the function names in module

# Boolean
  myBool = True # boolean
  and
  or
  not

# Strings
  myStr = "String"
  myStr[0] == "S"
  myStr[1:4] == "tri"   # slice
  len(myStr) == 6
  myStr.lower() == "string"
  myStr.upper() == "STRING"
  myStr.isalpha() == True
  
  letters = ['a', 'b', 'c', 'd']
  "-".join(letters) == "a-b-c-d"

# datetime
  date = datetime.now()   # current date and time
  date.year
  date.month
  date.day
  date.hour
  date.minute
  date.second

# selection
  if boolean1:
    doSum
  elif boolean2:
    doSum
  else:
    doSum

  x = 10 if a > b else 11 # analogous to x = (z > b)? 10: 11; 

# methods
  def tax(bill):
      bill *= 1.08
      print "With tax: %f" % bill
      return bill

    # changes the actual array i.e. passed by reference
    def doSum(anArray):
      anArray[0] = anArray[0] * 2

    # Note: default return value is None

# lambda: anonymous functions
  filter(lambda x: x % 3 == 0, my_list)

 # array == list == stack
  numbers = [5, 6, 7, 8]    # declaration method 1
  numbers = [1] * 10      # declaration method 2
  numbers.index(6) == 2     # first index that contains the object
  numbers.insert(index, obj)  # inserts obj at position index, suceeding elements are pushed down
  anArray.append(obj)     # append object
  anArray.remove(obj)     # remove object (method does not return anything)
  anArray.pop(index)      # removes object at index and returns it (if not index provided, will pop last)
  del(anArray[index])     # same as pop expect it doesn't return the object
  [1,1,1].count(1) == 3     # counts the number of given parameter in array 

  """
  Slice
    anArray[start:end:stride]
    start describes where the slice starts (inclusive)
    end is where it ends (exclusive),
    stride describes the space between items in the sliced list. 
    if a value is not provided, its default value is taken. [0:len:1]
    a positive stride length traverses the list from left to right
    a negative one traverses the list from right to left
  """
    anArray[:2]         # Grabs the first two items
    anArray[3:]         # Grabs the fourth through last items
    anArray[::2]        # choose objects seperated apart by 2
    anArray[::-1]       # reverses the list
  
  array1 + array2       # concatenate 2 arrays
  [i**2 for i in range(11) if i%2 == 0] # list comprehension. creates [0,4,9,16,25,36,49,56,81,100]

  for index, item in enumerate(anArray):
    doSum

  for a, b in zip(list_a, list_b, list_c):  # iterates multiple lists at once (terminates on the shorter list)
    doSum

  # TODO reverse an array
  for i in reversed(anArray)

# hashmap
  hashmap = {}                  # initialisation (optional)
  hashmap = {'key1' : 1, 'key2' : 2, 'key3' : 3}  # same as js but note that keys are NOT considered as attributes
  hashmap[key] = new_value            # adding/updating value
  del dict_name[key_name]             # delete key,val
  for key in hashmap:               # iterates each key (not guaranteed same order everytime)
    # Do stuff
  for key, value in hashmap.items()
  key in hashmap == True/False          # test if key is in hashmap
  hashmap.items()                 # returns an array of (key, value) tuples, not in any order
  hashmap.keys()                  # returns an array of keys, not in any order
  hashmap.values()                # return an array of values, not in any order
  sorted(hashmap)                 # returns sorted list of keys

  [value for (key, value) in sorted(hashmap.items())] # returns [1, 2, 3]

# sorting
  anArray.sort()        # in-place sorting
  tuples = [(5,99), (4,54), (3,12), (2,44)]
  sorted(tuples)            # returns (2,44), (3,12), (4,54), (5,99)
  sorted(tuples, key=lambda x: x[1])  # returns (3,12), (2,44), (4,54), (5,99)

 # loops
  break # breaks all loops

  for variable in list_name:
      doSum

    for i in range(len(array)):
      print array[i]

    while count < 5:
      doSum

    # while/else loops: the else block will execute anytime the loop condition is evaluated to False. i.e. it will only run once at the end
    while condition: 
      doSum
    else:
      doOther

    # for/else loops: just like while/else loops, else block runs iff for loops terminates formally
    for number in numbers: 
      doSum
    else:
      doOther
# random
  from random import randint
  randint(low, high)  # generates random interger between low to high inclusive

 # range(start, stop, step) for generating a list of numbers
  range(6)          # => [0,1,2,3,4,5]
  range(1,6)          # => [1,2,3,4,5]
  range(1,6,3)        # => [1,4]
  range(10,-1,-1)       # => [10,9,8,7,6,5,4,3,2,1,0]

  3 in range(1,4) == True
  3 not in range(1,4) == False

# binary manipulation
  bin(10) == 0b1010
  10 == 0b1010

  # bitwise operators. Note that they return in decimal format
  5 >> 4  # Right Shift
  5 << 1  # Left Shift
  8 & 5   # Bitwise AND
  9 | 4   # Bitwise OR
  12 ^ 42 # Bitwise XOR
  ~88     # Bitwise NOT

# classes
  """
  The first argument __init__() gets is used to refer to the instance object
  by convention, that argument is called self
  if you add additional arguments in the body of __init__(), 
  you need to give each instance those attributes
  self is only passed as an argument when defining methods, but are left out when calling them
  """
  # myClass inherits object class
  class MyClass(object):
    # class attributes or "member variables", information that belongs to the class object
    anAttribute = defaultVal  # Note: must be referenced later via self.anAttribute

      # constructor with instance attributes
      def __init__(self, attr1, attr2, attr3):
          self.attr1 = attr1
          self.attr2 = attr2
          self.attr3 = attr3

      # methods (need to pass in self)
      def aMethod(self):
          return doSum

  class MyOtherClass(MyClass):
    # new constructor
    def __init__(self, attr1, attr2, attr3, attr4):
      super(MyOtherClass, self).__init__(attr1, attr2, attr3) # super method (don't have to include self)
      self.attr4 = attr4

    # overide aMethod from MyClass
    def aMethod(self):
          return doSum2

      def oldMethod(self):
        return super(MyOtherClass, self).aMethod()  # super method. Note the return statement


  classy = MyClass(attr1, attr2, attr3) # instantiating myClass

  # class representation method. by providing a return value in this method, we can tell Python how to represent an object of our class (for instance, when using a print statement)
  __repr__(self)  
    return "(%d, %d, %d)" % (self.x, self.y, self.z)

# I/O
  """
    r: read
    w: write
    r+: read and write
  """
  aFile = open("output.txt", "w")
  aFile.write("something" + "\n") # write a line
  aFile.read()          # read entire file
  aFile.readline()        # read a line (progressive after each call)
  aFille.close()
  aFile.closed == True      # test if a file is closed
  
  for line in aFile:
    
  """
  Automatically closing our files:
    file objects contain a special pair of built-in methods: __enter__() and __exit__()
    When a file object's __exit__() method is invoked, it automatically closes the file
    With 'with' and 'as' clause invokes thse methods
  """
  with open("text.txt", "w") as fileName:
    fileName.write("Success!")

  """
  Buffers:
    During the I/O process, data is buffered
    this means that it is held in a temporary location before being written to the file.
    Python doesn't flush the buffer—that is, write data to the file—until it's sure you're done writing
    One way to do this is to close the file
    If you write to a file without closing, the data won't make it to the target file.
  """

# Misc
  len(anObject) # returns length attribute of the object
  pass      # placeholder for expressions

# NLTK
  s = '''' Good muffins cost $3.88\nin New York.  Please buy me
    ... two of them.\n\nThanks. '''
  [word_tokenize(t) for t in sent_tokenize(s)]
  """
  returns: 
      [['Good', 'muffins', 'cost', '$', '3.88', 'in', 'New', 'York', '.'],
      ['Please', 'buy', 'me', 'two', 'of', 'them', '.'], ['Thanks', '.']]
  """

# commandline
python code.py          # interpets python code
python -m http.server 8080    # runs python localhost:8080