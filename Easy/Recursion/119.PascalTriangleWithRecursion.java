import java.util.ArrayList;
import java.util.List;

public class Solution {

// THIS IS JUST TO UNDERSTAND THE CONCEPT. IT WILL GIVE TLE
    public static void main(String[] args) {
        Solution solution = new Solution();
        int rowIndex = 5;
        List<Integer> row = solution.getRow(rowIndex);
        System.out.println("Row " + rowIndex + " of Pascal's triangle: " + row);
    }


    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        // FILL UP ALL VALUES OF THE ROW with recursion
        // We do not have to write explicit conditions for adding 1 at START and END of the row
        // HOW MANY COLS ARE PRESENT IN EACH ROW?
        // 0: 1
        // 1: 1 1
        // 2: 1 2 1 , NO OF COLS = NO OF ROWS + 1
        for (int i = 0; i <= rowIndex; i++) { // Or , int i=0; i< row+1; i++
            row.add(pascalValue(rowIndex, i)); // row number is what is asked, we just supply cols
        }

        return row;
    }

// 2D recursion, to use rows and columns. The math for figuring out middle values by addition
// are valid candidates for recursion
// Row number is given already, we just calculate the value for cols by recursion
    private int pascalValue(int row, int col) {
        if (col == 0 || col == row) { // ************ Imp condition, when row==column. Thanks to it, we do not add 1 explicitly to row
            return 1; // Base case: values at the edges are 1
        } else {
            // Recursive case: sum of values from the previous row
            return pascalValue(row - 1, col - 1) + pascalValue(row - 1, col);// not col+1
        }
    }

    
}

//// OFFICIAL LEETCODE:

class Solution {
    

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            ans.add(getNum(rowIndex, i)); // the value to be added is calculated using DP
        }

        return ans;
    }

    private int getNum(int row, int col) {
        if (row == 0 || col == 0 || row == col) {
            return 1;
        }

        return getNum(row - 1, col - 1) + getNum(row - 1, col); // not col+1
    }
}

// Time: O(2^k), where k: no of cols for which we recursively get the value
// (fan-out)^(height of tree) => fan-out=2 as we depend on 2 cols from prev row; height=no of nodes=n
// But as a special case, we just have n=k
// Space: O(k)

// We can make the solution faster by using DP with memo
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> curr, prev = new ArrayList<>() {
            {
                add(1);
            }
        };

        for (int i = 1; i <= rowIndex; i++) {
            curr = new ArrayList<>(i + 1) {
                {
                    add(1);
                }
            };

            for (int j = 1; j < i; j++) {
                curr.add(prev.get(j - 1) + prev.get(j));
            }

            curr.add(1);

            prev = curr;
        }

        return prev;
    }
}

// Time: O(k^2), where k: no of cols for which we recursively get the value
// Space: O(k)