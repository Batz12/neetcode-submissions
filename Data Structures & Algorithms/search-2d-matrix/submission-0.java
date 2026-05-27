class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // First we find the row in which the value will be by checking the 1st num of each row
        int low = 0;
        int high = matrix.length - 1;
        int colSize = matrix[0].length;
        int selectedRow = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int leftVal = matrix[mid][0];
            int rightVal = matrix[mid][colSize - 1];

            if(target >= leftVal && target <= rightVal) {
                selectedRow = mid;
                break;
            } else if (rightVal > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // Now on this row a binary search can be performed
        if(selectedRow == -1) {
            return false;
        } 

        low = 0;
        high = colSize - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(matrix[selectedRow][mid] == target) {
                return true;
            } else if (matrix[selectedRow][mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}
