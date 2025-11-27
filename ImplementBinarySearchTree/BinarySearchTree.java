import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private TreeNode root;

    // Start with empty tree so root = null.
    public BinarySearchTree() {
        this.root = null;
    }

    // public method called by the user. It passes the root to a recursive helper
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    /**
     *  Base case: if current node is null, create new node
     *  
     *  if value < current node --> recurse to the left child
     *  
     *  if value > current node --> recurse to the right child
     *  
     *  ignore duplicates
     *  
     *  Each recursive call returns the updated node so that the parent can link to it.
     *  
     *  This inserts the value while maintaining BST properties
     */
    private TreeNode insertRecursive(TreeNode node, int value) {
        if (node == null) return new TreeNode(value);
        if (value < node.value) node.left = insertRecursive(node.left, value);
        else if (value > node.value) node.right = insertRecursive(node.right, value);
        // duplicate values ignored
        return node;
    }

    /**
     *  1. Start at root
     *  2. If node is null --> value does not exist
     *  3. If value == nnode.value --> found!
     *  4. Else, recursively go left or right depending on value
     *  
     *  Time Complexity: O(h) where h is height of tree
     *  Balanced BST --> O(log n)
     *  Skewed BST --> O(n)
     */
    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(TreeNode node, int value) {
        if (node == null) return false; // value not found
        if (value == node.value) return true; // value found
        if (value < node.value)
            return searchRecursive(node.left, value); // search left
        else
            return searchRecursive(node.right, value); // search right
    }

    
    /**
     * 1. Start at root and search for the node to delete
     * 2. Node not found: return null.
     * 3. Node found 
     *      - 0 children: return null --> parent disconnects it
     *      - 1 child: return the non-null child -> promotes child
     *      - 2 children:
     *              - Find the in-order successor (minValue of right subtree)
     *              - Replace the node's value with successor value
     *              - Delete the successor from the right subtree (recursive call)
     *              
     *  This maintains BST properties after deletion
     */
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private TreeNode deleteRecursive(TreeNode node, int value) {
        if (node == null) return null;
        if (value < node.value) node.left = deleteRecursive(node.left, value);
        else if (value > node.value) node.right = deleteRecursive(node.right, value);
        else {
            // node with one or no child
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;
            // node with two children
            node.value = minValue(node.right);
            node.right = deleteRecursive(node.right, node.value);
        }
        return node;
    }

    private int minValue(TreeNode node) {
        int minv = node.value;
        while (node.left != null) {
            node = node.left;
            minv = node.value;
        }
        return minv;
    }

    /**
     * 1. Left --> Node --> Right traversal
     * 2. Prints values in ascending order because of BST property
     */
    public void inorderTraversal() {
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(TreeNode node) {
        if (node != null) {
            inorderRecursive(node.left);
            System.out.print(node.value + " ");
            inorderRecursive(node.right);
        }
    }

    public int[] inorderTraversalArray() {
        List<Integer> list = new ArrayList<>();
        inorderToList(root, list);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private void inorderToList(TreeNode node, List<Integer> list) {
        if (node != null) {
            inorderToList(node.left, list);
            list.add(node.value);
            inorderToList(node.right, list);
        }
    }

}
