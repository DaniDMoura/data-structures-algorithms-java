package dev.algorithms.binarySearchTree;

public class BinarySearchTree {

    private Node root;

    public void insert(Node node) {
        root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node) {
        if (root == null) {
            return node;
        }

        if (node.data < root.data) {
            root.left = insertHelper(root.left, node);
        } else {
            root.right = insertHelper(root.right, node);
        }

        return root;
    }

    public void display() {
        displayHelper(root);
    }

    private void displayHelper(Node root) {
        if (root == null) return;

        displayHelper(root.left);
        System.out.println(root.data);
        displayHelper(root.right);
    }


    public boolean search(int data) {
        return searchHelper(root, data);
    }

    private boolean searchHelper(Node root, int data) {
        if (root == null) return false;
        if (root.data == data) return true;

        if (data < root.data) {
            return searchHelper(root.left, data);
        } else {
            return searchHelper(root.right, data);
        }
    }


    public void remove(int data) {
        root = removeHelper(root, data);
    }

    private Node removeHelper(Node root, int data) {
        if (root == null) return null;

        if (data < root.data) {
            root.left = removeHelper(root.left, data);
        } else if (data > root.data) {
            root.right = removeHelper(root.right, data);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            else if (root.right != null) {
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            }
            else {
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }

        return root;
    }

    private int successor(Node root) {
        Node current = root.right;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    private int predecessor(Node root) {
        Node current = root.left;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }
}
