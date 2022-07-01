package ru.sber.Collections1;
import java.util.NoSuchElementException;

public class ArrayListTest {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        try {
            System.out.println(String.format("Является ли список пустым: %s",arrayList.isEmpty()));
//заполнение списка
            arrayList.add(0);
            arrayList.add(1);
            arrayList.add(2);
            arrayList.add(3);
            arrayList.add(5);
            arrayList.add(1,5);
            System.out.println(arrayList.toString());
            System.out.println(String.format("Является ли список пустым: %s",arrayList.isEmpty()));

            arrayList.remove(3);
            System.out.println(String.format("Список с удаленным элементом: %s",arrayList.toString()));

            System.out.println(String.format("Наличие элемента 5 в списке: %s",arrayList.contains(5)));
            System.out.println(String.format("Наличие элемента 7 в списке: %s",arrayList.contains(7)));

            arrayList.set(3,7);
            System.out.println(String.format("Список с измененным элементом: %s",arrayList.toString()));

            System.out.println(String.format("Получение элемента с индексом 2: %s",arrayList.get(2)));


            System.out.println(String.format("Первое вхождение элемента 5: %s",arrayList.indexOf(5)));
            System.out.println(String.format("Первое вхождение элемента 8: %s",arrayList.indexOf(8)));

            System.out.println(String.format("Последнее вхождение элемента 5: %s",arrayList.lastIndexOf(5)));
            System.out.println(String.format("Последнее вхождение элемента 8: %s",arrayList.lastIndexOf(8)));

            System.out.println(String.format("Вывод части списка: %s",arrayList.subList(0, 2)));
            System.out.println(arrayList.toString());
            System.out.println(String.format("Размер списка: %s",arrayList.size()));

            System.out.println(String.format("Элемент с индексом 3: %s",arrayList.get(3)));

            arrayList.set(2,2);
            System.out.println(String.format("Список с измененным элементом: %s",arrayList.toString()));

            arrayList.clear();
            System.out.print("Очищенный список: ");
            System.out.println(arrayList.toString());

            System.out.println(String.format("Элемент с индексом 5: %s",arrayList.get(5)));

        } catch (NullPointerException exceptionNullPointer) {
            System.out.println(exceptionNullPointer.getMessage());
            exceptionNullPointer.printStackTrace();
        }
    }
}
