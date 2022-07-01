package ru.sber.Collections2;

public class Node {
    private Object value;
    private Node left;
    private Node right;

    Node(Object value) {
        this.value = value;
        right = null;
        left = null;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

