package practice.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GraphPractice {
    private LinkedList<Integer>[] graph;

    public GraphPractice(Integer size) {
        this.graph = new LinkedList[size];
    }

    public static void main(String[] args) {
        GraphPractice gp = new GraphPractice(4);

    }
}
