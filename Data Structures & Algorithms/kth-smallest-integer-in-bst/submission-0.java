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
    int cnt = 0;
    int value = 0;

    public void getKthNode(TreeNode root, int k) {
        if(root == null) {
            return;
        }

        getKthNode(root.left, k);

        cnt++;
        if(cnt == k) {
            value = root.val;
            return;
        }
        
        getKthNode(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return 0;
        }

        cnt = 0;
        value = 0;
        getKthNode(root, k);
        return value;
    }
}
