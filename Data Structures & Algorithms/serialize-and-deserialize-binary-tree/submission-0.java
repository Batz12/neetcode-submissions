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

public class Codec {
    int index = 0;
    
    public String dfs(TreeNode root) {
        if(root == null) {
            return "N";
        }

        StringBuilder sb = new StringBuilder();

        // pre order
        sb.append(root.val + ",");
        sb.append(dfs(root.left) + ",");
        sb.append(dfs(root.right));
        return sb.toString();
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return dfs(root);
    }

    public TreeNode buildTree(String[] nodes) {
        if(nodes[index].equals("N")) {
            index++;
            return null;
        }

        int val = Integer.parseInt(nodes[index]);
        TreeNode root = new TreeNode(val);
        index++;

        root.left = buildTree(nodes);
        root.right = buildTree(nodes);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return buildTree(nodes);
    }
}
