package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsClass {

    public static List<Integer> deleteElem(List<Integer> list) {
        list = list
                .stream()
                .limit(list.size() - 3)
                .collect(Collectors.toList());
        return list;
    }

    public static List<Integer> changeList(List<Integer> list) {
        list = list
                .stream()
                .map(x -> {
                    if (x % 2 == 0) x = x + 5;
                    else x = x - 5;
                    return x;
                })
                .collect(Collectors.toList());
        return list;
    }

    public static double getAverage(List<Integer> list) {
        OptionalDouble average = list.stream().mapToDouble(x -> x).average();
        if (average.isPresent()) {
            return average.getAsDouble();
        } else {
            return 0;
        }
    }

    public static Map<String, String> longWords(Set<String> set) {
        return set
                .stream()
                .filter(x -> x.length() > 10)
                .collect(Collectors.toMap(Function.identity(), Function.identity()));
    }

    public static List<String> getKeyAndValue(Map<String, String> map) {
        return map
                .entrySet()
                .stream()
                .map(x -> x.getKey() + " == " + x.getValue())
                .collect(Collectors.toList());
    }

    public static List<String> getKeyAndValue2(Map<String, String> map) {
        return map
                .entrySet()
                .stream()
                .flatMap(x -> Stream.of(x.getKey(), x.getValue()))
                .collect(Collectors.toList());
    }

    public static StreamsClass optionalMethod(StreamsClass streamsClass) {
        return Optional.ofNullable(streamsClass).orElseGet(StreamsClass::new);
    }
}


