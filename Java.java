/* Bit Manipulation */
   int complement = ~0; // 32 '1's
   << len               // left shift: pads right by len number of '0's
   >> len               // right shift: pads left by len number of '0's
   >>>                  // right shift: ignores sign extension and pads '0' on the left
   num & mask           // AND operation
   num | mask           // OR operation
   num ^ mask           // XOR operation

/* Integer */
  Integer.parseInt("123")
  Integer.toBinaryString(number)
  Integer.MAX_VALUE
  Integer.MIN_VALUE

/* Math */
  Math.max(one, two);
  Math.min(one ,two);
  Math.pow(one, two); // one^two
  Math.sqrt(num);
  Math.floor(aFloat);
  Math.abs(obj.hashCode()); // integer representation of hashCode()

/* Strings */
  int length = String.length();
  String.trim()                     // remove leading and trailing whitespaces
  String.replaceAll("\\s+", " ");   // remove multiple sequential whitespaces
  Integer.toString(10, 2);          // parse int to bin string: convert 10 to "1010"
  StringBuffer                      // append(), reverse(), length(), substring(), charAt(), deleteCharAt(), delete(start, end_exclusive)

/* Characters */
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

/* Comparators */
  Comparator myComparator = new Comparator<Integer>(){
      public int compare(Integer o1, Integer o2){
          return o2 - o1; // biggest to smallest (smallest to biggest is o1 - o2)
      }
  }

  /* Sorts using custom comparison function */
  Collections.sort(list, new Comparator() {
    public int compare(Object a, Object b) {
      return ( new Integer(((MyClass) a).getNumber()) ).compareTo( new Integer(((MyClass) b).getNumber()));
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
  HashMap<Key_Class> set; // add(item), remove(object), contains(item), size()