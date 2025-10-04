/** This also works fine, I was able to submit it!!! 
Time: O(n^2) -> why?
We have a loop that runs from 0 to rowIndex => n times
In each loop call, we have a recursion -> that also takes up n (for all the cols)
So, total, n (from outer loop) and n (from recursion)
Total: O(n^2)
*/
class Solution {
    

    public List<Integer> getRow(int rowIndex) {
        Map<String,Integer> map = new HashMap<>(); // I'm putting values in a map, like row,col
        // Better way to improve time complexity is to use an object

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            ans.add(getNum(rowIndex, i,map)); // the value to be added is calculated using DP
        }

        return ans;
    }

    private int getNum(int row, int col, Map<String,Integer> map) {

        if(map.containsKey(row+","+col))
            return map.get(row+","+col);

        if (row == 0 || col == 0 || row == col) {
            return 1;
        }

        map.put(((row-1)+","+(col-1)),getNum(row - 1, col - 1,map));
        map.put((row-1)+","+col,getNum(row - 1, col,map));

        map.put((row+","+col), map.get((row-1)+","+(col-1)) + map.get((row-1)+","+col));

        return map.get(row+","+col);
    }
}






class Solution {
    private Map<RowCol, Integer> cache = new HashMap<>(); // (r,c) => 1; (r,c) => 3; 

     public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            ans.add(getNum(rowIndex, i));
        }
        return ans;
    }

    private int getNum(int row, int col) {
        RowCol rowCol = new RowCol(row, col);

        // Specific Row and Column
        if (cache.containsKey(rowCol)) {
            return cache.get(rowCol);
        }

        int computedVal = (row == 0 || col == 0 || row == col)? 1 : getNum(row - 1, col - 1) + getNum(row - 1, col);
        cache.put(rowCol, computedVal);

        return computedVal;
    }

   
}

private final class RowCol {
    private int row, col;

    public RowCol(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public int hashCode() {
        int result = (int) (row ^ (row >>> 32));
        return (result << 5) - result + (int) (col ^ (col >>> 32)); // 31 * result == (result << 5) - result
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        RowCol rowCol = (RowCol) o;
        return row == rowCol.row && col == rowCol.col;
    }
}

// Time: O(k^2)
// Space: O(k)
// K: No of columns 