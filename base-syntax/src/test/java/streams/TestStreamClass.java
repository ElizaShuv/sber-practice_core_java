package streams;

import org.testng.annotations.Test;

import java.util.*;

import static org.junit.Assert.assertNotNull;
import static streams.StreamsClass.*;

public class TestStreamClass {
    @Test
    public void listTest() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        System.out.print("Исходный список: ");
        list.stream().forEach(x -> System.out.print(x + " "));
        System.out.println();
        list = deleteElem(list);
        System.out.println("Список с тремя удаленными элементами: " + list);
        list = changeList(list);
        System.out.println("Список с изменными четными и нечетными элементами: " + list);
        System.out.println("Среднее арифметическое: " + getAverage(list));
    }

    @Test
    public void setTest() {
        Set<String> set = new HashSet<>();
        set.add("oneAaaaaaaa");
        set.add("two");
        set.add("three");
        set.add("fourAaaaaaaaaaa");
        set.add("fiveAaaaaaa");
        set.add("six");
        set.add("seven");
        set.add("eightAaaaaaa");
        set.add("nine");
        set.add("ten");

        Map<String, String> map = longWords(set);
        map.entrySet().forEach(System.out::println);
    }

    @Test
    public void mapTest() {
        Map<String, String> map2 = new HashMap<>();
        map2.put("first", "one");
        map2.put("second", "two");
        map2.put("third", "three");
        map2.put("forth", "four");
        map2.put("fifth", "five");

        List<String> KeyAndValue = getKeyAndValue(map2);
        System.out.println(KeyAndValue);
        List<String> KeyAndValue2 = getKeyAndValue2(map2);
        System.out.println(KeyAndValue2);
    }

    @Test
    public void optionalTest() {
        assertNotNull(optionalMethod(new StreamsClass()));
    }
}


