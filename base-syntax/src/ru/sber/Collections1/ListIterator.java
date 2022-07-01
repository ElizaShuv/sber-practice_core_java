package ru.sber.Collections1;
import java.util.*;
public class ListIterator<E> implements Iterator<E>{
    private List<E> List;
    private int i;

    public ListIterator(List<E> List) {
        this.List = List;
        this.i = 0;
    }

    @Override
    public boolean hasNext() {
        return i < List.size();
    }

    @Override
    public E next() throws NoSuchElementException {
        if (!hasNext()) {throw new NoSuchElementException("Пустой список");}
        i++;
        return(List.get(i - 1));

    }

}
