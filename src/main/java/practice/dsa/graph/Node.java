package practice.dsa.graph;

public class Node {
    String data;
    Node left;
    Node right;

    public Node(String data) {
        this.data = data;
    }

    public Node(String data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
