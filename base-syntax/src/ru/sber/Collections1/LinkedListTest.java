package ru.sber.Collections1;
import java.util.NoSuchElementException;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        try {
            System.out.println(String.format("Является ли список пустым: %s",linkedList.isEmpty()));
//заполнение списка
            linkedList.add(0);
            linkedList.add(1);
            linkedList.add(2);
            linkedList.add(3);
            linkedList.add(4);
            System.out.println(linkedList.toString());

            System.out.println(String.format("Является ли список пустым: %s",linkedList.isEmpty()));

            System.out.println(String.format("Наличие элемента 5 в списке: %s",linkedList.contains(5)));
            System.out.println(String.format("Наличие элемента 1 в списке: %s",linkedList.contains(1)));

            linkedList.remove(2);
            System.out.println(String.format("Список с удаленным элементом: %s",linkedList.toString()));

            System.out.println(String.format("Первый элемент: %s",linkedList.getFirst()));
            System.out.println(String.format("Последний элемент: %s",linkedList.getLast()));

            System.out.println(String.format("Удаление первого элемента: %s",linkedList.pollFirst()));
            System.out.println(linkedList.toString());
            System.out.println(String.format("Удаление последнего элемента: %s",linkedList.pollLast()));
            System.out.println(linkedList.toString());

            linkedList.addFirst(0);
            linkedList.addLast(1);
            linkedList.addFirst(1);

            System.out.println(String.format("Список с добавленными элементами: %s",linkedList.toString()));

            System.out.println(String.format("Элемент с индексом 1: %s",linkedList.get(1)));

            System.out.println(String.format("Первое вхождение элемента 1: %s",linkedList.indexOf(1)));
            System.out.println(String.format("Первое вхождение элемента 2: %s",linkedList.indexOf(2)));
            System.out.println(String.format("Последнее вхождение элемента 1: %s",linkedList.lastIndexOf(1)));
            System.out.println(String.format("Последнее вхождение элемента 2: %s",linkedList.lastIndexOf(2)));

            System.out.println(String.format("Вывод части списка: %s",linkedList.subList(0, 2)));
            System.out.println(linkedList.toString());
            System.out.println(String.format("Размер списка: %s",linkedList.size()));

            linkedList.clear();
            System.out.print("Очищенный список: ");
            System.out.println(linkedList.toString());

            linkedList.remove(8);
        } catch (NoSuchElementException exceptionNoSuchElement) {
            System.out.println(exceptionNoSuchElement.getMessage());
            exceptionNoSuchElement.printStackTrace();
        } catch (IndexOutOfBoundsException exceptionIndexOutOfBounds) {
            System.out.println(exceptionIndexOutOfBounds.getMessage());
            exceptionIndexOutOfBounds.printStackTrace();
        }
    }
}
