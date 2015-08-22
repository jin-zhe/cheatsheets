/* Bit Manipulation */
   int complement = ~0; // 32 '1's
   << len               // left shift: pads right by len number of '0's
   >> len               // right shift: pads left by len number of '0's
   >>>                  // right shift: ignores sign extension and pads '0' on the left
   num & mask           // AND operation
   num | mask           // OR operation
   num ^ mask           // XOR operation
   /* Note the usual arithmetic shorthands also apply. i.e. &=, |=, ^= */
   (~(450)+1) == -450   // take complement then add 1 to toggle between positive and negative

/* Byte manipulation */
  /* Note: Bytes in Java are signed by default*/
  int unsignedVal = b & 0xFF;

/* Integer */
  Integer.parseInt("123")
  Integer.toBinaryString(number)
  Integer.MAX_VALUE
  Integer.MIN_VALUE

/* Math */
  Math.max(one, two);
  Math.min(one, two);
  Math.pow(one, two); // one^two
  Math.sqrt(num);
  Math.floor(aFloat);
  Math.abs(obj.hashCode()); // integer representation of hashCode()

/* Strings */
  int length = String.length();
  .trim()                             // remove leading and trailing whitespaces
  .replaceAll("\\s+", " ");           // remove multiple sequential whitespaces
  Integer.toString(10, 2);            // parse int to bin string: convert 10 to "1010"
  StringBuffer                        // append(), reverse(), length(), substring(), charAt(), deleteCharAt(), delete(start, end_exclusive)
  char[] charArr = str.toCharArray(); // convert string to char array
  String str = new String(charArr);   // convert char array to string
  toLowerCase();
  toUpperCase();

/* Characters */
  /* Note: characters in Java are UTF-16 encoded so they each occupy 2 bytes in memory */
  char two = '0' + 2;                     // parse int to char: convert 2 to '2'
  char two = Character.forDigit(2, 10);   // same as above
  int ans = '2' - '0';                    // parse char to int: convert '2' to 2

/* Random */
  Random gen = new Random();
  gen.nextInt(x); // returns random number between 0 and x exclusive

/* Arrays */
  int length = array.length
  subarray = Arrays.copyOfRange(arr, start, end_exclusive); // only after 1.6
  System.arraycopy(src_arr, src_start, dest_arr, dest_start, copy_length);  // makes copy of array
  Arrays.sort(arr);     // sorts array in-place
  Arrays.toString(arr); // e.g. [1,2,3] => "1, 2, 3"
  Arrays.fill(arr, deafault_val); // initializes all cells with the default value given

/* Iterators */
  ArrayList<Integer> al = ...
  Iterator<Integer> itr = al.iterator();
  while(itr.hasNext()) {
    Integer curr = itr.next();
    // do something with curr
  }

/* Comparators: classes for comparison between objects. see http://www.mkyong.com/java/java-object-sorting-example-comparable-and-comparator/ */
  /* using anonymous classes */
    Comparator<Integer> myComparator = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2){
            return o2 - o1; // biggest to smallest (smallest to biggest is o1 - o2)
            // return o1.compareTo(o2); // using the class' natural comparator and in ascending order
        }
    };

  /* using actual classes */
    class ColorComparator implements Comparator<CarSort> {
       public int compare(CarSort c1, CarSort c2) {
           return c1.getColor().compareTo(c2.getColor());
       }
    }

/* Comparable */
  Class MyClass implements Comparable<MyClass> {
    int value;
    ...
    public int compareTo(MyClass something) {
      return this.value - something.value;  // ascending order
    }
  }

/* collections */
  /* Sorts collection using custom comparison class */
    Collections.sort(list, new Comparator<Integer>(){
        public int compare(Integer o1, Integer o2){
            return o1 - o2;             // ascending (descending is o2 - o1)
            // return o1.compareTo(o2); // using the class' natural comparator and in ascending order
        }
    });

/* Data Structures */
  TreeMap<K,V> BST = new TreeMap<K,V>(new Comparator);  // BST: put(key, value), get(key), size(), isEmpty()
  PriorityQueue<Integer> PQ= new PriorityQueue<Integer>(initial_capacity, myComparator);  // PQ: peek(), poll(), offer(item), size(), isEmpty()
  LinkedList<Object> list = new LinkedList<Object>();	  // Queue: peek(), poll(), offer(item), isEmpty()
  Stack<Object> stack = new Stack<Object>(); 			      // Stack: peek(), pop(), push(item), empty()

  public static class Pair<X,Y>{
    X one;
    Y two;
    public Pair(X one, Y two){
      this.one = one;
      this.two = two;
    }
  }

/* Hashmaps */
  HashMap<Key_Class, Value_Class> map;  // put(key, value), get(), size(), containsKey(key)
  map.getOrDefault(key, 0)              // Hashmap default values. Note can return null if key exists and its value is null
  for (HashMap.Entry<Key_Class, Value_Class> entry: charMap.entrySet()) // iterate through a hashmap

/* Hashset */
  HashMap<Key_Class> set;             // add(item), remove(object), contains(item), size()
  boolean b = setA.containsAll(setB); // check if setB is a susetB of setA
  setA.addAll(setB);                  // union - transform in-place setA into the union of setA and setB
  setA.retainAll(setB);               // intersection - transforms in-place setA into the intersection of setA and setB
  setA.removeAll(setB);               // difference - transforms in-place setA into the (asymmetric) set difference of setA and setB.

/* Generics */
  /* Wildcard */
    public void printArrayList(ArrayList<?> list) {
      Iterator<?> itr = list.iterator();
      while(itr.hasNext()) {
        System.out.print(itr.next() + " ");
      }
      System.out.println();
    }

/* Anonymous classes */
  HelloWorld frenchGreeting = new HelloWorld() {
    String name = "tout le monde";
    public void greet() {
        greetSomeone("tout le monde");
    }
    public void greetSomeone(String someone) {
        name = someone;
        System.out.println("Salut " + name);
    }
  };

/* Exceptions */
  /* Exception heirarchy:
   *        [Throwable]
   *        /         \
   * [Error]          [Exception]
   *                  /         \
   *     [IOException]          [RuntimeException]
   */
  
  /* Userful throwable methods */
    getMessage();                 // Returns a detailed message about the exception that has occurred. This message is initialized in the Throwable constructor.
    Throwable cause = getCause(); // Returns the cause of the exception as represented by a Throwable object.
    toString();                   // Returns the name of the class concatenated with the result of getMessage()
    printStackTrace();            // Prints the result of toString() along with the stack trace to System.err, the error output stream

  /* Try/Catch block */
    try {
      //Protected code
    }
    catch(ExceptionType1 e1) {
      //Catch block
    }
    catch(ExceptionType2 e2) {
      //Catch block
    }
    catch(ExceptionType3 e3) {
      //Catch block
    }
    finally {
      //(optional)The finally block always executes, whether or not an exception has occurred
    }

  /* throws/throw */
    public class className {
      public void deposit(double amount) throws RemoteException {
        // Method implementation
        if (condition) {
          throw new RemoteException();
        }
      }
       // Remainder of class definition
    }

  /* user-defined exception classes */
    public class InsufficientFundsException extends Exception {
      private double amount;
      public InsufficientFundsException(double amount) {
        this.amount = amount;
      } 
      public double getAmount() {
        return amount;
      }
    }

/* Enum (taken from: https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html) */
  /* without contructor */
    public enum Day {
      SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
      THURSDAY, FRIDAY, SATURDAY 
    }

  /* with constructor */
  public enum Planet {
    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);

    private final double mass;   // in kilograms
    private final double radius; // in meters
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    private double mass() { return mass; }
    private double radius() { return radius; }

    // universal gravitational constant  (m3 kg-1 s-2)
    public static final double G = 6.67300E-11;

    double surfaceGravity() {
        return G * mass / (radius * radius);
    }
    double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Planet <earth_weight>");
            System.exit(-1);
        }
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight/EARTH.surfaceGravity();
        for (Planet p : Planet.values())
           System.out.printf("Your weight on %s is %f%n",
                             p, p.surfaceWeight(mass));
    }
  }
