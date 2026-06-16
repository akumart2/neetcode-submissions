class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Since rows are sorted one after another it behaves like a big sorted array.
        // We can apply binary search on big array itself using matrix properties.
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = (m * n) - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] < target) start = mid + 1;
            else end = mid - 1;
        }

        return false;
    }
}
