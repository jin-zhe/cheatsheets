# JavaScript Cheatsheet

## Variables
```js
The var keyword creates a new variable in the current scope. That means if var is used outside a function, that variable has a global scope. If var is used inside a function, that variable has a local scope.
```

## I/O
```js
isAck = confirm("You are now leaving the site")
name = prompt("What's your name?", "placeholder text")
console.log()
```

## Switch
```js
switch(lunch){
  case 'sandwich':
    console.log("Sure thing! One sandwich, coming up.");
    break;
  case 'soup':
    console.log("Got it! Tomato's my favorite.");
    break;
  case 'salad':
    console.log("Sounds good! How about a caesar salad?");
    break;
  case 'pie':
    console.log("Pie's not a meal!");
    break;
  default:
    console.log("Huh! I'm not sure what " + lunch + " is. How does a sandwich sound?");
}
```

## Math
```js
Math.random() * i // random float from 0 to i
Math.floor()
```

## isNan
Be careful: if you call `isNaN` on a string that looks like a number, like '42', JavaScript will try to help by automatically converting the string '42' to the number 42 and return false (since 42 is a number).
```js
isNaN('berry');   //=> true
isNaN(NaN);       //=> true
isNaN(undefined); //=> true
isNaN(42);        //=> false
```

## typeof
```js
typeof someObject // returns "number", "string", "function", "object"
```

## Strings
```js
/*jshint multistr:true */
var text = "Hey, how are you \
doing? My name is Emily.";
(2.333333).toFixed(2) == '2.33';
"string".length == 6
"some word".substring(x, y) // if single paramter, will get from starting position till end of string
"string".toUpperCase();
```

## Arrays
```js
var mix = [42, true, "towel"]; // heterogeneous array: a mixture of data types
[1,2,3].length == 3 
var arrayName = [data, data, data];
array.push(item)
```

## Loops
```js
for (var counter = 1; counter < 6; counter++) {
  // do something
}
```

## Functions
```js
var myFunc = function (param){
   // do something
};
function myfunc (param){
  // do something
};
```

## Objects
```js
var obj = {}  // literal notation
var obj = new Object(); // constructor notation
obj.attr1 = true
obj.attr1     // dot notation
obj['attr1']  // bracket notation. Note string can be replaced by a variable. i.e. key='attr1'; obj[key];
obj.myFunc = function(param){
  console.log(this.attr1); // doSum. This refers to whichever object that calls the function
};

obj.hasOwnProperty('name'); // boolean: checks if obj has the property 'name'
```
### Constructors
```js
function Person(name, age) {
  this.name = name;           // public property
  this.age = age;             // public property
  this.myFunc = function (){  // public function
    //doSum
  };
  var gender = 'male';        // private property (can be accessed by public methods)
}

```
Instantiation:
```js
var bill = new Person("Bill Gates", 60);
```
### Inheritance
```js
function Animal(name, numLegs) {
  this.name = name;
  this.numLegs = numLegs;
  this.isAlive = true;
}
function Penguin(name) {
  this.name = name;
  this.numLegs = 2;
}
```

### Iterating
```js
for(var key in obj) {
  // do something with key
}
```

## Prototypes
Adds function to a class
```js
Person.prototype.myFunc = function(){ 
  // do something
};
Penguin.prototype = new Animal();
function Emperor(name) {
  this.name = name;
  this.saying = "Waddle waddle";
}
Emperor.prototype = new Penguin();
```
