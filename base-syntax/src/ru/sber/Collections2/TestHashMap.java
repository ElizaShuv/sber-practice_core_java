package ru.sber.Collections2;


public class TestHashMap extends HashMap {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        hashMap.put("1", "Один");
        hashMap.put("2", "Два");
        hashMap.put("3", "Три");
        hashMap.put("4", "Четыре");
        System.out.println(hashMap.toString());
        System.out.println("Size = " + hashMap.size());

        System.out.println("Есть значение с ключом '1': " + hashMap.containsKey("1"));
        System.out.println("Есть значение с ключом '5': " + hashMap.containsKey("5"));

        System.out.println("Есть значение 'Два': " + hashMap.containsValue("Два"));
        System.out.println("Есть значение 'Шесть': " + hashMap.containsValue("Шесть"));

        System.out.println("Значение с ключом '1': " + hashMap.get("1"));
        System.out.println("Значение с ключом '5': " + hashMap.get("5"));

        hashMap.remove("2");
        System.out.println("HashMap после удаления значения с ключом '2': " + hashMap.toString());
        System.out.println("Size = " + hashMap.size());

        System.out.println("Вывод всех значений: " + hashMap.values());

        System.out.println("Вывод всех ключей: " + hashMap.keySet());

        System.out.println("Вывод всех пар ключ - значение: " + hashMap.entrySet());

        System.out.println("HashMap пустой: " + hashMap.isEmpty());
        hashMap.clear();
        System.out.println("HashMap пустой: " + hashMap.isEmpty());
        System.out.println("Size = " + hashMap.size());
    }
}