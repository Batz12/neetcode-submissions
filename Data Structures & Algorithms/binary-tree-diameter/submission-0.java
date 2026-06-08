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
    int max = 0;

    public int getHeight(TreeNode root) {
         if(root == null) {
            return 0;
        }

        int left =  getHeight(root.left);
        int right = getHeight(root.right);

        int diameter = (left + right);

        max = Math.max(max, diameter);

        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
       getHeight(root);
       return max;
    }
}
