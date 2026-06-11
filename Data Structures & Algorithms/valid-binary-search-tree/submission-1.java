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
    boolean isValid = true;

    public void dfs(TreeNode root, int min, int max) {
        if(root == null) {
            return;
        }

        if(min >= root.val || root.val >= max) { // duplicates not allowed in BST
            isValid = false;
            return;
        }

      
        dfs(root.left, min, root.val);
        dfs(root.right, root.val, max);
    } 

    public boolean isValidBST(TreeNode root) {
        isValid = true;

        if(root == null) {
            return false;
        }

        dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return isValid;
    }
}
