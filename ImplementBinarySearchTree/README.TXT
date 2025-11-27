Initial BST after insertions:

Inserted nodes in order:
5, 3, 7, 2, 4, 6, 8

BST Structure
        5
       / \
      3   7
     / \  / \
    2  4 6   8


Root: 5

Left subtree of 5: 3 → with children 2 (left) and 4 (right)

Right subtree of 5: 7 → with children 6 (left) and 8 (right)

In-order traversal: 2 3 4 5 6 7 8 (ascending order)

After deleting leaf node 2
        5
       / \
      3   7
       \  / \
        4 6  8

Node 2 is gone
In-order: 3 4 5 6 7 8

After deleting node with one child (3)
        5
       / \
      4   7
         / \
        6   8


Node 3 had one child (4)
4 replaces 3 as the left child of 5
In-order: 4 5 6 7 8

After deleting node with two children (7)
        5
       / \
      4   8
         /
        6


Node 7 had two children (6 and 8)

Replace 7 with in-order successor → smallest value in right subtree → 8

Delete original 8’s position (already handled)

In-order: 4 5 6 8


Summary Table of Traversals
Operation	In-order Traversal
Initial BST	2 3 4 5 6 7 8
Delete 2	3 4 5 6 7 8
Delete 3	4 5 6 7 8
Delete 7	4 5 6 8