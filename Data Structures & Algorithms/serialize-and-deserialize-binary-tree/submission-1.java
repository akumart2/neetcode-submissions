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
    private static final String NULL_MARKER = "#";
    private static final String DELIMETER = ",";
    private int index = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // Run preorder traversal and serialize. Mark null children as # explicitly.
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL_MARKER).append(DELIMETER);
            return;
        }

        sb.append(root.val).append(DELIMETER);
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //System.out.println(data);
        String[] nodeValues = data.split(DELIMETER);
        return dfsDeserialize(nodeValues);
    }

    private TreeNode dfsDeserialize(String[] nodeValues) {
        if (nodeValues[index].equals(NULL_MARKER)) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodeValues[index++]));
        node.left = dfsDeserialize(nodeValues);
        node.right = dfsDeserialize(nodeValues);
        return node;
    }
}
