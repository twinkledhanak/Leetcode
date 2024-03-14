class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // WE CREATE A VIRTUAL ARRAY, FROM 0 TO M*N-1
        // ROW = IDX // N
        // COLUMN = IDX % N

        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;

        // binary search
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement)
                return true;
            else {
                if (target < pivotElement)
                    right = pivotIdx - 1;
                else
                    left = pivotIdx + 1;
            }
        }
        return false;
    }
}