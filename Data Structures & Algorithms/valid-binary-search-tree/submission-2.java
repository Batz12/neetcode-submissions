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
    public boolean dfs(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }

        if(min >= root.val || root.val >= max) { // duplicates not allowed in BST
            return false;
        }

      
        boolean isLeftValidBST = dfs(root.left, min, root.val);
        boolean isRightValidBST = dfs(root.right, root.val, max);

        return isLeftValidBST && isRightValidBST;
    } 

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return false;
        }

        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
