import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int rowIndex = 5;
        List<Integer> row = solution.getRow(rowIndex);
        System.out.println("Row " + rowIndex + " of Pascal's triangle: " + row);
    }


    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        // FILL UP ALL VALUES OF THE ROW with recursion
        for (int i = 0; i <= rowIndex; i++) {
            row.add(pascalValue(rowIndex, i)); // row number is what is asked, we just supply cols
        }

        return row;
    }

// 2D recursion, to use rows and columns. The math for figuring out middle values by addition
// are valid candidates for recursion
    private int pascalValue(int row, int col) {
        if (col == 0 || col == row) {
            return 1; // Base case: values at the edges are 1
        } else {
            // Recursive case: sum of values from the previous row
            return pascalValue(row - 1, col - 1) + pascalValue(row - 1, col);// not col+1
        }
    }

    
}
