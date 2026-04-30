/**
Higher Level Intuition:

You have a tree — just a bunch of nodes connected with no cycles. You get to pick any node as the root. Depending on which node you pick, the tree will have a different height.
Same tree, different roots:

Pick node 0 as root:        Pick node 1 as root:
        0                           1
        |                         / | \
        1                        0  2  3
      / | \
     2  3  4         height = 2      height = 1  ← shorter!
     
height = 3
Goal: find the node(s) that when chosen as root, give the shortest possible tree.

The human intuition
Think of it like finding the center of a road network.
If you put a warehouse at the edge of a city, delivery trucks have to travel far. 
If you put it in the center, maximum distance to any point is minimized.
Same idea here — the best root is the most "central" node in the tree.

The key insight
The answer is always 1 or 2 nodes — always the center of the tree.
Why? Because:
The worst roots are always the leaf nodes (edge nodes)
The best roots are always the most central nodes
There can only be 1 or 2 centers in any tree

How to find the center — leaf trimming
This is the elegant part. Instead of trying every node as root (which is slow), you:
Step 1: Find all leaf nodes (nodes with only 1 connection)
Step 2: Remove them — like peeling an onion from outside in
Step 3: The newly exposed nodes become the new leaves
Step 4: Repeat until 1 or 2 nodes remain
Step 5: Those remaining nodes = the answer => List of all nodes that can serve as best root nodes

WHY does this work?
Leaves are NEVER the answer (unless n=1)
because they're at the edges — choosing them as root
makes the tree as tall as possible

By repeatedly removing leaves, you're walking
inward toward the center

You stop at 1 or 2 nodes because:
  1 node  → perfect center
  2 nodes → two equally central nodes
  3+ nodes → can always trim more

### The analogy that makes it stick forever
```
Imagine burning a tree from all its leaf tips simultaneously.
The last node(s) to catch fire = the center = the answer.

My alternate idea which is incorrect:
A node can have:
HIGH degree but NOT be central  → star graph, center has all edges
LOW degree but BE central       → long path, center has degree 2

Calculate the in/out-degree of every node and node with max degree is our answer-
More like top 2 nodes with max degree

*/
// O/P: List of all central nodes that can be centre point of the treee
public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 1) 
      return List.of(0);

    // build adjacency list
    // Remember: We are using Set here
    List<Set<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++)
        graph.add(new HashSet<>());

    for (int[] edge : edges) {
        graph.get(edge[0]).add(edge[1]);
        graph.get(edge[1]).add(edge[0]);
    }

    // find initial leaves (degree = 1) => adjlist of that node has list size as 1 (1 connection)
    List<Integer> leaves = new ArrayList<>();
    for (int i = 0; i < n; i++)
        if (graph.get(i).size() == 1)
            leaves.add(i);

    // trim leaves layer by layer
    int remaining = n;
    while (remaining > 2) {
        remaining -= leaves.size();
        // Why declare this list outside of for loop?
        // Scope problems. We need this newLeaves outside of the loop to re-assign it to leaves list
        List<Integer> newLeaves = new ArrayList<>();

        for (int leaf : leaves) {

            // Why .iterator().next() ? Why to over-complicate? We can use an array List here
            // List<List<Integer>> graph instead of List<Set<Integer>> graph
            // BUT, We are trimming the leaves here
            // .remove() operation in Set is O(1) vs O(n) in ArrayList
            int neighbor = graph.get(leaf).iterator().next(); // only one neighbor
            graph.get(neighbor).remove(leaf);                 // cut the leaf off
            if (graph.get(neighbor).size() == 1)             // neighbor became leaf?
                newLeaves.add(neighbor);
        }

        // Re-assigning references; We make the neighbours our leaves
        // We are iterating leaves, not newLeaves
        leaves = newLeaves;
    }

    return leaves;
}
```

---

### Complexity
```
Time:  O(n) — each node removed exactly once
Space: O(n) — adjacency list
```

---

### The analogy that makes it stick forever
```
Imagine burning a tree from all its leaf tips simultaneously.
The last node(s) to catch fire = the center = the answer.