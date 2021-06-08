package practice.dsa.graph;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class GraphDFS {

    static Set<String> traverse(Graph graph, String root) {
        LinkedHashSet<String> visited = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : graph.getAdjVertices(vertex)) {
                    stack.push(v.label);
                }
            }
        }
        return visited;
    }
}
