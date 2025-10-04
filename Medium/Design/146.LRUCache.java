/**
Leetcode Official:
*/

// Adding at the end of LL
// Expected: 2<=>Tail
// Needed: 2 (3,4) <=>3 (1,2)<=>tail
/**
Steps 1 and 2 to connect newNode 3 with tail T
Steps 3 and 4 to connect ptr 2 with newNode 3
*/
// Make sure to connect everything

public void add(ListNode newNode) {
    ListNode ptr = tail.prev;
    3.ptr.next = newNode;
    4.newNode.prev = ptr;
    1.newNode.next = tail;
    2.tail.prev = newNode;
}


// COMPLETE QUESTION and solution

class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity; // Like we thought, global variable
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        map = new HashMap<>();

        // How initialisation for Doubly LL looks like!
        // Head <=> Tail
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        ListNode node = map.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode oldNode = map.get(key);
            remove(oldNode);
        }

        ListNode node = new ListNode(key, value);
        map.put(key, node);
        add(node);

        if (map.size() > capacity) {
            ListNode nodeToDelete = head.next;
            remove(nodeToDelete);
            map.remove(nodeToDelete.key);
        }
    }

    public void add(ListNode node) {
        ListNode previousEnd = tail.prev;
        previousEnd.next = node;
        node.prev = previousEnd;
        node.next = tail;
        tail.prev = node;
    }

    public void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */







/*
Constraints:
1.get()- return -1 if no key exists
2.put()- if key exists -> update value
            else -> check capacity:
                    if less: add the key
                    else: evict the lru
           
keep track of capacity
keep track of key lru

O(1) avg time

Possible:
1.HashMap:
get() -> O(1) 
put() -> ? Min Heap -> (key,time) (1,0) (2,1)
    1,2,3 -> remove a[0] from array
    if breach -> evict (1,0) -> remove key:1

Deque?
*/

import java.util.*;

// From GPT, works but slow
class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> cache;
    private final Deque<Integer> deque;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.deque = new LinkedList<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // Move the accessed key to the front of the deque
        deque.remove(key);
        deque.addFirst(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Update the value of the key and move it to the front of the deque
            cache.put(key, value);
            deque.remove(key);
            deque.addFirst(key);
        } else {
            if (cache.size() >= capacity) {
                // Evict the least recently used key
                int leastUsedKey = deque.removeLast();
                cache.remove(leastUsedKey);
            }
            // Add the new key-value pair
            cache.put(key, value);
            deque.addFirst(key);
        }
    }

    // public static void main(String[] args) {
    //     LRUCache lruCache = new LRUCache(2);
    //     lruCache.put(1, 1); // Cache is {1=1}
    //     lruCache.put(2, 2); // Cache is {1=1, 2=2}
    //     System.out.println(lruCache.get(1)); // Returns 1
    //     lruCache.put(3, 3); // Evicts key 2, Cache is {1=1, 3=3}
    //     System.out.println(lruCache.get(2)); // Returns -1 (not found)
    //     lruCache.put(4, 4); // Evicts key 1, Cache is {4=4, 3=3}
    //     System.out.println(lruCache.get(1)); // Returns -1 (not found)
    //     System.out.println(lruCache.get(3)); // Returns 3
    //     System.out.println(lruCache.get(4)); // Returns 4
    // }
}

// Leetcode official

class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(5, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1); // **
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/*
Time complexity: O(1) for both get and put.

Space complexity: O(capacity)

 */
