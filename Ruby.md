```rb
# a comment
=begin
  no semicolon termination
  loosely typed
  everything in Ruby is an object

=end

puts "haha"   # prints "haha" then a new line afterwards
p foo         # puts foo.inspect
print "haha"  # prints "haha" on the current line
gets      # gets input from the user (Ruby automatically adds a newline after each input)
gets.chomp    # removes that extra line

# strings
  String.new("foo") # instantiation via String constructor
  .lines.to_a       # tokenize by newline
  .upcase
  .downcase
  .capitalize
  .chomp        # remove trailing newlines
  .include?"substr" # if string contains substring 'substr'   
  .gsub(/s/, "th")  # global substitution, replaces all 's' with 'th'
  "Your name is #{first_name} #{last_name}"
  str['<old>'] = '<new>' # replaces <old> substrings with <new> substring
  "hello".delete "l","lo"        #=> "heo"
  ("a".."z").to_a   # creates array of ['a','b','c',..,'z']
  ['a','b','c'].join  # creates 'abc'
  a,b = "a,b,c".split(',') # a = 'a', b = 'b'

# selectors
  if cond
  elsif cond
  else
  end

  unless a # equivalent to: if !a
  end

  # shorthands
  do_something if condition   # no need to end
  do_something unless condition # no need to end
  (condition)? if_true: if_false

  # switch statements (form 1)
  case test
  when 'this'
    doThis
  when 'that'
    doThat
  else
    doDefault
  end

  # switch statements (form 2)
  case language
  when 'this' then doThis
  when 'that' then doThat
  else doDefault
  end

# loops & iterators
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

# arrays
  # creating numbered lists
  [*1..10]      # splat: creates [1,2,3,4,5,6,7,8,9,10]
  (1..10).to_a  # creates an array with numbers from 1 to 10
  Array(1..10)  # same as above
  [1,2,3].max == 3

  %w[a b c]     # creates ["a", "b", "c"]

  array = [1,2,3,4,5]
  .each{ |item|     # iterates each element in array
    dosum
  }
  array.first n                   # returns an array of the first n elements
  array.push(obj)                 # appends obj
  array << obj                  # same as push
  array.sort!                   # in place sorting (no need to store sorted array as new variable)
  array.sort! { |left, right| right <=> left }  # sorts inplace descending
  array.reverse                 # reverses the array
  array.compact                 # removes nil values in array
  # collect: takes a block and applies the expression in the block to every element in an array
  # 'collect' does the same as 'map'
  my_nums.collect { |num| dosum }         # returns a new array and keep the old one unchanged
  my_nums.collect! { |num| dosum }        # in-place

# hash
  hash = Hash.new(defVal) # instantiation method 1 with default value of each key set as defVal (optional)
  hash = {}       # instantiation method 2
  hash = {          # instantiation method 3
    key1 => value1,
    key2 => value2,
    key3 => value3
  }
  hash = {          # instantiation method 3
    :symbol1 => value1,
    :symbol2 => value2,
    :symbol3 => value3
  }
  hash = {          # instantiation method 3
    symbol1: value1,
    symbol2: value2,
    symbol3: value3
  }

  hash.delete(key)    # deletes an item

  hash["key"] = value   # adding to hash
  hash.each{ |i|      # iterates each value in hash
    hash[i] += 1
  }

  # iterating a hash
  hash.each{ |key, val|         # each
    doSum
  }
  hash.each_key{ |key|          # each key
    doSum
  }
  hash.each_value{ |value|        # each value
    doSum
  }
  hash.select { |name, grade| condition # select. Returns a hash
    doSum
  }

  # sorting a hash
  colors = hash.sort_by do |key, val| # sorts by value in ascending order, note that sort_by returns an array of [key, val] arrays
      val
  end

# symbols are immutable string objects, they differ from string primitives in that same symbols share the same reference
  my_symbol = :symbol
  my_symbol = :'symbol with spaces'
  "symbol".to_sym == :symbol
  "symbol".intern == :symbol
  :symbol.to_s == "symbol"
  (:a..:z).to_a   # [:a,:b,:c,...,:z]

# method
  # Note: Ruby's methods will return the result of the last evaluated expression by default
  # paranthesis are optional in function calls

  # types of parameters
    param       # a trivial parameter
    defParam = 1  # parameter with default value 1 unless specified
    *paramList    # splat arguments: arguments preceded by a *, representing multiple parameters

  def method_with_no_parameters
    puts "Something"
  end
  method_with_no_parameters # call method

  def method_with_parameters(param, *paramList)
    doSum
  end
  method_with_parameters(5, "hey", "you") # call method. paramList = ["hey", "you"]

  # yield
    # placeholder for lambda functions
    # can be called multiple times
    
    # no yield paramters
    def method_with_yield_1
      some_code
      yield
      some_code
    end
    method_with_yield_1 { doSum } # doSum would run in yield
    
    # with yield parameters
    def method_with_yield_2(name)
      some_code
      yield(name)
      some_code
    end
    method_with_yield_1{ |paramter| doSum} # doSum would run in yield with 'name' as parameter

  # blocks (anonymous functions) defined with either the keywords 'do' and 'end' or with curly braces '{}'.
    1.times do
      puts "I'm a code block!"
    end

    1.times ({ puts "As am I!" }) # parenthesis are optional

  # proc: saves function into variables
    # Procs are full-fledged objects, so they have all the powers and abilities of objects. (Blocks do not.)
    # Unlike blocks, procs can be called over and over without rewriting them. This prevents you from having to retype the contents of your block every time you need to execute a particular bit of code.
    my_function = Proc.new do |n|
      n * n
    end
    my_function.call
    [1,2,3].collect!(&my_function)  # function call: '&' is used to convert the cube proc into a block because only blocks or lambdas are accepted within the '()'

    # advanced usage
    numbers_array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    strings_array = numbers_array.map(&:to_s)

  # lambdas
    # a lambda checks the number of arguments passed to it, while a proc does not. This means that a lambda will throw an error if you pass it the wrong number of arguments, whereas a proc will ignore unexpected arguments and assign nil to any that are missing.
    # when a lambda returns, it passes control back to the calling method; when a proc returns, it does so immediately, bypassing the calling method
    def my_function(param)
      param.call
    end
    my_lambda = lambda { |param| block }  # for hahses use: lambda { |k,v| block }
    my_function(my_lambda)

# classes
  # Ruby needs methods in order to access attributes unless attr_reader/writer/accessor is specified

  class my_class
    attr_reader :an_attribute, :another_attribute   # can be read by object.an_attrtibute
      attr_writer :an_attribute   # can be written by object.an_attribute=
      attr_accessor :an_attribute # can be both written and read respectively by object.an_attrtibute and object.an_attribute=

    $global_variable = something # $: global scope. can be accessed anywhere in the code. Note: also be defined inside methods
      @@class_variable = something # class variable: belongs to the class and not the instance
    # contsructor
    def initialize(name, creator)
      @name = name    # instance variable
      @creator = creator  # instance varaible
    end
      
    def my_class_method(param)
      # doSum
    end

    # a class method: only class methods can access class variables
    def my_class.class_method()
      puts @@class_variable
    end

    # a private method
    private # everything after the private keyword through the end of the class definition will now be private unless we say otherwise
    def private_method()
      # doSum
    end

    # a public method (Methods are public by default in Ruby)
    public
    def public_method()
      # doSum
    end

  end

  # inheritance
  # multiple inheritance is not allowed in Ruby, instead, one may use mixins (like interfaces in Java)
  class Child < Parent 
    # overriding
    def my_class_method(param)
      super(param)  # super call (params are optional if not passing in any)
      # doSum
  end

# modules
  # Note: modules cannot contain variables
  
  pi = Math::PI

  module ModuleName
      SOME_CONSTANT = 914
  end

  require 'ModuleName'  # when used outside a class
  include ModuleName    # when used inside a class. When done so, if we include math we can refer to PI instead of Math::PI

  # Mixins
  class MyClass
    include MyModule # instances of MyClass have access to all the methods in MyModule
  end
  my_instance = MyClass.new()
  my_instance.MyModule_method #  and be called as if it were its own

  class MyClass
    extend MyModule # MyClass have access to all the methods in MyModule
  end
  MyClass.MyModule_method

# misc
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
  num.next        # returns num + 1
  nil.nil?      # only case where nil? returns true
  .class        # returns class name
  .class.superclass # returns superclass name
  
  def one_line(); end   # Ruby doesn't require us to use any character to separate commands, unless we want to chain multiple statements together on a single line. In this case, a semicolon (;) is used as the separator.

  # object.respond_to?(:method_name)
  [1, 2, 3].respond_to?(:sort)  # returns true as arrays have 'method' sort

# I/O
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

# time object
  .hour # reutrns hour for the time object
```