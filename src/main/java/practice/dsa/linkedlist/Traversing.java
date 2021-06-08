package practice.dsa.linkedlist;

import java.util.LinkedList;

public class Traversing {
    public static void main(String[] args) {
        LinkedList<Integer> push = new LinkedList<>();
        push.push(1);
        push.push(2);
        push.push(3);
        push.push(4);
        System.out.println(push);
        LinkedList<Integer> add = new LinkedList<>();
        add.offer(1);
        add.offer(2);
        add.offer(3);
        add.offer(4);
        System.out.println(add);
        System.out.println(add.size());

    }
}
