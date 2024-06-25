import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
            {0, 3},
            {1, 2},
            {1, 5},
            {2, 4},
            {3, 5},
            {5, 4},
            {5, 0}
        };

        int[][] matrix = new int[n][n];

        // Initializing the matrix to 0 is implicit in Java for int arrays,
        // so there's no need for memset equivalent. The array is already filled with zeros.

        for (int i = 0; i < edges.length; i++) {
            // matrix[0][3] = 1 but how do we get 0? edge[0][0]
            // matrix[1][2] = 1 bur how do we get 1? edge[1][0] // in general, edge[i][0] for first val and edge[i][1] for second
            matrix[edges[i][0]][edges[i][1]] = 1; // only one initialization means only unidirected graph
        }

        // Printing the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Output

0 0 0 1 0 0 
0 0 1 0 0 1 
0 0 0 0 1 0 
0 0 0 0 0 1 
0 0 0 0 0 0 
1 0 0 0 1 0 