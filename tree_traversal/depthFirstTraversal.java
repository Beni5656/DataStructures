public class depthFirstTraversal<T extends Comparable<T>> {
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

    public depthFirstTraversal() {
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
        } else if (value.compareTo(current.value) > 0) {
            if (current.right == null) {
                current.right = new Node<>(value);
            } else {
                insertRecursive(current.right, value);
            }
        } else {
            System.out.println("Value already exists in the tree");
        }
    }

    public void inOrderTraversal(Node<T> current) {
        if (current == null) {
            return;
        }
        inOrderTraversal(current.left);
        System.out.println(current.value);
        inOrderTraversal(current.right);
    }

    public void preOrderTraversal(Node<T> current) {
        if (current == null) {
            return;
        }
        System.out.println(current.value);
        preOrderTraversal(current.left);
        preOrderTraversal(current.right);
    }

    public void postOrderTraversal(Node<T> current) {
        if (current == null) {
            return;
        }
        postOrderTraversal(current.left);
        postOrderTraversal(current.right);
        System.out.println(current.value);
    }

    public static void main(String[] args) {
        depthFirstTraversal<Integer> tree = new depthFirstTraversal<>();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(18);
        tree.inOrderTraversal(tree.root);
        tree.preOrderTraversal(tree.root);
        tree.postOrderTraversal(tree.root);
    }
}