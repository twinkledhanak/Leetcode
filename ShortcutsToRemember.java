//EXISTENTIAL CRISIS THINGS !!!!@#$%^&*()(*&^%$#@#$%^&*&^%$#@#$%^&^%$#)

// WHEN DEALING WITH DIVISION IN JAVA
// JAVA ALWAYS DOES INTEGER DIVISION
// profit = {7};
// weight = {2};
// profit[i]/weight[i] -> 3.0
// (double)(profit[i]/weight[i]) -> 3.0
// (double)(profit[i])/weight[i] -> 3.5 -> One of the operands must be typecast to double
// Math.ceil((double) a / b) is used when we want to convert 5.854323456 to 6

// (byte)(n%2) WORKS, but, (byte) n%2 will give error :/

// Note that we must use ! .equals instead of !=
// because we are comparing Integer, not int.
// Integer is a reference object. It is an address that holds reference to a int value
if (!vals.get(front).equals(vals.get(back))) {
    return false;
}

/**
Integer occupies 16 bytes, int occupies 4 bytes. So int is more preferred and doesnt hog memory.
But, if pure OOP is needed, wrapper class Integer is used.
*/

// Traversing a hashmap for all keys
// It is like extracting all keys of a given hashmap into an array
for (String key : hashMap.keySet()) {
        System.out.println("Key: " + key + ", Value: " + hashMap.get(key));
        // Or even better - hashMap.getOrDefault()
}

// Traversing a hashmap for all values
// It is like extracting all values of a hashmap into an array
for(Integer values: freqMap.values()){
    // all values
}


// Traversing both key and values together
for(Map.Entry<String,Integer> record : freqMap.entrySet()){
    record.getKey();
    record.getValue();
}

// To find the minimum of all values in a hashmap
Map<Integer, Integer> adjMap = new HashMap<>();
for (int user : userEvent) {
    adjMap.put(user, adjMap.getOrDefault(user, 0) + 1);
}

// Find the minimum frequency in the entire array
// hashmap.values() gives an array
// So we can do all types of array operations on it using Collections library
int minFreq = Collections.min(adjMap.values());
// ** Complexity of using .min() is O(n) as we internal traverse through entire array

//////////////////////////////////////////////////////////////////////////////

// quicker way of putting data
Map<Integer, Integer> count = new HashMap();
for (int n: nums) {
    count.put(n, count.getOrDefault(n, 0) + 1);
}


private Map<Integer, Integer> cache = new HashMap<>(Map.of(0, 0, 1, 1));
//https://www.geeksforgeeks.org/hashmap-computeifabsent-method-in-java-with-examples/
//https://www.geeksforgeeks.org/hashmap-getordefaultkey-defaultvalue-method-in-java-with-examples/ 

// In getOrDefault(..)

Map<String, String> hm = new HashMap<>();
        hm.put("Geek", null);

        // Key "Geek" exists but its value is null, 
        // so null is returned
        String s1 = hm.getOrDefault("Geek", "default");
        System.out.println("Value for 'Geek': " + s1);

        // Key "Geek2" does not exist, so 
        // the default value is returned
        String s2 = hm.getOrDefault("Geek2", "default");
        System.out.println("Value for 'Geek2': " + s2);

/*
If remapping function returns null for a key, then no mapping is recorded for that key.
At time of computation if remapping function throws an exception, the exception is rethrown, and the no mapping is recorded.
This method will throw a ConcurrentModificationException if the remapping function modified this map during computation.
*/

Map<Integer,List<Integer> adjMap = new HashMap<>();
    for(int[] edge: edges){
        adjMap.computeIfAbsent(edge[0], k-> new ArrayList()).add(edge[1]);
    }

for(int vertex: adjMap.getOrDefault(currentNode,Collections.emptyList())){}
for(int vertex: adjMap.getOrDefault(currentNode,new ArrayList<>())){} // this should work too

//https://stackoverflow.com/questions/9255620/why-does-dijkstras-algorithm-use-decrease-key

adjMap.computeIfAbsent(a, k -> new ArrayList<>());
adjMap.get(a).add(b);

// *************************************************************************************************************************


// pair class in Java
// javafx.util.Pair class came into existance on or after java 7.
// Refer to Sum_Root_to_Leaf.java for this same Pair
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

        // Below two methods are not needed
        public int getFirstValue(){
            return this.first;
        }

        public int getSecondValue(){
            return this.second;
        }
    }

// *******************************************

static class Node {
			int dest;
			int weight;

			Node(int dest, int weight) {
				this.dest = dest;
				this.weight = weight;
			}
}
PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);// Sort in increasing order -> a-b
// To sort in decreasing order -> b-a

// *******************************************

class Edge { 
		int src, dest, weight; 

		public Edge(int src, int dest, int weight) 
		{ 
			this.src = src; 
			this.dest = dest; 
			this.weight = weight; 
		} 
	}

// Sorting an array that has multiple 
List<Edge> graphEdges = new ArrayList<Edge>( 
			List.of(new Edge(0, 1, 10), new Edge(0, 2, 6), 
					new Edge(0, 3, 5), new Edge(1, 3, 15), 
					new Edge(2, 3, 4))); 

		// Sort the edges in non-decreasing order 
		// (increasing with repetition allowed) 
		graphEdges.sort(new Comparator<Edge>() { // Custom Comparator
			@Override public int compare(Edge o1, Edge o2) 
			{ 
				return o1.weight - o2.weight; // Increasing order -> a-b
                // For decreasing, b-a, o2.weight - o1.weight
			} 
		}); 


// In Java, Arrays.sort() is implemented using a variant of the Quick Sort algorithm which has a space complexity of O(logn)
// To Sort Array
/**
1. Arrays.sort(nums); // ascending 
2. Arrays.sort(nums); // ascending and then return nums[nums.length - k] - for kth element from the end
3. Arrays.sort(nums, Collections.reverseOrder()); // descending
4. We can have our won comparator, if we have a different object and not just self integer
*/

// To sort List
/**
1. Collections.sort(someList); // ascending
2. Collections.sort(someList, Collections.reverseOrder()); // descending
3. someList.sort(...); // refer prev code for comparator
4. Collections.sort(someList, new Sortbyroll());

// Consensus::
// Collections.reverseOrder() can be used for sorting in decreasing order + creation of Max Heap


class Sortbyroll implements Comparator<Student> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Student a, Student b) 
    { 
        return a.rollno - b.rollno; 
    } 
}

Comparator.reverseOrder() and Collections.reverseOrder() work the same

How do we sort a String -
public String sort(String s) {
        char[] t = s.toCharArray();
        Arrays.sort(t);
        return new String(t);
    }

*/

// *************************************************************************************************************************




// Initialize entire array to some default value
int[] dist = new int[V];
Arrays.fill(dist, Integer.MAX_VALUE);

// *************************************************************************************************************************
ALL POSSIBILITIES FOR STACKS AND QUEUES :

Red-Black trees are used to implement these queues (esp. Priority queues)
Rest use LinkedLists

Stack<Integer> stack = new Stack<>();
Stack<Integer> stack = new LinkedList<>(); // poll() works here

**LinkedList<Integer> stack = new LinkedList<>(); // Only pollLast() works, since it is a list
Deque<Integer> stack = new ArrayDeque<>(); // push(); pop() for the stack implementation

Queue<Integer> queue = new LinkedList<>();
Deque<Integer> queue = new ArrayDeque<>();

PriorityQueue<Integer> pq = new PriorityQueue<>();
**We can use LinkedList<Integer> priorityQueue = new LinkedList<>();
// Any LinkedList can be modified to perform as a priority queue
// *************************************************************************************************************************

// Stacks and Queues
// There is no class called ArrayQueue, change below!!!! Queue is an interface, create obj: new PriorityQueue/LinkedList/ArrayDeque
// XXXXX WRONG : Queue<Integer> q = new ArrayQueue<>(); // or new LinkedList<>(); // @TODO - Check when to use these!!
Queue<Integer> q = new LinkedList<>(); // for LL or PQ, the method names remain same
q.offer(startVertex); // push
q.peek(); // peek
q.poll(); // pop
//.offer() is faster than .add() // 149ms vs 157ms
// For Trees BFS and DFS Iterative, Level order, etc, we use this same new LL(). But methods we used - add(), remove()
// I tried using q.push() which worked with q = new LL() variant, but it was giving wrong answer
// Then I tried -> using exact queue methods with Level order traversal -> offer() and poll() and it WORKED!!!!
// Didnt see much difference in runtime though, 1ms for both solutions

Stack<Integer> s = new Stack<>(); // or Deque<Integer> stack = new ArrayDeque<>();

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

queue.peek() actually gives first element of the queue

// Suppose we have a Stack, a number is inside that stack as [1 2 -> 2 is at the top of the stack
// How do we convert the number inside stack to 12?
int base = 1;
int k = 0;
// get the number k
while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
    k = k + (stack.pop() - '0') * base; // stack.pop() - '0' is to convert char to Integer
    base *= 10;
}


List<Character> decodedString = new ArrayList<>();
// Step 1: Get the encoded string
while (stack.peek() != '[') {
    decodedString.add(stack.pop()); // This will append the chars in reverse direction 
}


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

//.offer() is faster than .add() // 149ms vs 157ms

// Max Heap
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        
// Create a priority queue, but put the entire map inside. Use Map.Entry
// Max heap
PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
        (a, b) -> // a and b are two consecutive elements in PriorityQueue
    a.getValue() - b.getValue() // THIS CREATES MIN HEAP , FOR MAX HEAP: b.value() - a.value()
);
// REFER to TopKFrequentElements.java

PriorityBlockingQueue is a thread safe implementation
It has the same rules as PriorityQueue, but also provides blocking retrieval operations, so it is thread-safe.

// *******************************************
// Special case for Double. Earlier, during Integer division, we had to typecast one of the operands to Double
// Suppose if our pair has Double data type (a,b) -> (Integer,Double) -> (index,capacity)
PriorityQueue<MyPair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.getSecondValue(), a.getSecondValue()));
//MyPair has methods, getIndex() and getSecondValue()


// PriorityQueue always preserves the order of element in ascending or descending order. We should access them correctly
// Insertion order DOES NOT MATTER
// for retrieval:
// BELOW WILL NOT GIVE CORRECT ORDER OF ELEMENTS RETRIEVED ******** gave me existential crisis!!!!!
// for(MyPair mp: pq){
//     System.out.println("Index: "+mp.getIndex()+" value: "+mp.getSecondValue());
// }

while(!pq.isEmpty()){
    MyPair mp = pq.peek();
    pq.poll(); // WHEN POLLING, WE GET THE RIGHT ORDER
    System.out.println("Index: "+mp.getIndex()+" value: "+mp.getSecondValue());
}

// *******************************************

// FASTER WAY OF ADDING AN ENTIRE ARRAY INSIDE HEAP, WHEN WE HAVE THE VALUES PRE-COMPUTED ALREADY
Map<Character, Integer> counts = new HashMap<>();
for (char task : tasks) {
    counts.put(task, counts.getOrDefault(task, 0) + 1);
}

// 2. Creating max heap, but we are storing only frequency
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
maxHeap.addAll(counts.values()); 


addAll() works only if we have a list in parameter. If we have any int[] array, we need to convert it to a list 
int[] arr = {1,2,3};
List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
// @TODO - Learn more about stream, Collections, Collectors

The shortcut for addAll() will work only if we already have a list.
If we try to convert int[] to list, we are just adding the complexity.
In case of: FInd kth largest element, 
1. Iterating over array and inserting -> O(nlogN) // 71ms
2. Converting to list and doing addAll() -> O(nlogN) // 93ms
// *************************************************************************************************************************

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

// For Strings,
while (nextWord.indexOf(prefix) != 0) is also possible
Both nextWord and prefix is a String



int[] LIS = new int[nums.length];
Arrays.fill(LIS, 1); // initialize every array element as 1

// Initializing distance array in Dijktras to infinity
int[] dist = new int[V];
Arrays.fill(dist, Integer.MAX_VALUE);

// Return the result as an array.
Suppose we have a to return an array as output but we want to work with a List 
List<Integer> list = new ArrayList<>();
return list.stream().mapToInt(i->i).toArray();

// *************************************************************************************************************************

In a Sliding window approach,
here are a total of n - k + 1 windows (where n is the size of nums)  


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

//Leetcode obsession with Hashmap is real - this is how Leetcode compares Hashmaps
// We compare the keys, (character,frequency)
public boolean matches(HashMap<Character, Integer> s1map, HashMap<Character, Integer> s2map) {
    for (char key : s1map.keySet()) {
        if (s1map.get(key) - s2map.getOrDefault(key, -1) != 0) // the values (frequencies) do not match!
            return false;
    }
    return true;
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


// If we have pairs inserted in hashset, there is a way to distinguish if a pair is present in set and needs to be added
// But we need a custom pair class that overrides two methods - @Override public boolean equals(Object o) and 
// @Override public int hashCode()

// It is a NNOOOTTTTT a good idea to use Visited to store positions of grid

// We can store them as a String
Set<String> visited = new HashSet<>();
visited.add(i + "," + j); // Mark (i, j) as visited
if (visited.contains(i + "," + j)) {
    // Already visited
}

// IF we have a question - where we must know the count of 1's that were untouched at the end of matrix traversal, we must return -1
// So instead of traversing at the end of solution, why not get the count when we are traversing the matrix to enqueue all 2
// Refer: Rotten Oranges

O(V + E) → when you **process each vertex and each edge ** exactly once (like BFS/DFS traversal).
// We loop over all vertices v. When we are at vertex v, we process only the direct neighbours of v which is e
// v+e => while doing one v, do one e

O(V × E) → when, for each vertex, you process all edges (often repeatedly).
This usually means a nested loop: for each vertex → loop over all edges.
// We loop over all vertices v. While doing so, when we are at v - we process everything connected to v - all edges

O(V + E)
---------
for each vertex v:
    for each neighbor of v:   <-- only touching adjacent edges
        do something

O(V * E)
---------
for each vertex v:
    for each edge in allEdges:  <-- looping over all edges again and again
        do something


// *************************************************************************************************************************
// MATRIX

Most important concept
A = [a b c]
    [d e f]

A is a matrix of 2 rows and 3 columns 
If we were to represent A as a single dim array, we can convert it to row-order or column-order 

row-order = [a b c d e f]
colum-order = [a d b e c f]

In row-major order, the element at (r, c) would end up at index r * nc + c
int row = id / nc; 
int col = id % nc;

Refer to number of islands problem using BFS


// Iterating through entire diagonal and anti diagonal
// No need to pass the row/col value
if(row==col && checkDiagonal(player)) || if(row+col == n-1 && checkDiagonal(player))

private boolean checkDiagonal(int player){
    for (int row = 0; row < n; ++row){
        if (board[row][row] != player) return false;
    }
    return true;
}
    
private boolean checkAntiDiagonal(int player){
    for (int row = 0; row < n; ++row){
        if (board[row][n - 1 - row] != player) return false;
    }
    return true;
}

// *************************************************************************************************************************
/*
BFS and DFS 

ALWAYS ASK IF THE INPUT GRID CAN BE CHANGED OR NOT
IF YES, IT CAN HELP US GAIN TIME AND SPACE COMPLEXITY. IF NOT, WE HAVE TO USE ANOTHER AUXILLIARY STRUCTURE

Rather than doing the boundary check within the DFS() function, we do it before the invocation of the function
Eg. Checking the Row and Col conditions of grid as the base case -> helps with optimisation
This measure reduces the number of recursion, therefore it reduces the overheads with the function calls

Eg. In Surrounded regions, we gather all boundary cells together. BUT, we do not use two nested for loops
We split the task in two different for loops.
Helps us improve time complexity

Eg. Walls and Gates 

The idea is to start BFS from gates rather than empty cells 
Another idea is to enqueue all gate positions together in a queue, so that we can later explore all gates together

Redundant Edge detection using Union Find and 
Cycle detection using DFS recursive have similar purpose

If cycle exists, we can never finish the courses;
In order to detect cycle, run DFS from all nodes

We have two types of problems - 
CourseSchedule -
Directed graph 
Can be done by BFS (Kahns) and DFS (Recursive, 1*) [DFS iterative is very confusing]

CourseSchedule II -
Directed graph 
Can be done by BFS (Kahns) and DFS (Recursive, 1.1*)  -- only difference is we save the edge that forms cycle

Find Redundant edges that form cycle - 
DIRECTED graph (hence the previous code of DFS cycle will not work)
Cycle prevention using DFS (2*) -> O(n^2); O(n)
Cycle prevention using Union Find (3*) -> By use of Ackerman function -> O(n); O(n)

1*, 1,1* are almost same but DFS
2* is again DFS; 3* is Union Find

*****************IMPORTANT
https://leetcode.com/discuss/study-guide/5050162/Beginners-Guide-for-DFS-on-GridMatrix-or-Three-Variations/
https://iorilan.medium.com/after-finished-1000-leetcode-medium-level-i-found-some-patterns-dfs-77e584425474
*/

|                                                | **DFS Recursive**                      | **DFS Iterative**                                                    | **BFS Recursive**                                  | **BFS Iterative**                                         |
| ---------------------------------------------- | -------------------------------------- | -------------------------------------------------------------------- | -------------------------------------------------- | --------------------------------------------------------- |
| **When to mark visited?**                      | ✅ Before recursive call                | ✅ After popping from stack                                           | ⚠️ Rarely used                                     | ✅ When enqueuing                                          |
| **Why?**                                       | To avoid cycles and infinite recursion | Because stack might hold same cell multiple times if not yet visited | BFS recursion is rare (usually not used for grids) | To avoid adding the same cell multiple times to the queue |
| **Where is the check?**                        | `if (!visited)` before recursive call  | `if (visited)` after popping                                         | Similar logic but rarely applied                   | `if (!visited)` before enqueuing                          |
| **Can you mark before adding to stack/queue?** | ✅ Yes                                  | ❌ No (can cause bugs like yours)                                     | ❌ (BFS recursive rarely applies)                   | ✅ Yes                                                     |


DFS is better for directed cycle detection if you want to find the actual cycle. BFS (via Kahn’s) is good for a yes/no answer.

// DFS different return types
1. Check if Valid path exists - possible via BFS Iterative (queues) and DFS recursive 
Boundary condition --> if source == destination, return true
So, the DFS function will also return true. Overall, global return is false

2. 
Cycle Detection - Union Find
if (!dsu.union(edge[0], edge[1])) // if union return false, we negate and hence cycle was detected
    return edge;
the union operation returns false), a cycle is detected
// Union Find: -> Time: O(n * Alpha(n)) = O(n), Space: O(n) - by use of inverse ackerman function 
// Space = ?    

Cycle Prevention - DFS
Boundary condition --> if source == destination, return true
So, the DFS function will also return true. Overall, global return is false
So, from the main - we handle it as: if(!graph(edge[0]) && !graph(edge[1]) && dfs()) return edge; // the one that causes cycle and is redundant
// Iterative: DFS: -> O(n^2); O(n)
// Space = ?

3. Cycle detection, but in directed graph using DFS 
// we need visited and cycle set
for(int i=0; i<numCourses; i++){
    // for all courses, DFS is good for cycle detection, we run DFS from all nodes
    if(!dfs(i,adjMap,visited,cycle)) // i = source, from 0 to n-1
        return false;
}
return true;

public boolean dfs(int source, Map<Integer,List<Integer>> adjMap, Set<Integer> visited, Set<Integer> cycle ){

        // cycle, so we cannot do anything; ideally return true for cycle detection
        if(cycle.contains(source))
            return false; // False => We cannot complete anything

        if(visited.contains(source))
            return true;

        // Looks like backtracking format of calls
        // Add; recursive call; Remove
        cycle.add(source);
        for(Integer nodes: adjMap.getOrDefault(source, Collections.emptyList())){
            if(!dfs(nodes,adjMap,visited,cycle))
                return false; // why return false? - contains cycle, so we cannot do anything
        }
        cycle.remove(source); // verfied that this source is not forming a cycle, so removed it from Cycle()

        visited.add(source);
        return true;
    }


// BIPARTITE GRAPH
We can detect Bi-partitie graph using both BFS and DFS. 
Both are O(V + E).
Time/space complexity is the same.
The main difference is implementation clarity.

BFS naturally works in levels (layers).
You can assign one color to the current node and the opposite color to all its neighbors.
Since BFS expands level by level, neighbors of the same level never get colored together.

DFS can also color nodes recursively.
You assign a color to the current node and alternate for its neighbors.
Trickier because recursion dives deep, and you must carefully propagate colors back up. 
It is easy to make mistakes with disconnected graphs unless you loop over all components.


My Confusion:
So can I say that checking the graph is bipartite or not is same as checking if there is a cycle that exists in a graph?
If it is the cycle part, then it explain why I was leaning more towards using dfs

if a graph has cycles, it can still be bipartite if all cycles are even length.
But if a given graph has cycle of ODD lenght, it cannot be bipartite.
A graph is bipartite if and only if it has no odd-length cycle.
But even if a graph has cycles, it can still be bipartite if all cycles are even length.
Example: a square (cycle of length 4) → bipartite ✅
Example: a triangle (cycle of length 3) → not bipartite ❌

So just detecting cycles is not enough — you need to check for odd cycles specifically.

Bipartite check ≠ plain cycle detection.
Bipartite check ≈ “check for odd-length cycle.”
BFS is often preferred because it makes odd/even levels explicit.

// *************************************************************************************************************************

/**
Recursion and its complexity:

Shrink n slowly => n -> n-1 -> n-2 .... to base case
MORE no of calls to reach base case
We need n calls
Progress from n to base case is LINEAR
Complexity: O(n)


Shrink n faster => n -> n/2 -> n/4 ... to base case
LESS no of calls to reach base case
We need log(n) calls
Progress from n to base case is is LOGARITHMIC
Complexity: O(Logn)

Faster we reach from n to base case, better is the time complexity


*/





/** 
Whenever solving problems on trees - remember the following:


1. Get the appropriate mode of traversal - DFS (In,Pre,Post) or BFS
2. Get the right set of options - Eg. If Pre -> Can use Iterative, Recursion and Morris
3. Decide the right Data Structure -> LL or ArrayDeque
4. Get the right variable for answer -> local or Global variable + method's return type
5. Check what happens when root is null
6. If writing the recursion - 
Check for leaf node condition - what should happen? Eg. Terminate current path, reset variables, add current path to result
Check for any boundary variables and set appropriate checks for them -> if (high > low) return;
Do something for current set of nodes
Add transition for next set of nodes

CURRENT NODE
TERMINATING CONDITION
TRANSITION

When we have to examine long paths or chains, remember that we use DFS instead of BFS
(Same strategy for graphs -> No of islands, we use DFS)

///// @#$%^&*()#$%^&*(&^%$#@#$%^&*())
// EXISTENTIAL CRISIS AGAIN, CHANGING THE POV FOR ALL TREE PROBLEMS

In which order do we need processing?
If we want to explore the child nodes first and then parent -> it is POST ORDER
Eg. Get the left and right values, compare and move ahead in direction of the maximum
At this point, we need to know the children first before we can decide anything for the parent.
Hence, POSTORDER

If we want to find LCA, we need common parent (tip)
// parents are always revisited, lets take advantage of this
// We dont store the list of parents
// While traversing, we just assign some values to nodes (runtime) so they can be used again when that node is revisited

flag1=true , flag2=true
if(flag1 && flag2) -> both true, do something

Alternate way of doing this -
flag1=1, flag2=1
if(flag1+flag2 >=2) -> it means both were set as true or 1 -> do something

O(1): Every operation consistently takes constant time.
Average O(1): Operations may occasionally take more time, but the average over many operations is constant.
*/

/**
Which traversal can help uniquely identify a tree? None
With Inorder, preorder and postorder, we know that there 2n-1 different combinations possible
So we cannot use any of them individually.

But, we can use Preorder or Postorder, by replacing the NULL in their traversal - by some character
Correct Serialization Method
It turns out that if we include # or any other character for the null node while serializing, then we can uniquely identify a tree, that too with only one traversal (either preorder or postorder).

Preorder Traversal (or postorder traversal) with markers for null node unique determines Binary Tree

In preorder traversal, we are sure that the first node is the root node. Now, the next node in the serialized is the root of the left subtree. If the next node is

# node, it means that the root node doesn't have any left child. The node after # will be the root of the right subtree.

non-# node, which means that the root node has a left child. The node after the left child will be the root of the left subtree of the left child. If the next node is

# node, it means that the left child doesn't have any left child. The node after # will be the root of the right subtree of the left child.
non-# node, which means that the left child has a left child. The node after the left child will be the root of the left subtree of the left child of the left child. And so on.
Thus, with preorder traversal, we can determine the root, and its left and right subtree.

We can compare strings using KMP - Knuth-Morris-Pratt 
We can create hash of two trees and compare - Eg. https://leetcode.com/problems/subtree-of-another-tree/editorial/

*/


// *************************************************************************************************************************
// Or just use this for regex
String regex = "[^a-zA-Z0-9]+"; // ^ is inside and + is needed for multiple instances
String regex = "\s+"; // "\\s+"; also works
x = x.replace(regex,""); // for for single instance
x = x.replaceAll(regex,""); // OR x.replaceAll(regex," ") - reduce multiple spaces to single 

Character.isLetterOrDigit(s.charAt(0));

int[26] for Letters 'a' - 'z' or 'A' - 'Z'
int[128] for ASCII
int[256] for Extended ASCII

When left and right pointers scross each other, we have a pallindrome

// Storing the frequency of a character in an array, instead of a hashmap
s1arr[s1.charAt(i) - 'a']++;

// '2' - '0' , if we have a number-we subtract 0
// 'c' - 'a' , if we have a character-we subtract a

// *************************************************************************************************************************

// Map<Integer,List<String>> map is given 
// digits = "23", so at a time, we will have only "2" or "3"

Integer key = Integer.parseInt(digits.charAt(0)+"");  
// should be re-written as :
Integer key = Character.getNumericValue(digits.charAt(0));
// OR
Integer key = digits.charAt(0) - '0';

// We could have used a hashmap to keep the frequency count, but we use an array instead
for (char c : tasks) 
    arr[c - 'A']++;

// *************************************************************************************************************************
// For Strings and array manipulations
/**
It is always a good strategy to iterate over an array or string and keep increasing counter, specially when we have groups.


Better way -
keep increasing the counter in groups, try skipping steps, when going from one group to another
Eg. [b,b,b,b,b,b,b,b]
ctr=1; // we know given letter is present at least once, so only for this case not starting from 0

while (arr[i + ctr] == arr[i] && i + ctr < arr.length ) { // (i+ctr)<n && every elem in group is equal to first char
    ctr++; // [b,b,b...] compare all indexes from 2 to n , make sure they are b
}

.....code....

// restart from next group, we move our pointer directly to start of next group
// instead of incrementing it one by one
i += ctr;
*/


// *************************************************************************************************************************

1.First 5 mins, understand Qs and ask doubts
2.Fill below template


// Problem:

// Brute Force:

// Final:

// *************************************************************************************************************************
For DP,
prefer iterative, since they are time complexity efficient

For 0-based arrays
int[] dp = new int[nums.length+1];
Solution at dp[last elem]; // still verify

For 1-based arrays
int[] dp = new int[nums.length];

// Simple Approach for every DP Solution
Find recursive relation
Recursive (top-down)
Recursive + memo (top-down)
Iterative + memo (bottom-up)
Iterative + N variables (bottom-up)

Whenever we are using memoisation and have an array, check if we need to store the entire array or not. 
Eg. For Fibonacci series, we store upto entire array to get Space Complexity as O(n); but we can only store 2 variables
prev and prevprev. So, we can reduce the space complexity to O(1)

See if the problem is asking for making up any combinations of words, 
Eg. 
Coin change - We have 3 coins [1,2,5] and amt=11. We have to determine if there exists a combination of coins that give 11.
We started from 11 and iterate through all choices, evaluating (amt-coins[i]) at every step

Word Break - We have a string, applepenapple and worddict = [apple,pen]. We have to determine if we can split s in a way that 
all it substrings are in worddict. Simplifying the problem statement, we have to find if there is a combination of words from dict 
that exists and form the original string. Words can be used 0 to Infinite times 
Here, we form a substring everytime and check if it exists in the worddict or not 

For DP problems, manually iterate through given choices
Then make a state space tree 
Eg. For Coin change problem, we have amount 11 and given choices are [1,2,5]
By making a tree, we know how to proceed further

How do we even start the tree?
Take the amount 11 and start applying choices one by one 
11 -> If used 1 coin of amount 1 -> New Amount = 10
11 -> If used 1 coin of amount 2 -> New Amount = 9
11 -> If used 1 coin of amount 5 -> New Amount = 6

So, now we have new amounts coming from and we found a way to decompose the main amount 11 into smaller values using given choices*
For 11, dp[11] is minimum number of coins to make amount 11
dp[11] = 1 + min(dp[10],dp[9],dp[6])

With the state space tree, we will find the base cases, eg. When amount is zero, return 0 (no coins needed)
When amount is negative, return -1 as we cannot make a negative amount using given coins

Kadane algorithm is often used as an improvement in DP

There are two versions of problems where we can use kadane 

Maximum Sum Subarray -> Find a subarray with maximum sum -> Simple Kadane 
Maximum Product Subarrau -> Find a subarray with maximum product -> Modified Kadane 

Kadane will work with positive and negative numbers, then why two versions?
Because sum with negative numbers is still fine 
But product with negative numbers can flip results heavily - so we have to modify Kadane a bit

Max Sum:
*If your current sum goes negative, it is always worse to keep going.
*Adding a big or small number has a gradual effect.
*Worst case: it brings the sum down or up slowly.
*In max sum, you don’t have the problem of preserving localMax because the logic is linear and sequential.
*In max sum: Zero is fine. Might be useful or not.
"If the sum goes negative, throw it away."
"Always build from positive progress"

Max Product:
*Negative numbers can flip the product from bad to good
*You cannot just throw away a “bad” local product — you must track both:
*The highest product so far → might become the answer.
*The lowest product so far → might flip and become the max later.
*Multiplying by 0 → kills the whole thing.
*Multiplying by -1 → flips signs.
*Multiplying by a huge number → explodes the value.
*You must preserve the previous max before you overwrite it
*This is crucial because localMax gets overwritten before we compute localMin, but localMin still needs the original value of localMax.
*In max product: Zero resets the product. You need to start over, but Math.max and Math.min handle this inherently.
"Keep both fire and ice."
"You don’t know when a bad value will flip and become your best"

/// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
Recursion and BackTracking:::::

What screams backtracking? "ALL POSSIBLE"

| 🔍 Hint from Problem                                                        | 💡 Why It Points to Backtracking                                                                                                       |
| --------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------- |
| **All combinations**                                                        | Suggests *exploring multiple paths* and *generating all possible outputs* (a hallmark of backtracking).                                |
| **Each digit maps to multiple characters**                                  | At each position in the input, there are multiple "choices" → classic recursive branching.                                             |
| **Return all results, any order**                                           | You’re not optimizing or searching — you are *enumerating* all possible valid combinations.                                             |
| **Variable number of choices at each level**                                | Different digits map to different number of letters (e.g., '7' → 4 letters, '2' → 3), which aligns well with recursive decision trees. |
| **Each character in input string requires choosing one of several options** | That’s a classic decision tree / backtrack setup: “For this position, try all options, recurse, backtrack.”                            |


✅ When NOT to Use Backtracking

If the problem were:

“What is the maximum/minimum...”
“Find if at least one solution exists...”
“Count the total number of ways without building all solutions...”
→ Then you'd consider DP, Greedy, or BFS instead.


Backtracking Parameters ::
1. If possible try to keep the sum as a parameter - it is more clean as maintaining a global copy can create problems 
2. If there is a variable that needs state change - try to pass it as a parameter only.

Combination sum - 
start in param; 
i=start; i< n; i++; used in the for loop
helper(...., i) => in the recursion call - we have i 
// only i because we can re-use elements - next recursion call can make use of same element i


Combination - 
start in param; 
i=start; i< n; i++; used in the for loop
helper(...., i) => in the recursion call - we have i + 1 // ****
// i+1 because we cannot have duplicates, so next recursion call must be starting from next element 


The backtracking function structure can also differ - Refer 77.Combinations

1. Loop based structure 
for(int c=start; c<candidates.length; c++){
    possibleCand.add(candidates[c]);
    helper(possibleCand, candidates, result, c + 1);
    possibleCand.remove(possibleCand.size() - 1);
}

2. Explicit choices in the code, no loop

// Choice 1: include nums[index]
current.add(nums[index]);
helper(nums, index + 1, current, result);
current.remove(current.size() - 1);
// Choice 2: exclude nums[index]
helper(nums, index + 1, current, result);

They both produce the exact same output, what is the difference?
| **Aspect**               | **Code 1: Loop-based**                          | **Code 2: Include/Exclude**                 |
| ------------------------ | ----------------------------------------------- | ------------------------------------------- |
| **Style**                | Iterative (loop inside recursion)               | Pure recursive with binary branching        |
| **Recursion Tree Shape** | N-ary (fan-out loop per call)                   | Binary (2 branches per call)                |
| **Use Case**             | Combinations (or subsets)                       | All subsets (power set)                     |
| **Subsets Generated**    | All subsets                                     | All subsets                                 |
| **Decision per element** | Pick one from remaining (`start` to `n`)        | Include or exclude current index            |
| **Duplicates Handling**  | Avoided naturally via `start` index             | Needs explicit handling (e.g., sort & skip) |
| **Time Complexity**      | **O(2ⁿ)** (each element either in/out)          | **O(2ⁿ)** (2 choices per element)           |
| **Space Complexity**     | **O(n)** (stack + subset being built)           | **O(n)** (stack + subset being built)       |
| **Total Output Size**    | **O(n·2ⁿ)** (since copying subsets of size ≤ n) | **O(n·2ⁿ)**                                 |
| **Recursion Depth**      | Up to **n**                                     | Up to **n**                                 |
| **Tree Size**            | ~2ⁿ nodes (but fewer explicit calls)            | Exactly 2ⁿ nodes                            |
| **More Intuitive For**   | Combinations                                    | Subsets / Decisions                         |
| **Google Interview?**    | ✅ Yes — expected to understand & explain        | ✅ Yes — classic style for subsets           |

The above logic holds true only if the fan out remains constant through the course of tree expansion
The fan-out is decreasing at every level with every choice, so we cannot consider the complexity to be nⁿ.
For loop based behavior - the no of nodes generated in the tree is bounded by 2^n. Which is also the number of subsets.

"Because we need to explore all possible letter combinations, and at each step, we make a choice from multiple options for a 
given digit. This leads to a tree of decisions — and that’s exactly what backtracking is designed to explore."

Subtle differences in backtracking and DP:
- Exploring all possible combinations is what I can do correctly.
- Find if any valid jump path exists (does it not implicitly tell us that start by exploring all possible paths and 
return when you find the first valid path)?

| Thought Process                         | Is it logically valid? | Is it efficient? | Is it what we want?   |
| --------------------------------------- | ---------------------- | ---------------- | --------------------- |
| “Explore all paths to find a valid one” | ✅ Yes                  | ❌ No (too slow)  | ❌ Only if necessary   |
| “Explore until a valid path is found”   | ✅ Yes                  | ✅ Yes            | ✅ Ideal for `canJump` |



In Jump Game problem, we optimize backtracking with memoization,
But in Combination Sum, we use backtracking without memoization [no optimisation for time, wild complexities]

| Problem           | Type                    | Goal                                         | Are there overlapping subproblems?              | Do we need to explore all paths?       |
| ----------------- | ----------------------- | -------------------------------------------- | ----------------------------------------------- | -------------------------------------- |
| `canJump`         | **Decision problem**    | Is there **any path** to the end?            | ✅ Yes — same positions revisited multiple times | ❌ No — we stop at first valid path     |
| `Combination Sum` | **Enumeration problem** | **Find all combinations** that sum to target | ❌ No — combinations differ by path              | ✅ Yes — we want all valid combinations |

ALWAYS SEE IF A PROBLEM IS **Enumeration problem** OR **Decision problem** problem 
Decision problems always do have some sub-problem
Memoization is about avoiding recomputation — but in Combination Sum, each path is a valid, distinct solution.
Memoization only works when the result of a subproblem is the same regardless of how you got there. 
In Combination sum, we are generating a unique value at every step

Backtracking explores possibilities; memoization skips repeated work.
Only use both when the subproblem answer is always same and independent of the path taken to get there.

Jump Game is a Greedy problem too.
✅ The Moment to Ask About Greedy
The exact tipping point is when:
You realize the problem has a single boolean goal (yes/no), and that some intermediate states completely dominate others.


🧠 When NOT to ask about greedy

Greedy won’t help when:
The problem needs all combinations (like Combination Sum)
The problem has multiple optimal subpaths, not just one
The decision at each step depends on previous steps in a non-monotonic way


| Question                                                                   | If Yes → Think Greedy |
| -------------------------------------------------------------------------- | --------------------- |
| "Do I care only about *a final boolean answer* (true/false, yes/no)?"      | ✅                     |
| "At each step, is there *one best move* I can make that dominates others?" | ✅                     |
| "Is my DP solution checking all paths but only using *one* in the end?"    | ✅                     |
| "Are the problem constraints *monotonic* (like increasing/decreasing)?"    | ✅                     |
| "Can I prove that greedy decisions never block a valid solution?"          | ✅                     |

Backtracking and DP teach you the space. Greedy teaches you what space you can safely skip.
you absolutely can represent both backtracking and greedy problems using a tree structure.

But here’s the key idea:
The tree always exists — it is the full space of decisions.
The difference is HOW MUCH of the tree you explore.


🌲 The decision tree exists in every problem.
🧠 Backtracking explores it all.
🧰 DP avoids redoing parts of it.
🏃 Greedy skips most of it.

| **Problem Goal**                               | **Paradigm to Use**                                                      | **Reason**                                                                               |
| ---------------------------------------------- | ------------------------------------------------------------------------ | ---------------------------------------------------------------------------------------- |
| Explore **all possible paths/combinations**    | ✅ **Backtracking**                                                       | You want to generate **all valid answers**, so you must explore the full tree.           |
| Check if **any valid path exists**             | ✅ **Decision-making DFS (with early return)**<br>✅ Maybe **Memoization/DP** | You are looking for **just one valid path**; prune the tree ASAP.                         |
| Check if a **given path (like a word)** exists | ✅ **Backtracking DFS**<br>✅ Optionally **Prefix Trie** for optimization  | You are trying to match a **sequence**, so DFS with character-by-character match is best. |


| Question                                      | Decision                                            |
| --------------------------------------------- | --------------------------------------------------- |
| Am I generating **all results**?              | → Backtracking (e.g., combinations, permutations)   |
| Am I checking if **one valid result exists**? | → DFS with early stopping, maybe greedy or memoized |
| Am I matching a **specific path/sequence**?   | → DFS (often backtracking), sometimes Trie (if many words)|


| Problem Sounds Like…                  | You Think…          |
| ------------------------------------- | ------------------- |
| “Find all possible combinations/ways” | Backtracking        |
| “Find if possible”                    | DFS / Memo / Greedy |
| “Match a sequence”                    | DFS / Trie          |
| “Min/Max result”                      | DP / Greedy         |
| “Find shortest path”                  | BFS / Dijkstra      |
| “Group/Connect things”                | Union-Find          |
| “Sliding over input”                  | Two Pointers        |
| “Sort by frequency/value”             | Heap                |
| “Flip/toggle bits, subsets”           | Bitmasking          |

Memoisation vs Kadane (Special case of DP with O(1) space optimisation specially designed for contiguous arrays)
🧠 Memoization:

You can only cache (memoize) a subproblem if its result doesn’t depend on the path taken to reach it.

That is, for a given state (like index, remainingSum), the result must always be the same, no matter how you got there.

If the result varies by path, memoization would store the wrong value for other paths.

✅ Example:

In Coin Change (min coins):

dp[i] = min coins to make amount i — same result regardless of which coins you tried before.

So memoization is valid.

In Combination Sum:

Every path is a unique valid answer.

You should not memoize, because result depends on the choices made.

⚙️ Kadane Algorithm:

Kadane does not memoize subproblems.

Instead, it relies on the fact that:

The optimal solution for a subarray ending at i can be computed from the subarray ending at i-1, in O(1) time.

It only ever considers one path: the best contiguous subarray ending at each index.

There’s no branching, so no conflicting paths to worry about — thus no need for memoization.

🚩 Critical Difference in One Line:

✅ Memoization avoids recomputation in branching recursive problems by caching results.
✅ Kadane never branches — it linearly accumulates one optimal path, so no need for caching.





What I was doing for word search?
Taking each char from the word and trying to see if exists or not in grid using some traversal
What should I be doing?

when question already includes a given sequence/word - pass it directly to dfs. Let dfs take care of handling that word.
We are marking that word on board char by char - backtrack when something doesnt match. 

/* Step 1). check the bottom case. */
        if (index >= word.length()) return true; // ?????? , yes, we were able to reach the entire word while matching characters


If the last branch returns true from the base case, will that true automatically be propagated back up to the original caller?
NOPe.
if the dfs we write returns a value, then by virtue of that -
every function call stored in the recursion stack is expected to return some value. So, if the last function in the stack returns 
true using the base case, the value isnt propogated by itself.
f you don’t capture and check the return value in each frame of the recursion stack, the true result will be lost — and never bubble up.

Let us first review the problems of Permutations / Combinations / Subsets, since they are quite similar to each other and there are some common strategies to solve them.

First, their solution space is often quite large:

Permutations: N!.
Combinations: C 
Subsets: 2^N 
since each element could be absent or present.

Given their exponential solution space, it is tricky to ensure that the generated solutions are complete and non-redundant. 
It is essential to have a clear and easy-to-reason strategy.
There are generally three strategies to do it:

1. Iterative

2. Recursion/Backtracking

3. Lexicographic generation based on the mapping between binary bitmasks and the corresponding permutations / combinations / subsets.

As one would see later, the third method could be a good candidate for the interview because it simplifies the problem to 
the generation of binary numbers, therefore it is easy to implement and verify that no solution is missing.
Besides, as a bonus, it generates lexicographically sorted output for the sorted inputs.


Jump Game is - Backtracking + Memoisation , Greedy (Best)
Get all Subsets - Backtracking , Lexicographic (Gives same complexity as BT)

Different type of patterns for backtracking -
others -> normal 
    - add (could be a string/list)
    - recursive call
    - remove (could be a string/list)
Word Search -> Backtracking is outside the for loop
Return all subsets -> We have 2 separate Backtracking calls, for LST and RST 




// *************************************************************************************************************************
// HashTable Example
// Create a Hashtable instance
Hashtable<String, Integer> hashtable = new Hashtable<>();

// Add key-value pairs to the Hashtable
hashtable.put("Apple", 3);
hashtable.put("Banana", 5);
hashtable.put("Orange", 2);
hashtable.put("Pineapple", 10);

// Print the entire Hashtable
System.out.println("Hashtable: " + hashtable);

// Retrieve a value based on its key
String key = "Banana";
if (hashtable.containsKey(key)) { //****
    int value = hashtable.get(key); //****
    System.out.println("The value for key \"" + key + "\" is: " + value);
} else {
    System.out.println("Key \"" + key + "\" not found in the Hashtable.");
}

// Remove a key-value pair
hashtable.remove("Orange"); //****
System.out.println("After removing \"Orange\": " + hashtable);

// Iterate over the Hashtable
System.out.println("Iterating over the Hashtable:");
for (String fruit : hashtable.keySet()) { //**** not entrySet()
    System.out.println(fruit + " => " + hashtable.get(fruit));
}
// *************************************************************************************************************************

ThreadLocalRandom random = new ThreadLocalRandom.current();
int i = random.nextInt(1,arr.length); // [1,length) inclusive,exclusive

// *************************************************************************************************************************

/**
Summary:::
Kth largest // Kth Smallest
1. If array is sorted -> directly lookup the array and return appropriate value
2. If array is NOT sorted ->
Kth largest -> use Min Heap -> O(nlogK) [If we use Max here, it is O(nlogN)]
Kth smallest -> use Max Heap -> O(nlogK) [If we use Min here, it is O(nlogN)]
 */

 class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(); //Min Heap
        for (int num: nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        
        return heap.peek();
    }
}

// *************************************************************************************************************************

Bit manipulation

1. Count no of 1s 
We can use Bitmasking technique. Mask is 0000 ---- 0001 => 1 but represented in 32 bits binary 

Clearly, a logical AND between any number and the mask 1 gives us the least significant bit of this number. 
To check the next bit, we shift the mask to the left by one.
0000 ---- 0010 (next mask)

When we AND with a mask, the set bits (1s) in the original number get reflected and shine out 

a = (byte)(n%2); -- also extracts a given bit 

x << 1 = multiply by 2
x >> 1 = divide by 2 
x % 2 = get the last digit 
(byte)(x%2) = get the bitwise digits 
x & 1 = Get lsb of binary representation

Integer.bitCount(x) => Gives all set bits in given x => Hamming weight 
Integer.bitCount(x^y)=> Gives all set bits in given x ^ y => Hamming distance Brian Kernighans algo

Checking if a given number is even or odd:
General way: (x % 2) == 0? Even:Odd
Binary way: (x & 1) / 1 == 0? Even:Odd [x & 1 = Get lsb of binary representation]

Checking if two integers have same sign or opposite sign 
It is similar to XOR operation 
The first bit represents the flag value (positive or negative)
(x^y) > 0 ? Positive:Negative

Suppose, x = 1 OR in binary 

// *********************************
(0000 0001) << 5
// *********************************

The bit 1 moves 4 postions to left 
The original number is multiplied by 2^5
Makes a difference in the structure of a number

Answer: (0001 0000)


// *********************************
(0000 0001) & 16 (k=5)
// *********************************

There is no change in the bit position 
We just get the value at kth position 
No structural change, just get the bit at a given position. & is the most neutral operator

Answer: (0) or (1) depending what is the value at kth bit 

Follow-up:
Set the kth bit of a number to zero

We start with 1, modify it as per details and then AND/OR/XOR with the given number
We can always start with 1 (0000 0001)
To set k=5th bit as zero, we need to modify our mask of 1 to have some magic at kth bit 

How to reach kth bit in 5 and modify it ?
(0000 0001) << 5, but it will pull 1 5 places from the start 
We only want 4 jumps, we are already at LSB 

(0000 0001) << (5-1)
(0000 0001) << (4) rewritten as (0000 0001) << (k-1) rewritten as 1 << (k-1)

Now, if we want to set the kth bit of our input to zero, we must modify the mask 

[1 << (k-1)] => kth bit is 1

~[1 << (k-1)] => kth bit is 0

To SET the kth input bit => x & [1 << (k-1)]
To UNSET the kth input bit => x & ~[1 << (k-1)]


Calculate the minimum(a,b) without using any relational operators:
// Calculate the difference
int diff = a - b;

// Use bitwise right shift to determine the sign of diff
// If diff is negative, sign will be -1, otherwise 0 (if a == b) or 1 (if a > b)
int sign = (diff >> 31) & 1; // 1 if diff < 0, 0 otherwise

// Return a if a is less than or equal to b, otherwise return b
return a * (1 - sign) + b * sign;


//// ALL GRAPH TRAVERSAL ALGOS to exist - 
1. MST
| Level       | Algorithms                | Description                                                                                                |
| ----------- | ------------------------- | ---------------------------------------------------------------------------------------------------------- |
| 🔹 Basic    | **Prim’s**, **Kruskal’s** | Most commonly used MST algorithms. Prim’s is better for dense graphs, Kruskal’s is easier with edge lists. |
| 🔸 Advanced | **Borůvka’s Algorithm**   | Very parallelizable MST algorithm. Good for distributed systems or repeated MST constructions.             |

Each component picks the cheapest edge connecting it to another component.
All such edges are added to the MST at the same time.
The graph is contracted (i.e., merged) into fewer components.
Repeat until there is only one component = the MST.



2. Single Source Shortest Path (SSSP)
| Level       | Algorithms                                       | Description                                                                                                  |
| ----------- | ------------------------------------------------ | ------------------------------------------------------------------------------------------------------------ |
| 🔹 Basic    | **Dijkstra’s**                                   | Classic greedy algorithm for SSSP with non-negative weights.                                                 |
| 🔹 Basic    | **Bellman–Ford**                                 | Works with **negative weights** and **detects negative cycles**.                                             |
| 🔸 Advanced | **Dial’s Algorithm**, **D’Esopo–Pape Algorithm** | Optimizations for Dijkstra in **special cases** (e.g. small integer weights, road networks).                 |
| 🔸 Advanced | **Push–Relabel (used for flow)**                 | While not for SSSP, its a **node-based flow optimization** concept often studied alongside path algorithms. |


3. All-Pairs Shortest Path (APSP) Algorithms
| Level       | Algorithms              | Description                                                                                   |
| ----------- | ----------------------- | --------------------------------------------------------------------------------------------- |
| 🔹 Basic    | **Floyd–Warshall**      | Dynamic programming-based. Works for dense graphs and negative weights (no negative cycles).  |
| 🔸 Advanced | **Johnson’s Algorithm** | Best for **sparse graphs with negative weights**. Uses reweighting + multiple Dijkstra calls. |


4. Max Flow Min cut 
| Level           | Algorithms                 | Description                                                                               |
| --------------- | -------------------------- | ----------------------------------------------------------------------------------------- |
| 🔹 Basic        | **Ford–Fulkerson**         | Conceptually simple. Finds augmenting paths, but can be very slow without optimizations.  |
| 🔸 Intermediate | **Edmonds–Karp**           | A BFS-based implementation of Ford–Fulkerson. Guarantees polynomial time.                 |
| 🔸 Advanced     | **Dinic’s Algorithm**      | Uses level graphs and blocking flows. Efficient in practice and theory.                   |
| 🔸 Advanced     | **Push–Relabel Algorithm** | Local flow optimization. Faster in **dense** graphs.                                      |
| 🔸 Bonus        | **Karger’s Min Cut**       | Randomized approach to find global min cut (not max flow directly). Probabilistic method. |


5. Eulerian & Chinese Postman (Edge Traversal)
| Level           | Algorithms                    | Description                                                                                                                     |
| --------------- | ----------------------------- | ------------------------------------------------------------------------------------------------------------------------------- |
| 🔹 Basic        | **Hierholzer’s Algorithm**    | Finds Eulerian Circuit if it exists (uses every edge exactly once).                                                             |
| 🔸 Intermediate | **Chinese Postman Algorithm** | Route inspection problem – find **shortest route** covering **every edge at least once**. Requires pairing odd-degree vertices. |


6. Graph Generation / Theoretical Algorithms
| Level         | Algorithms                 | Description                                                                                           |
| ------------- | -------------------------- | ----------------------------------------------------------------------------------------------------- |
| 🔹 Conceptual | **Erdős–Rényi Model**      | Random graph generation model. Used for **theoretical analysis** and probabilistic algorithms.        |
| 🔸 Advanced   | **Peterson Graph Problem** | Not a general-purpose algorithm — used in **theory**, counterexamples, or graph property exploration. |


| Problem Type              | Use These Algorithms                  |
| ------------------------- | ------------------------------------- |
| **MST**                   | Prim’s, Kruskal’s, Borůvka’s          |
| **SSSP (non-negative)**   | Dijkstra’s, Dial’s                    |
| **SSSP (with negatives)** | Bellman–Ford                          |
| **APSP (dense)**          | Floyd–Warshall                        |
| **APSP (sparse)**         | Johnson’s                             |
| **Max Flow**              | Ford–Fulkerson, Dinic’s, Push–Relabel |
| **Euler Circuit**         | Hierholzer’s                          |
| **Edge Coverage**         | Chinese Postman                       |
| **Min Cut (randomized)**  | Karger’s                              |
| **Graph Generation**      | Erdős–Rényi                           |
