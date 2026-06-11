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
    int index = 0;
    Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();

    public TreeNode build(int[] preorder, int l, int r) {
        if(l > r) {
            return null;
        }

       int val = preorder[index++];
       TreeNode root = new TreeNode(val);

       int mid = inorderMap.get(val);

       root.left = build(preorder, l, mid - 1);
       root.right = build(preorder, mid + 1, r);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return build(preorder, 0, preorder.length - 1);
    }
}
