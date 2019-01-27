# Scala Cheatsheet

This is a work in progress...

## General
### Compilation and execution
```sh
scalac program.scala # compile
scala program        # run
```

### Types
Variables are denoted by `var` while immutables (constants) are denoted by `val`

Declaration of variable with explicit type:
```scala
var i: Int = 0
```

#### Casting
```scala
ans.asInstanceOf[Option[A]]
```

### Script mode
```scala
object HelloWorld {
   def main(args: Array[String]) {
      println("Hello, world!") // prints Hello World
   }
}
```
## Loops
### for-loop
Looping using `to` and `until`
```scala
var i = 0
for (i <- 1 to 10) {
   // Iterates through i = 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
}

for (i <- 1 until 10) {
   // Iterates through i = 1, 2, 3, 4, 5, 6, 7, 8, 9
}
```

Looping through a collection
```scala
for (var x <- xs ){
   // ...
}
```
### While-loop
```scala
while (condition) {
   // ...
}
```
## Collections
See [performance](https://docs.scala-lang.org/overviews/collections/performance-characteristics.html)

### Tuple
Instantiation
```scala
// val t = new Tuple3(1, "hello", Console)
val t = (1, "hello", Console) // syntatic sugar
```

Accessing
```scala
t._1 //=> 1
t._2 //=> "hello"
t._3 //=> Console
```

### List
#### Declaration
```scala
var lst = List(1, 2, 3)
var lst = List[Int](1, 2, 3)  // with explicit type
val emptyList = List()        // the empty list
```
#### Overview
```scala
val lst = 1 :: (2 :: (3 :: Nil))
lst.head    //=> 1
lst.tail    //=> (2 :: (3 :: Nil))
lst.length  //=> 3 | O(N)
lst.isEmpty //=> false

// Prepend
0 :: lst    //=> List(0, 1, 2, 3) | O(1)
0 +: lst    //=> List(0, 1, 2, 3) | O(1)

// Append
lst :+ 4    //=> List(1, 2, 3, 4) | O(N)

// Concat
val lst1 = List(1, 2, 3)
val lst2 = List(4, 5)
lst1 ::: lst2 // (preferred over ++)
lst1 ++ lst2
List.concat(lst1, lst2)

// Empty List.
val empty = Nil

// Two dimensional list
val dim = (1 :: (0 :: (0 :: Nil))) ::
          (0 :: (1 :: (0 :: Nil))) ::
          (0 :: (0 :: (1 :: Nil))) :: Nil
```

## Operators
Ternary
```scala
val a = if (i == 1) x else y
```

## Functions
```scala
# Name function
def isEven (x: Int): Boolean = {
  x % 2 == 0
}

# Anonymous function
(x: Int)  => x % 2 == 0
```
