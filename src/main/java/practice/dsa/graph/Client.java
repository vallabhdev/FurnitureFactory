package practice.dsa.graph;

import java.util.Arrays;

public class Client {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Graph.adjacencyMatrix()));

        System.out.println(GraphDFS.traverse(Graph.createGraph(), "Bob"));
//        "[Bob, Rob, Maria, Alice, Mark]"
        System.out.println(GraphBFS.traverse(Graph.createGraph(), "Bob"));
//        "[Bob, Alice, Rob, Mark, Maria]"
    }

    public static void main1(String[] args) {
        Node sampleTree = createSampleTree();
        TreeBFS.traverseTree(sampleTree);
        TreeDFS.traverseTree(sampleTree);
    }

    private static Node createSampleTree() {
        return new Node("a",
                new Node("b", new Node("c"), new Node("d")),
                new Node("e", new Node("f"), new Node("g", new Node("h"), null)));
    }
}
