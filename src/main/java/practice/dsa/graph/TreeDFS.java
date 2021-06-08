package practice.dsa.graph;

public class TreeDFS {
    static void traverseTree(Node node) {
        System.out.println("InOrder traversal");
        inOrderTreeTraversal(node);
        System.out.println("PreOrder traversal");
        preOrderTreeTraversal(node);
        System.out.println("PostOrder traversal");
        postOrderTreeTraversal(node);
    }

    static void inOrderTreeTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTreeTraversal(node.left);
        System.out.println(node.data);
        inOrderTreeTraversal(node.right);
    }

    static void preOrderTreeTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTreeTraversal(node.left);
        preOrderTreeTraversal(node.right);
    }

    static void postOrderTreeTraversal(Node node) {
        if (node == null) {
            return;
        }
        postOrderTreeTraversal(node.left);
        postOrderTreeTraversal(node.right);
        System.out.println(node.data);
    }
}
