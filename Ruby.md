# Ruby Cheatsheet

## General
* No semicolon termination
* Loosely typed
* Everything in Ruby is an object, there are no primitives

## Comments
```rb
# A single line comment
=begin
  A multi-
  line comment
=end
```

## I/O
```rb
puts "haha"   # prints "haha" then a new line afterwards
p foo         # puts foo.inspect
print "haha"  # prints "haha" on the current line
gets          # gets input from the user (Ruby automatically adds a newline after each input)
gets.chomp    # removes that extra line
```

## Strings
```rb
String.new("foo")         # instantiation via String constructor
.lines.to_a               # tokenize by newline
.upcase
.downcase
.capitalize
.chomp                    # remove trailing newlines
.include?"substr"         # if string contains substring 'substr'   
.gsub(/s/, "th")          # global substitution, replaces all 's' with 'th'
"Your name is #{first_name} #{last_name}"
str['<old>'] = '<new>'    # replaces <old> substrings with <new> substring
"hello".delete "l","lo"   #=> "heo"
("a".."z").to_a           # creates array of ['a','b','c',..,'z']
['a','b','c'].join        # creates 'abc'
a,b = "a,b,c".split(',')  # a = 'a', b = 'b'
```

## Symbols
Symbols are immutable string objects, they differ from strings in that same symbols share the same reference
```rb
my_symbol = :symbol
my_symbol = :'symbol with spaces'
"symbol".to_sym #=> :symbol
"symbol".intern #=> :symbol
:symbol.to_s    #=> "symbol"
(:a..:z).to_a   #=> [:a,:b,:c,...,:z]
```

## Selectors
```rb
if cond
elsif cond
else
end

unless a # equivalent to: if !a
end
```

### Shorthands
```rb
do_something if condition     # no need to `end`
do_something unless condition # no need to `end`
(condition)? if_true: if_false
```

### Switch statements
#### Form 1
```rb
case test
when 'this'
  doThis
when 'that'
  doThat
else
  doDefault
end
```
#### Form 2
```rb
case language
when 'this' then doThis
when 'that' then doThat
else doDefault
end
```

## Loops & iterators
```rb
until i == 6    # equivalent to: while i != 6
end

for num in 1...10   # For the variable num in the range 1 to 10 (exclusive)
end

for num in 1..10  # include 10
end

i = 0
loop{       # iterators
  i += 1
  next if 1%2 == 0  # continue
  # doSum
  break if i > 5  # break
}

# times
num.times{        # iterates num times
  dosum
}
num.times do      # iterates num times
  dosum
end

95.upto(100){ |num|
  puts num    # prints 95,96,97,98,99,100
}
'P'.downto('L'){ |letter| 
  puts letter   # prints 'P' to 'L'
}
```
## Arrays
### Generation
```rb
[*1..10]      # splat: creates [1,2,3,4,5,6,7,8,9,10]
(1..10).to_a  # creates an array with numbers from 1 to 10
Array(1..10)  # same as above
%w[a b c]     # creates ["a", "b", "c"]
numbers_array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
strings_array = numbers_array.map(&:to_s)
```
### Common operations
```
[1,2,3].max #=> 3

arr = [1,2,3,4,5]
arr.first n       # returns an array of the first n elements
arr.push(obj)     # appends obj
arr << obj        # same as push
arr.reverse       # reverses the array
arr.compact       # removes nil values in array
```
#### Itereate
```rb
arr.each{ |item|           # iterates each element in array
  # do something
}
```
#### Sort
```rb
arr.sort!                  # in-place sorting (no need to store sorted array as new variable)
arr.sort! { |left, right|  # sorts in-place descending
  right <=> left
}
```
#### Collect
Takes a block and applies the expression in the block to every element in an array. Does the same as `map`
```rb
my_nums.collect { |num|   # returns a new array and keep the old one unchanged
  # do something
}
my_nums.collect! { |num|  # in-place version of above
  # do something
}
```
## Hash
### Declaration and initialisation
Method 1
```rb
# Initialize with default value of each key set as `def_val` (optional)
hash = Hash.new(def_val)
```
Method 2:
```rb
hash = {}
```
Method 3:
```rb
# Using string variable key with hash rocket
hash = {
  key1 => value1,
  key2 => value2,
  key3 => value3
}

# Using sybmol with hash rocket
hash = {
  :symbol1 => value1,
  :symbol2 => value2,
  :symbol3 => value3
}

# Using symbol
hash = {
  symbol1: value1,
  symbol2: value2,
  symbol3: value3
}
```
### Common operations
#### Membership
```rb
hash["key"] = value # adding to hash
hash.delete(key)    # deletes an item
```
#### Iterate
```
hash.each{ |key|      
  # do something with key
  # Note: value = hash[key]
}

hash.each{ |key, val|
  # do something with key, val
}

hash.each_key{ |key|
  # do something with key
}
hash.each_value{ |value|
  # do something with value
}

hash.select { |name, grade| condition # select. Returns a hash
  # do something
}
```

#### Sort
Note that `sort_by` returns an array of `[key, val]` tuples
```rb
colors = hash.sort_by do |key, val| # sorts by value in ascending order
  val
end
```

## Methods
* Ruby's methods will return the result of the last evaluated expression by default
* Paranthesis are optional in function calls

### Definition and invocation
Method without arguments:
```rb
def method_without_args
  puts "Something"
end

method_without_args               # invoke method
```
Method with simple arguments:
```rb
def method_with_args(param1, param2)
  # do somthings
end

method_with_args(arg1, arg2)      # invoke method
```
Method with splat arguments (arguments preceded by a `*`):
```rb
def method_with_args(param1, *args_list)
  # do something
end

method_with_args(5, "hey", "you") # invoke method. args_list = ["hey", "you"]
```
### yield
* Placeholder for lambda functions
* Can be called multiple times

Yield without arguments:
```rb
# Definition
def method_with_yield
  # some code
  yield
  # some code
end

# Invocation
method_with_yield_1 {
  # this part runs in yield
} 
```
Yield with arguments:
```rb
# Definition
def method_with_yield(param1, param2)
  # some code
  yield(param1, param2)
  # some code
end

# Invocation
method_with_yield{ |arg1, arg2|
  # do something
  # another_method(arg1, arg2)
}
```
### Blocks
* Are anonymous functions
* Defined with either the keywords `do` and `end` or with curly braces `{}`
```rb
3.times do
  puts "I'm a code block!"
end

3.times ({ puts "As am I!" }) # parenthesis are optional
```
### Proc
* Saves function into variables
* Ignores unexpected arguments and assign `nil` to any that are missing
* Unlike blocks, procs are full-fledged objects, so they have all the powers and abilities of objects
* Unlike blocks, procs can be called over and over without rewriting them. This prevents you from having to retype the contents of your block every time you need to execute a particular bit of code
```rb
# Definition and assignment
my_function = Proc.new do |n|
  n * n
end

# Invocaton
my_function.call

[1,2,3].collect!(&my_function)  # function call: '&' is used to convert the cube proc into a block because only blocks or lambdas are accepted within the '()'
```
### Lambdas
* A lambda checks the number of arguments passed to it, while a proc does not. This means that a lambda will throw an error if you pass it the wrong number of arguments, whereas a proc will ignore unexpected arguments and assign nil to any that are missing
* When a lambda returns, it passes control back to the calling method; when a proc returns, it does so immediately, bypassing the calling method

```rb
def my_function(param)
  param.call
end

my_lambda = lambda { |param| block }  # for hahses use: lambda { |k,v| block }
my_function(my_lambda)
```

## Classes
* Ruby needs methods in order to access attributes unless `attr_reader`/`writer`/`accessor` is specified
```rb
class my_class
  attr_reader :an_attribute, :another_attribute   # can be read by object.an_attrtibute
  attr_writer :an_attribute   # can be written by object.an_attribute=
  attr_accessor :an_attribute # can be both written and read respectively by object.an_attrtibute and object.an_attribute=

  $global_variable = something # $: global scope. can be accessed anywhere in the code. Note: also be defined inside methods
  @@class_variable = something # class variable: belongs to the class and not the instance
  
  # Contsructor
  def initialize(name, creator)
    @name = name        # instance variable
    @creator = creator  # instance varaible
  end

  # Instance mthod
  def my_class_method(param)
    # do something
  end

  # Class method: only class methods can access class variables
  def my_class.class_method()
    puts @@class_variable
  end

  # Private method
  private # everything after the private keyword through the end of the class definition will now be private unless we say otherwise
  def private_method()
    # do something
  end

  # Public method (Methods are public by default in Ruby)
  public
  def public_method()
    # do something
  end

end
```
### Inheritance
* Ruby disallows multiple inheritance, instead, one may use mixins (like interfaces in Java)
```rb
class Child < Parent 
  # Overriding
  def my_class_method(param)
    super(param)  # super call (params are optional if not passing in any)
    # do something
end
```

## Modules
* Modules cannot contain variables
Acessing a module attribute:
```rb
pi = Math::PI
```
Creating a module:
```rd
module ModuleName
  SOME_CONSTANT = 314
end
```
Importing a module:
```
require 'ModuleName'  # when used outside a class
include ModuleName    # when used inside a class. When done so, if we `include Math` we can refer to `PI` instead of `Math::PI`
```
## Mixins
Include:
```rb
class MyClass
  include MyModule 
end

my_instance = MyClass.new()
my_instance.MyModule_method # instances of MyClass have access to all the methods in MyModule
```
Extend:
```rb
class MyClass
  extend MyModule 
end

MyClass.MyModule_method # MyClass have access to all the methods in MyModule
```

## Misc
```rb
Time.now        # returns current time
nil           # Along with false, nil is one of two non-true values in Ruby
!             # in-place operator
||=           # conditional assignment (will assign iff variable is nil)
<=>           # combined comparison operator. returns 0 if the left equals right, 1 if left greater than right, and -1 if left less than right
<<            # concatenation operator (appends right operand to left array or string)
::            # scope resolution operator
num.is_a? Type      # check type: Integer, Float, String, Symbol
float.floor       # rounds float to the nearest integer
.object_id        # get reference number
.to_s         # parses into string
.inspect      # parses into representational string. i.e. :string.inspect == ":string"
.to_i         # parses to integer
.to_a         # parses to array
num.next      # returns num + 1
nil.nil?      # only case where nil? returns true
.class        # returns class name
.class.superclass # returns superclass name

def one_line(); end   # Ruby doesn't require us to use any character to separate commands, unless we want to chain multiple statements together on a single line. In this case, a semicolon (;) is used as the separator.

# object.respond_to?(:method_name)
[1, 2, 3].respond_to?(:sort)  # returns true as arrays have 'method' sort
```

## I/O
```rb
Dir.entries "/"     # list out everything in the top directory as an array
Dir["/*.txt"]     # list all txt files in root directory
File.read("/comics.txt")  # read file
FileUtils.cp('/comics.txt', '/Home/comics.txt') # copy
File.mtime("/Home/comics.txt")  # last modified time
# line iterator
File.foreach(path) do |line|
  ...
end
# append
File.open("/Home/comics.txt", "a") do |f|
  f << "Cat and Girl: http://catandgirl.com/"
end
```
## Time object
```rb
.hour # reutrns hour for the time object
```
