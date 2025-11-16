package datastructure;

public class BinarySearchTree {
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }
    Node root = null;

    public void insert(int data) {
        root = insertRec(root , data);
    }
    public Node insertRec(Node node , int data) {
        if(node == null) {
            return new Node(data);
        }
        else if(data > node.data) {
            node.right = insertRec(node.right , data);
        } else {
            node.left = insertRec(node.left , data);
        }
        return node;
    }
    public void inorder() {
        inorder(root);
    }
    private void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.data+"->");
            inorder(root.right);
        }
    }

    static void main() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(11);
        bst.insert(12);

        bst.inorder();
        System.out.println();
        bst.insert(7);
        bst.insert(8);
        bst.insert(9);
        bst.insert(1);

        bst.inorder();
        System.out.println();
    }
}
