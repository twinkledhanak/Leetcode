// Traversing a hashmap for all keys
for (String key : hashMap.keySet()) {
        System.out.println("Key: " + key + ", Value: " + hashMap.get(key));
}

// Traversing a hashmap for all values
for(Integer values: freqMap.values()){
    // all values
}


// Traversing both key and values together
for(Map.Entry<String,Integer> record : freqMap.entrySet()){
    record.getKey();
    record.getValue();
}

// quicker way of putting data
Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
          count.put(n, count.getOrDefault(n, 0) + 1);
        }


private Map<Integer, Integer> cache = new HashMap<>(Map.of(0, 0, 1, 1));
//https://www.geeksforgeeks.org/hashmap-computeifabsent-method-in-java-with-examples/
//https://www.geeksforgeeks.org/hashmap-getordefaultkey-defaultvalue-method-in-java-with-examples/ 

Map<Integer,List<Integer> adjMap = new HashMap<>();
    for(int[] edge: edges){
        adjMap.computeIfAbsent(edge[0], k-> new ArrayList()).add(edge[1]);
    }

for(int vertex: adjMap.getOrDefault(currentNode,Collections.emptyList())){}

//https://stackoverflow.com/questions/9255620/why-does-dijkstras-algorithm-use-decrease-key


// *************************************************************************************************************************


// pair class in Java
Pair<Integer, String> pair = new Pair<>(1, "One");
Integer key = pair.getKey();
String value = pair.getValue();

// Custom Pair class in java
public static class MyPair{
        int first, second;

        MyPair(int first, int second){
            this.first = first;
            this.second = second;
        }

        public int getFirstValue(){
            return this.first;
        }

        public int getSecondValue(){
            return this.second;
        }
    }

// *************************************************************************************************************************




// Initialize entire array to some default value
int[] dist = new int[V];
Arrays.fill(dist, Integer.MAX_VALUE);

// *************************************************************************************************************************

// Stacks and Queues
Queue<Integer> q = new ArrayQueue<>(); // or new LinkedList<>(); // @TODO - Check when to use these!!
Stack<Integer> s = new Stack<>(); // or Deque<Integer> stack = new ArrayDeque<>();
q.offer(startVertex); // push
q.peek(); // peek
q.poll(); // pop

// Monotonic stack
Deque<Integer> stack = new ArrayDeque<>();

// Stacks using LinkedLists, to be used by trees
LinkedList<TreeNode> stack = new LinkedList<>();
stack.pollLast();

// Circular queues
//In Java, a circular queue can be implemented using an array or a linked list.

enqueue() or offer() - Adds an element to the rear/tail of the circular queue.
dequeue() or poll() - Removes and returns the element at the front/head of the circular queue.
front() or peek() - Returns the element at the front/head of the circular queue without removing it.
isEmpty() - Checks if the circular queue is empty.
isFull() - Checks if the circular queue is full.
size() - Returns the number of elements currently in the circular queue.

// *************************************************************************************************************************

// Priority Queue
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(startVertex); // push, aligns with Queue's actual push, handles all capacity restrictions by itself
pq.peek(); // peek
pq.poll(); // pop

// direct min heap
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(stick); // used less frequently, similar behaviour as offer(). We will have to manually handle scenario when queue is full.
pq.remove();

// Max Heap
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        
// Create a priority queue, but put the entire map inside. Use Map.Entry
// Max heap
PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
        (a, b) -> // a and b are two consecutive elements in PriorityQueue
    a.getValue() - b.getValue() // THIS CREATES MIN HEAP , FOR MAX HEAP: b.value() - a.value()
);
// REFER to TopKFrequentElements.java


PriorityQueue<int[]> maxHeap;
// We create a min heap, using priority queue
// We have each element of PQ as an integer of two elements, [number,weight]
// We want to create min heap wrt to weight, instead of the number
// Modify the comparator to do so.
minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
// In this implementation, Comparator.comparingInt(a -> a[1]) is used to create a comparator that compares integer arrays based 
// on the second element of the array. This ensures that the PriorityQueue behaves as a min heap with respect to the weight assigned
// to each number.

// to do so for max heap
maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1])); // Negating the comparison for max heap

// *************************************************************************************************************************
// ArrayList
ArrayList<Integer> list = new ArrayList<>();
list.add(30);
list.remove(1); // first occurence

// ArrayList for Strings
class Solution {
  public String reverseWords(String s) {
    // remove leading spaces
    s = s.trim();
    // split by multiple spaces
    List<String> wordList = Arrays.asList(s.split("\\s+"));
    Collections.reverse(wordList);
    return String.join(" ", wordList);
  }
}

int[] LIS = new int[nums.length];
Arrays.fill(LIS, 1); // initialize every array element as 1

// *************************************************************************************************************************
// HashMap

 // 1. initialize a hash map
Map<Integer, Integer> hashmap = new HashMap<>();
// 2. insert a new (key, value) pair
hashmap.putIfAbsent(0, 0);
hashmap.putIfAbsent(2, 3);
// 3. insert a new (key, value) pair or update the value of existed key
hashmap.put(1, 1);
hashmap.put(1, 2);
// 4. get the value of specific key
System.out.println("The value of key 1 is: " + hashmap.get(1));
// 5. delete a key
hashmap.remove(2);
// 6. check if a key is in the hash map
if (!hashmap.containsKey(2)) {
    System.out.println("Key 2 is not in the hash map.");
}
// 7. get the size of the hash map
System.out.println("The size of hash map is: " + hashmap.size()); 
// 8. iterate the hash map
for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
    System.out.print("(" + entry.getKey() + "," + entry.getValue() + ") ");
}
System.out.println("are in the hash map.");
// 9. clear the hash map
hashmap.clear();
// 10. check if the hash map is empty
if (hashmap.isEmpty()) {
    System.out.println("hash map is empty now!");
}



// *************************************************************************************************************************

// HashSets

// 1. initialize the hash set
Set<Integer> hashSet = new HashSet<>();     
// 2. add a new key
hashSet.add(3);
hashSet.add(2);
hashSet.add(1);
// 3. remove the key
hashSet.remove(2);        
// 4. check if the key is in the hash set
if (!hashSet.contains(2)) {
    System.out.println("Key 2 is not in the hash set.");
}
// 5. get the size of the hash set
System.out.println("The size of has set is: " + hashSet.size());     
// 6. iterate the hash set
for (Integer i : hashSet) {
    System.out.print(i + " ");
}
System.out.println("are in the hash set.");
// 7. clear the hash set
hashSet.clear();
// 8. check if the hash set is empty
if (hashSet.isEmpty()) {
    System.out.println("hash set is empty now!");
}



// *************************************************************************************************************************

// Or just use this for regex
String regex = "[^a-zA-Z0-9]";
String regex = "\s+";
x = x.replace(regex,""); // for for single instance
x = x.replaceAll(regex,""); // OR x.replaceAll(regex," ") - reduce multiple spaces to single 

Character.isLetterOrDigit(s.charAt(0));