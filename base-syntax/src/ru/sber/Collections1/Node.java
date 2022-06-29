package ru.sber.Collections1;

public class Node {

    Object item;
    Node next;
    Node prev;


    public Node(Node prev, Object item, Node next) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }
    public Node() {
        this.prev = null;
        this.item = null;
        this.next = null;
    }
}