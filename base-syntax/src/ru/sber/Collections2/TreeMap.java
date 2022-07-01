package ru.sber.Collections2;
import ru.sber.Collections1.*;


public class TreeMap<K,V> implements Map<K,V> {

    private int size;
    private Node<Entry<K,V>> nodeRoot;
    private boolean searchValue = false;

    public TreeMap() {
        nodeRoot = null;
        size = 0;
    }

    private K getKey(Node<Entry<K,V>> node) {
        return node.getValue().getKey();
    }


    private V getValue(Node<Entry<K,V>>  node) {
        return node.getValue().getValue();
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
    public boolean containsKey(K key) {
        searchValue = false;
        return searchKey(nodeRoot, key);
    }

    private boolean searchKey(Node<Entry<K,V>>  child, K key) {
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
    public boolean containsValue(V value) {
        searchValue = false;
        return searchValue(nodeRoot, value);

    }

    private boolean searchValue(Node<Entry<K,V>>  child, V value) {
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
    public V get(K key) {
        Node<Entry<K,V>>  child = nodeRoot;
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
    public Entry<K,V>  put(K key, V value) {
        Node<Entry<K,V>>  newNode = new Node<>(new Entry<>(key, value));
        if (nodeRoot == null) {
            size++;
            nodeRoot = newNode;
        } else {
            Node<Entry<K,V>>  parent;
            Node<Entry<K,V>>  child = nodeRoot;
            while (true) {
                parent = child;
                if (getKey(child).equals(key)) {
                    child.setValue(new Entry<>(key, value));
                    return newNode.getValue();
                } else if (key.hashCode() < getKey(child).hashCode()) {
                    child = child.getLeft();
                    if (child == null) {
                        parent.setLeft(newNode);
                        size++;

                        return  newNode.getValue();
                    }
                } else {
                    child = child.getRight();
                    if (child == null) {
                        parent.setRight(newNode);
                        size++;
                        return  newNode.getValue();
                    }
                }
            }
        }
        return newNode.getValue();
    }

    @Override
    public V remove(K key) {
        Node<Entry<K,V>> currentNode = nodeRoot;
        Node<Entry<K,V>> parentNode = nodeRoot;

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
            Node<Entry<K,V>> heir = replaceNode(currentNode);
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

    private Node<Entry<K,V>> replaceNode(Node<Entry<K,V>> node) {
        Node<Entry<K,V>> heirNode = node;
        Node<Entry<K,V>> curNode = node.getRight();
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
    public Collection<V> values() {
        ArrayList<V> arrayList = new ArrayList<>();
        addValue(nodeRoot, arrayList);
        return arrayList;
    }

    private void addValue(Node<Entry<K,V>> child, ArrayList<V> arrayList) {
        arrayList.add(getValue(child));
        if (child.getLeft() != null) {
            addValue(child.getLeft(), arrayList);
        }
        if (child.getRight() != null) {
            addValue(child.getRight(), arrayList);
        }
    }

    @Override
    public Collection<K> keySet() {
        ArrayList<K> arrayList = new ArrayList<>();
        addKey(nodeRoot, arrayList);
        return arrayList;
    }

    private void addKey(Node<Entry<K,V>> child, ArrayList<K> list) {
        list.add(getKey(child));
        if (child.getLeft() != null) {
            addKey(child.getLeft(), list);
        }
        if (child.getRight() != null) {
            addKey(child.getRight(), list);
        }
    }

    @Override
    public Collection<Entry<K,V>> entrySet() throws NullPointerException  {
        ArrayList<Entry<K,V>> arrayList = new ArrayList<>();
        if (size==0) throw new NullPointerException("Ошибка. Дерево пустое");
        addEntry(nodeRoot, arrayList);
        return arrayList;
    }

    private void addEntry(Node<Entry<K,V>> child, ArrayList<Entry<K,V>> list) {

        list.add(child.getValue());

        if (child.getLeft() != null)
            addEntry(child.getLeft(), list);

        if (child.getRight() != null)
            addEntry(child.getRight(), list);
    }
}