package ru.sber.Collections1;
import java.util.*;
public class ListIterator implements Iterator<Object>{
    private List List;
    private int i;

    public ListIterator(List List) {
        this.List = List;
        this.i = 0;
    }

    @Override
    public boolean hasNext() {
        return i < List.size();
    }

    @Override
    public Object next() throws NoSuchElementException {
        if (!hasNext()) {throw new NoSuchElementException("Пустой список");}
        i++;
        return(List.get(i - 1));

    }

}
