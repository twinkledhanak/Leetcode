
// Huge benefit on time complexity
// Iterative: DFS: -> O(n^2); O(n)
// Union Find: -> Time: O(n * Alpha(n)) = O(n), Space: O(n) - by use of inverse ackerman function 

class Solution {
    int MAX_EDGE_VAL = 1000;

    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(MAX_EDGE_VAL + 1);
        for (int[] edge: edges) {
            if (!dsu.union(edge[0], edge[1])) // if union return false, we negate and hence cycle was detected
                return edge;
        }
        throw new AssertionError();
    }
}

/*
parent initialized as (x -> x)
function find(x):
    while parent[x] != x: #While x isn't the leader
        x = parent[x]
    return x

function union(x, y):
    parent[find(x)] = find(y)
    */

class DSU {
    int[] parent;
    int[] rank;

    public DSU(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) 
            parent[i] = i; // Initially all elements are their own parents!!
        rank = new int[size];
    }


    // **********
    // This method below is called Path Compression

    public int find(int x) { // FIND PARENT OF X! AFTER DSU() CALL, IF PARENT OF X HAS CHANGED, RETURN NEW PARENT
        if (parent[x] != x) // if x has some other parent
            parent[x] = find(parent[x]); // recursive call, but not directly returning the result since we have update parent[] also
        return parent[x];
    }


    // *********
    // This method is called Union By Rank

    public boolean union(int x, int y) {
        int xr = find(x), yr = find(y);
        if (xr == yr) { // already same parent and connected, no structural changes; return false;
            return false; // elements are already connected, so tells cycle is present
        } else if (rank[xr] < rank[yr]) { // higher becomes parent
            parent[xr] = yr;
        } else if (rank[xr] > rank[yr]) {
            parent[yr] = xr;
        } else {
            parent[yr] = xr; // just select any one from these two, since their ranks are same
            rank[xr]++; // xr became parent, so increase rank
        }
        return true;
    }
}

/*
Interpretation of union Output:
true: The union method returns true if the two elements were in different sets and have been successfully united into a single set.
 This indicates that the union operation resulted in a structural change in the DSU.

false: The union method returns false if the two elements were already in the same set. This indicates that no structural change 
occurred because the elements were already connected.

Detecting New Connections:

Use the true result to detect when a new connection is made between previously separate sets. 
This can be useful in problems where you need to count or record when new connections are established.

Cycle Detection in Graphs:

In graph-related problems, the false result can be used to detect cycles. If an edge is added between two vertices that are 
already connected *************(i.e., the union operation returns false), a cycle is detected.*************


Kruskal's Algorithm for Minimum Spanning Tree (MST):

The union method is used to add edges to the MST. Only edges that connect different sets (i.e., when union returns true) are 
added to the MST. This ensures the resulting structure remains a tree.
Dynamic Connectivity:

In dynamic connectivity problems, you can use the result of the union operation to maintain and query connected components 
efficiently.

**/