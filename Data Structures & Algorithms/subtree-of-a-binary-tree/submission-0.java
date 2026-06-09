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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) { 
            return true;
        } else if (p == null || q == null) { 
            return false; 
        } 
        
        boolean isLeftSame = isSameTree(p.left, q.left); 
        boolean isMidSame = (p.val == q.val); 
        boolean isRightSame = isSameTree(p.right, q.right); 
        return (isLeftSame && isMidSame && isRightSame);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) {
            return true;
        }

        if(root == null) {
            return false;
        }

        boolean isRootSame = isSameTree(root, subRoot);

        if(isRootSame) {
            return true;
        }

        boolean isLeftRootSame = isSubtree(root.left, subRoot);
        
        boolean isRightRootSame = isSubtree(root.right, subRoot);

        return (isLeftRootSame || isRightRootSame);
    }
}
