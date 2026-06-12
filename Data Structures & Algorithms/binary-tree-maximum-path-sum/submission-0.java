/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftSum = dfs(root.left);

        if(leftSum < 0) {
            leftSum = 0;
        }

        int rightSum = dfs(root.right);

        if(rightSum < 0) {
            rightSum = 0;
        }

        int currentSum = root.val + leftSum + rightSum;

        maxSum = Math.max(maxSum, currentSum);

        return root.val + Math.max(leftSum, rightSum);
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
}
