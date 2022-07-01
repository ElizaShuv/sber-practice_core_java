package ru.sber.Collections2;

import java.util.NoSuchElementException;

public class TestTreeMap {
    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap<>();
try {

        System.out.println("Дерево пустое: " + treeMap.isEmpty());
        treeMap.put("1", "Один");
        treeMap.put("2", "Два");
        treeMap.put("3", "Три");
        treeMap.put("4", "Четыре");


        System.out.print("Вывод дерева после добавления элементов:");
        for (Entry<String,String> element : treeMap.entrySet()) {
            System.out.print(element);
        }

        System.out.println("\nДерево пустое: " + treeMap.isEmpty());

        System.out.println("Размер дерева: " + treeMap.size());

        System.out.println("Наличие значения с ключом '1': " + treeMap.containsKey("1"));
        System.out.println("Наличие значения с ключом '5': " + treeMap.containsKey("5"));

        System.out.println("Наличие ключа значения 'Два': " + treeMap.containsValue("Два"));
        System.out.println("Наличие ключа значения 'Пять': " + treeMap.containsValue("Пять"));

        System.out.println("Получения значения с ключом '3': " + treeMap.get("3"));
        System.out.println("Получения значения с ключом '7': " + treeMap.get("7"));

        treeMap.remove("1");

        System.out.print("Вывод элементов дерева после удаления элемента с ключом '1':");
        for (Entry<String,String>  element : treeMap.entrySet()) {
            System.out.print(element);
        }

        System.out.println("\nВывод пар ключ - значение: " + treeMap.entrySet());
        System.out.println("Вывод списка ключей: " + treeMap.keySet());
        System.out.println("Вывод списка значений: " + treeMap.values());

        treeMap.clear();
        System.out.println("Размер дерева после очистки = " + treeMap.size());

        System.out.println("Вывод дерева после очистки: ");
        for (Entry<String,String>  element : treeMap.entrySet()) {
            System.out.println(element);
        }
        }catch (NullPointerException exceptionNullPointer) {
            System.out.println(exceptionNullPointer.getMessage());
            exceptionNullPointer.printStackTrace();
        }
    }
}