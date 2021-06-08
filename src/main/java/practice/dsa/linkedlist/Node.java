package practice.dsa.linkedlist;

public class Node<E> {
    int data;
    Node<E> prev;
    Node<E> next;

    public Node(int data, Node<E> prev, Node<E> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public void push(int data) {
        Node newNode = new Node(data, null, null);
        this.next = newNode;
    }
}
