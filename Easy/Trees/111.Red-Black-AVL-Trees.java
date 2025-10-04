/*
Applications of Red-Black Trees:
Implementing maps and sets: Red-Black Trees are often used to implement maps and sets, where efficient search, insertion, and deletion are crucial.
Priority queues: Red-Black Trees can be used to implement priority queues, where elements are ordered based on their priority.
File systems: Red-Black Trees are used in some file systems to manage file and directory structures.
In-memory databases: Red-Black Trees are sometimes used in in-memory databases to store and retrieve data efficiently.
Graphics and game development: Red-Black Trees can be used in graphics and game development for tasks like collision detection and pathfinding.
*/

Binary Search tree :
1. May or may not be balanced 
2. Search and insert time is O(logN)
3. Complete Binary tree is a Min heap, but Binary Search tree can be represented as sorted array 



Red Black trees :
1. Similar to BST but these have extra colour property in them 
2. Red Black is a self balancing tree
3. Used to implement Maps, Sets and Priority Queues
4. Cannot maintain insertion order, why? In order to be self balancing, this tree may change the node position depending on its val.


What we know so far:
To implement HashMap or HashSet, we can use LinkedLists.
But, we can also use Red Black Trees or AVL Trees.

We can implement Red Black trees by using nodes with pointers -
it is redundant to use LL or RB Trees to implement RB Trees

TRIES:::::::::

While other data structures like balanced trees and hash tables can be used to search for words, 
Tries offer advantages in certain operations:

Prefix Searches: Tries excel in finding all keys with a common prefix.
Lexicographical Ordering: They allow efficient enumeration of keys in lexicographical order.
Space Efficiency: For keys with common prefixes, Tries use less space compared to hash tables, which can suffer from 
hash collisions and increased search times as they grow.