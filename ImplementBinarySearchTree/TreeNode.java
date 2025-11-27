/**
 * int value -> stores the value of the node
 * 
 * TreeNode left, right -> references to the left and right child nodes
 * 
 * Constructor -> initializes the node with a value and sets both children to null
 * 
 * This class represents one node of the BST. Every node can have 0, 1, or 2 children.
 */

public class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
