package practice.dsa.graph;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class GraphBFS {

    static Set<String> traverse(Graph graph, String root) {
        LinkedHashSet<String> visited = new LinkedHashSet<>();
        LinkedList<String> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            for (Vertex v : graph.getAdjVertices(vertex)) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
            }
        }
        return visited;
    }
}
