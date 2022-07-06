package datastructures.tree;

public class BinaryTree {

    public static void main(String[] args) {
        BinaryTree bi = new BinaryTree();
        bi.put(3);
        bi.put(1);
        bi.put(2);

        bi.inOrder(bi.getRoot());

    }

    class Node {
        public int data;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            data = value;
            left = null;
            right = null;
            parent = null;
        }
    }

    private Node root;

    public BinaryTree() {
        root = null;
    }

    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (key < current.data) {
                if (current.left == null)
                    return current;
                current = current.left;
            } else if (key > current.data) {
                if (current.right == null)
                    return current;
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    public void put(int value) {
        Node newNode = new Node(value);
        if (root == null)
            root = newNode;
        else {
            Node parent = find(value);
            if (value < parent.data) {
                parent.left = newNode;
                parent.left.parent = parent;
                return;
            } else {
                parent.right = newNode;
                parent.right.parent = parent;
                return;
            }
        }
    }

    public void print() {
        System.out.println(root.data);
        System.out.println(root.left.data);
        System.out.println(root.left.right.data);
    }

    public Node findSuccessor(Node n) {
        if (n.right == null)
            return n;
        Node current = n.right;
        Node parent = n.right;
        while (current != null) {
            parent = current;
            current = current.left;
        }
        return parent;
    }

    public Node getRoot() {
        return root;
    }

    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.left);
            System.out.println(localRoot.data + " ");
            inOrder(localRoot.right);
        }
    }

    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.println(localRoot.data + " ");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }

    public void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.println(localRoot.data + " ");
        }
    }
}
