// Java program for Kruskal's algorithm 

// select min cost edge
// keep selecting min cost edge, but it it forms a cycle, de-select it. de-selecting is also removing nodes
// move to next min edge
// we are not removing edges in greedy or desc order of weight!!! We remove edges that form cycle/rather dont consider them

// USING ADJLIST IMPLEMENTATION with Union Find 
// Simple Java implementation for Kruskal's
// algorithm

// Refer to Algo excel sheet for complexities

import java.util.*;

class GFG 
{

static int V = 5;
static int[] parent = new int[V];
static int INF = Integer.MAX_VALUE;

// Find set of vertex i
static int find(int i)
{
	while (parent[i] != i)
		i = parent[i];
	return i;
}

// Does union of i and j. It returns
// false if i and j are already in same
// set.
static void union1(int i, int j)
{
	int a = find(i);
	int b = find(j);
	parent[a] = b;
}

// Finds MST using Kruskal's algorithm
static void kruskalMST(int cost[][])
{
	int mincost = 0; // Cost of min MST.

	// Initialize sets of disjoint sets.
	for (int i = 0; i < V; i++)
		parent[i] = i;

	// Include minimum weight edges one by one
	int edge_count = 0;
	while (edge_count < V - 1)
	{
		int min = INF, a = -1, b = -1;
		for (int i = 0; i < V; i++)
		{
			for (int j = 0; j < V; j++) 
			{
				if (find(i) != find(j) && cost[i][j] < min) 
				{
					min = cost[i][j];
					a = i;
					b = j;
				}
			}
		}

		union1(a, b);
		System.out.printf("Edge %d:(%d, %d) cost:%d \n",
			edge_count++, a, b, min);
		mincost += min;
	}
	System.out.printf("\n Minimum cost= %d \n", mincost);
}

// Driver code
public static void main(String[] args) 
{
/* Let us create the following graph
		2 3
	(0)--(1)--(2)
	| / \ |
	6| 8/ \5 |7
	| /	 \ |
	(3)-------(4)
			9		 */
	int cost[][] = {
		{ INF, 2, INF, 6, INF },
		{ 2, INF, 3, 8, 5 },
		{ INF, 3, INF, INF, 7 },
		{ 6, 8, INF, INF, 9 },
		{ INF, 5, 7, 9, INF },
	};

	// Print the solution
	kruskalMST(cost);
	}
}

// This code contributed by Rajput-Ji



// USING UNION FIND
import java.util.ArrayList; 
import java.util.Comparator; 
import java.util.List; 

public class KruskalsMST { 

	// Defines edge structure 
	static class Edge { 
		int src, dest, weight; 

		public Edge(int src, int dest, int weight) 
		{ 
			this.src = src; 
			this.dest = dest; 
			this.weight = weight; 
		} 
	} 

	// Defines subset element structure 
	static class Subset { 
		int parent, rank; 

		public Subset(int parent, int rank) 
		{ 
			this.parent = parent; 
			this.rank = rank; 
		} 
	} 

	// Starting point of program execution 
	public static void main(String[] args) 
	{ 
		int V = 4; 
		List<Edge> graphEdges = new ArrayList<Edge>( 
			List.of(new Edge(0, 1, 10), new Edge(0, 2, 6), 
					new Edge(0, 3, 5), new Edge(1, 3, 15), 
					new Edge(2, 3, 4))); 

		// Sort the edges in non-decreasing order 
		// (increasing with repetition allowed) 
		graphEdges.sort(new Comparator<Edge>() { 
			@Override public int compare(Edge o1, Edge o2) 
			{ 
				return o1.weight - o2.weight; 
			} 
		}); 

		kruskals(V, graphEdges); 
	} 

	// Function to find the MST 
	private static void kruskals(int V, List<Edge> edges) 
	{ 
		int j = 0; 
		int noOfEdges = 0; 

		// Allocate memory for creating V subsets 
		Subset subsets[] = new Subset[V]; 

		// Allocate memory for results 
		Edge results[] = new Edge[V]; 

		// Create V subsets with single elements 
		for (int i = 0; i < V; i++) { 
			subsets[i] = new Subset(i, 0); 
		} 

		// Number of edges to be taken is equal to V-1 
		while (noOfEdges < V - 1) { 

			// Pick the smallest edge. And increment 
			// the index for next iteration 
			Edge nextEdge = edges.get(j); 
			int x = findRoot(subsets, nextEdge.src); 
			int y = findRoot(subsets, nextEdge.dest); 

			// If including this edge doesn't cause cycle, 
			// include it in result and increment the index 
			// of result for next edge 
			if (x != y) { 
				results[noOfEdges] = nextEdge; 
				union(subsets, x, y); 
				noOfEdges++; 
			} 

			j++; 
		} 

		// Print the contents of result[] to display the 
		// built MST 
		System.out.println( 
			"Following are the edges of the constructed MST:"); 
		int minCost = 0; 
		for (int i = 0; i < noOfEdges; i++) { 
			System.out.println(results[i].src + " -- "
							+ results[i].dest + " == "
							+ results[i].weight); 
			minCost += results[i].weight; 
		} 
		System.out.println("Total cost of MST: " + minCost); 
	} 

	// Function to unite two disjoint sets 
	private static void union(Subset[] subsets, int x, 
							int y) 
	{ 
		int rootX = findRoot(subsets, x); 
		int rootY = findRoot(subsets, y); 

		if (subsets[rootY].rank < subsets[rootX].rank) { 
			subsets[rootY].parent = rootX; 
		} 
		else if (subsets[rootX].rank 
				< subsets[rootY].rank) { 
			subsets[rootX].parent = rootY; 
		} 
		else { 
			subsets[rootY].parent = rootX; 
			subsets[rootX].rank++; 
		} 
	} 

	// Function to find parent of a set 
	private static int findRoot(Subset[] subsets, int i) 
	{ 
		if (subsets[i].parent == i) 
			return subsets[i].parent; 

		subsets[i].parent 
			= findRoot(subsets, subsets[i].parent); 
		return subsets[i].parent; 
	} 
} 
// This code is contributed by Salvino D'sa
