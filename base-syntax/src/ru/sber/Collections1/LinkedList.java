package ru.sber.Collections1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E>, Deque<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(E item) {
        Node firstNode = first;
        while (firstNode != null) {
            if (firstNode.item.equals(item)) {
                return true;
            }
            firstNode = firstNode.next;
        }
        return false;
    }

    @Override
    public boolean add(E item) {
        addLast(item);
        return true;
    }

    @Override
    public boolean remove(E item) {
        boolean foundElement = false;
        Node firstNode = first;
        while (firstNode != null) {
            if (firstNode.item.equals(item)) {
                if (firstNode.prev == null) {
                    first = firstNode.next;
                } else {
                    firstNode.prev.next = firstNode.next;
                }
                if (firstNode.next == null) {
                    last = firstNode.prev;
                } else {
                    firstNode.next.prev = firstNode.prev;
                }
                size--;
                foundElement = true;
            }
            firstNode = firstNode.next;
        }
        return foundElement;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void addFirst(E item) {
        Node<E> node = new Node<>();
        node.item = item;
        if (size == 0) {
            add(item);
        } else {
            node.next = first;
            first.prev = node;
            first = node;
            size++;
        }
    }

    @Override
    public void addLast(E item) {
        add(size, item);
    }

    @Override
    public E getFirst() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Пустой список");
        }
        return first.item;
    }

    @Override
    public E getLast() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Пустой список");
        }
        return last.item;
    }

    @Override
    public E pollFirst() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Пустой список");
        }
        Node<E> firstNode = first;
        removeFirst();
        return firstNode.item;
    }

    @Override
    public E pollLast() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Пустой список");
        }
        Node<E> lastNode = last;
        removeLast();
        return lastNode.item;
    }

    @Override
    public E removeFirst() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Пустой список");
        } Node<E> firstNode = first;
        if (first.next != null) {
            first.next.prev = null;
        }
        first = first.next;
        size--;
        return firstNode.item;
    }

    @Override
    public E removeLast() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Пустой список");
        } Node<E> lastNode = last;
        if (last.prev != null) {
            last.prev.next = null;
        }
        last = last.prev;
        size--;
        return lastNode.item;
    }

    @Override
    public void add(int index, E item) {
        Node<E> node = new Node<>();
        node.item = item;

        if (first == null) {
            first = node;
        }
        else {
            last.next = node;
            node.prev = last;
        }
        last = node;
        size++;
    }

    @Override
    public void set(int index, E item) {
        Node firstNode = first;
        int i = 0;
        if (index == size){
            addLast(item);
        } else {
            while(i < index){
                i++;
                firstNode = firstNode.next;
            }
            firstNode.item = item;
        }
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Выход за пределы списка");
        }
        Node<E> firstNode = first;
        int i = 0;
        while ((firstNode != null) && (i < index)) {
            firstNode = firstNode.next;
            i++;
        }
        return firstNode.item;
    }

    @Override
    public int indexOf(E item) {
        int i = 0;
        Node<E> firstNode = first;
        while (firstNode != null) {
            if (firstNode.item.equals(item)) {
                return i;
            }
            firstNode = firstNode.next;
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E item) {
        int i = size - 1;
        Node<E> ptr = last;
        while (ptr != null) {
            if (ptr.item.equals(item)) {
                return i;
            }
            ptr = ptr.prev;
            i--;
            break;
        }
        return -1;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Выход за пределы списка");
        } else {
            int i = 0;
            Node<E> firstNode = first;
            while ((firstNode != null) && (i < index)) {
                firstNode = firstNode.next;
                i++;
            }
            if (firstNode.prev == null) {
                first = firstNode.next;
            } else {
                firstNode.prev.next = firstNode.next;
            }
            if (firstNode.next == null) {
                last = firstNode.prev;
            } else {
                firstNode.next.prev = firstNode.next;
            }
            size--;
            return firstNode.item;
        }
    }

    @Override
    public List<E> subList(int from, int to) throws IndexOutOfBoundsException {
        if ((from >= size) || (to - 1 >= size)) {
            throw new IndexOutOfBoundsException("Выход за пределы списка");
        } else {
            List<E> subLinkedList = new LinkedList<>();
            Node<E> obj = first;
            int i = 0;
            while (obj != null) {
                if ((i >= from) && (i < to)) {
                    subLinkedList.add(obj.item);
                }
                obj = obj.next;
                i++;
            }
            return subLinkedList;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<>(this);
    }

    private String print() {
        String elements = "";
        Node<E> firstNode = first;
        int i = 0;
        while ((firstNode != null) && (i < size)) {
            elements += firstNode.item;
            if (i + 1 < size) {
                elements += " ";
            }
            firstNode = firstNode.next;
            i++;
        }
        return elements;
    }

    @Override
    public String toString() {
        return  print();
    }
}