package ru.sber.Collections1;

public class Node<E> {

    E item;
    Node<E> next;
    Node<E> prev;


    public Node(Node<E> prev, E item, Node<E> next) {
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