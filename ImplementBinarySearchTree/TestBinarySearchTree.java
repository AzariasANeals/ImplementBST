import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestBinarySearchTree {
    private BinarySearchTree bst;

    @Before
    public void setUp() {
        bst = new BinarySearchTree();
    }

    @Test
    public void testInsertionAndSearch() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        // Check that inserted values exist
        assertTrue(bst.search(5));
        assertTrue(bst.search(3));
        assertTrue(bst.search(7));
        assertTrue(bst.search(2));
        assertTrue(bst.search(4));
        assertTrue(bst.search(6));
        assertTrue(bst.search(8));

        // Check a non-existent value
        assertFalse(bst.search(10));
    }

    @Test
    public void testDeletionLeafNode() {
        bst.insert(5);
        bst.insert(3);
        bst.delete(3);

        assertFalse(bst.search(3)); // deleted
        assertTrue(bst.search(5));  // still exists
    }

    @Test
    public void testDeletionNodeWithOneChild() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(2); // left child of 3
        bst.delete(3);

        assertFalse(bst.search(3));
        assertTrue(bst.search(2)); // child promoted
        assertTrue(bst.search(5));
    }

    @Test
    public void testDeletionNodeWithTwoChildren() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(6);
        bst.insert(8);

        bst.delete(7);

        assertFalse(bst.search(7));
        assertTrue(bst.search(6));
        assertTrue(bst.search(8));
        assertTrue(bst.search(5));
    }

    @Test
    public void testInOrderTraversal() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        int[] expected = {2, 3, 4, 5, 6, 7, 8};
        int[] result = bst.inorderTraversalArray();

        assertArrayEquals(expected, result);
    }
}
