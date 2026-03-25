// Iterate by Levels, from left to right

import java.util.LinkedList;
import java.util.Queue;

public class binaryTreeLevelOrder<T extends Comparable<T>> {
    private Node<T> root;

    private class Node<T> {
        Node right;
        Node left;
        T value;

        public Node(T value) {
            this.value = value;
            this.right = null;
            this.left = null;
        }
    }

    public binaryTreeLevelOrder() {
        this.root = null;
    }

    public void insert(T value) {
        if (this.root == null) {
            this.root = new Node<>(value);
        } else {
            insertRecursive(this.root, value);
        }
    }

    private void insertRecursive(Node<T> current, T value) {
        if (value.compareTo(current.value) < 0) {
            if (current.left == null) {
                current.left = new Node<>(value);
            } else {
                insertRecursive(current.left, value);
            }
        }
        else if (value.compareTo(current.value) > 0) {
            if (current.right == null) {
                current.right = new Node<>(value);
            } else {
                insertRecursive(current.right, value);
            }
        } else {
            // Value already exists in the tree
            System.out.println("Value already exists in the tree");
        }
    }

    public void levelOrderTraversal() {
        if (this.root == null) {
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
        
            System.out.println(current.value);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }   
        }
    }   

    public static void main(String[] args) {
        binaryTreeLevelOrder<Integer> tree = new binaryTreeLevelOrder<>();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(18);
        tree.levelOrderTraversal();
    }
}