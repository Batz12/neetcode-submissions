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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        if(root == null) {
            return result;
        }
            
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> levelResult = new ArrayList<Integer>();
            int numberOfNodes = queue.size();

            for(int i = 0; i < numberOfNodes; i++) {
                TreeNode node = queue.poll();
                levelResult.add(node.val);

                if(node.left != null) {
                    queue.add(node.left);
                }
                
                if(node.right != null) {
                    queue.add(node.right);
                }
            
            }

            result.add(levelResult);
        }

        return result;
    }
}
