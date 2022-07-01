package ru.sber.Collections2;
import ru.sber.Collections1.*;

import java.util.Arrays;

public class TreeMap implements Map {

    private int size;
    private Node nodeRoot;
    private boolean searchValue = false;

    public TreeMap() {
        nodeRoot = null;
        size = 0;
    }

    private Object getKey(Node node) {
        return ((Entry) node.getValue()).getKey();
    }


    private Object getValue(Node node) {
        return ((Entry) node.getValue()).getValue();
    }



    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        searchValue = false;
        return searchKey(nodeRoot, key);
    }

    private boolean searchKey(Node child, Object key) {
        if (key.equals(getKey(child))) {
            searchValue = true;
        }
        if (child.getRight() != null && !searchValue) {
            searchKey(child.getRight(), key);
        }
        if (child.getLeft() != null && !searchValue) {
            searchKey(child.getLeft(), key);
        }
        return searchValue;
    }

    @Override
    public boolean containsValue(Object value) {
        searchValue = false;
        return searchValue(nodeRoot, value);

    }

    private boolean searchValue(Node child, Object value) {
        try {
            if (getValue(child).equals(value)) {
                searchValue = true;
            }
        } catch (NullPointerException ex) {
            if (value == null) {
                searchValue = true;
            }
        }
        if (child.getLeft() != null && !searchValue) {
            searchValue(child.getLeft(), value);
        }
        if (child.getRight() != null && !searchValue) {
            searchValue(child.getRight(), value);
        }
        return searchValue;
    }

    @Override
    public Object get(Object key) {
        Node child = nodeRoot;
        while (true) {
            if (key.equals(getKey(child))) {
                return getValue(child);
            } else if (key.hashCode() < getKey(child).hashCode()) {
                child = child.getLeft();
                if (child == null) {
                    return null;
                }
            } else {
                child = child.getRight();
                if (child == null) {
                    return null;
                }
            }
        }
    }

    @Override
    public Entry put(Object key, Object value) {
        Node newNode = new Node(new Entry(key, value));
        if (nodeRoot == null) {
            size++;
            nodeRoot = newNode;
        } else {
            Node parent;
            Node child = nodeRoot;
            while (true) {
                parent = child;
                if (getKey(child).equals(key)) {
                    child.setValue(new Entry(key, value));
                    return (Entry) newNode.getValue();
                } else if (key.hashCode() < getKey(child).hashCode()) {
                    child = child.getLeft();
                    if (child == null) {
                        parent.setLeft(newNode);
                        size++;

                        return (Entry) newNode.getValue();
                    }
                } else {
                    child = child.getRight();
                    if (child == null) {
                        parent.setRight(newNode);
                        size++;
                        return (Entry) newNode.getValue();
                    }
                }
            }
        }
        return (Entry) newNode.getValue();
    }

    @Override
    public Object remove(Object key) {
        Node currentNode = nodeRoot;
        Node parentNode = nodeRoot;

        boolean isLeft = true;

        while (!getKey(currentNode).equals(key)) {
            parentNode = currentNode;
            if (key.hashCode() < getKey(currentNode).hashCode()) {
                isLeft = true;
                currentNode = currentNode.getLeft();
            } else {
                isLeft = false;
                currentNode = currentNode.getRight();
            }
            if (currentNode == null) {
                return null;
            }
        }

        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            if (currentNode == nodeRoot) {
                nodeRoot = null;
            } else if (isLeft) {
                parentNode.setLeft(null);
            } else {
                parentNode.setRight(null);
            }
        } else if (currentNode.getRight() == null) {
            if (currentNode == nodeRoot) {
                nodeRoot = currentNode.getLeft();
            } else if (isLeft) {
                parentNode.setLeft(currentNode.getLeft());
            } else {
                parentNode.setRight(currentNode.getLeft());
            }
        } else if (currentNode.getLeft() == null) {
            if (currentNode == nodeRoot) {
                nodeRoot = currentNode.getRight();
            } else if (isLeft) {
                parentNode.setLeft(currentNode.getRight());
            } else {
                parentNode.setRight(currentNode.getRight());
            }
        } else {
            Node heir = replaceNode(currentNode);
            if (currentNode == nodeRoot) {
                nodeRoot = heir;
            } else if (isLeft) {
                parentNode.setLeft(heir);
            } else {
                parentNode.setRight(heir);
            }
        }
        size--;
        return getValue(currentNode);
    }

    private Node replaceNode(Node node) {
        Node heirNode = node;
        Node curNode = node.getRight();
        while (curNode != null) {
            heirNode = curNode;
            curNode = curNode.getLeft();
        }
        if (heirNode != node.getRight()) {
            curNode.setLeft(heirNode.getRight());
            heirNode.setRight(node.getRight());
        }
        return heirNode;
    }

    @Override
    public void clear(){
        size = 0;
        nodeRoot = null;
    }

    @Override
    public Collection values() {
        ArrayList arrayList = new ArrayList();
        addValue(nodeRoot, arrayList);
        return arrayList;
    }

    private void addValue(Node child, ArrayList arrayList) {
        arrayList.add(getValue(child));
        if (child.getLeft() != null) {
            addValue(child.getLeft(), arrayList);
        }
        if (child.getRight() != null) {
            addValue(child.getRight(), arrayList);
        }
    }

    @Override
    public Collection keySet() {
        ArrayList arrayList = new ArrayList();
        addKey(nodeRoot, arrayList);
        return arrayList;
    }

    private void addKey(Node child, ArrayList li) {
        li.add(getKey(child));
        if (child.getLeft() != null) {
            addKey(child.getLeft(), li);
        }
        if (child.getRight() != null) {
            addKey(child.getRight(), li);
        }
    }

    @Override
    public Collection entrySet() throws NullPointerException  {
        ArrayList arrayList = new ArrayList();
        if (size==0) throw new NullPointerException("Ошибка. Дерево пустое");
        addEntry(nodeRoot, arrayList);
        return arrayList;
    }

    private void addEntry(Node child, ArrayList li) {

        li.add(child.getValue());

        if (child.getLeft() != null)
            addEntry(child.getLeft(), li);

        if (child.getRight() != null)
            addEntry(child.getRight(), li);
    }
}