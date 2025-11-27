public class TestBinarySearchTreeMain {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        System.out.println("=== Insertion Test ===");
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        System.out.print("In-order traversal: ");
        bst.inorderTraversal(); // should print 2 3 4 5 6 7 8

        System.out.println("\n=== Search Test ===");
        System.out.println("Search 5: " + bst.search(5)); // true
        System.out.println("Search 10: " + bst.search(10)); // false

        System.out.println("\n=== Deletion Test (Leaf Node) ===");
        bst.delete(2); // delete leaf
        System.out.print("In-order after deleting 2: ");
        bst.inorderTraversal(); // should print 3 4 5 6 7 8

        System.out.println("\n=== Deletion Test (Node with One Child) ===");
        bst.delete(3); // node with one child
        System.out.print("In-order after deleting 3: ");
        bst.inorderTraversal(); // should print 4 5 6 7 8

        System.out.println("\n=== Deletion Test (Node with Two Children) ===");
        bst.delete(7); // node with two children
        System.out.print("In-order after deleting 7: ");
        bst.inorderTraversal(); // should print 4 5 6 8

        System.out.println("\n=== Final Tree Search ===");
        System.out.println("Search 4: " + bst.search(4)); // true
        System.out.println("Search 7: " + bst.search(7)); // false
    }
}
