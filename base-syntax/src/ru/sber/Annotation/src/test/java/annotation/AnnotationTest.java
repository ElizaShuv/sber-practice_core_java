package annotation;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnnotationTest {
    @ItAnnotation(command = "firstMethod", queueNumber = 1)
    public String firstMethod() {
        return "Первый метод";
    }

    @ItAnnotation(command = "secondMethod", queueNumber = 2)
    public String secondMethod() {
        return "Второй метод";
    }

    @ItAnnotation(command = "thirdMethod", queueNumber = 3)
    public String thirdMethod() {
        return "Третий метод";
    }

    private Map<Method, Integer> commands() {
        return Arrays
                .stream(this.getClass().getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(ItAnnotation.class))
                .collect(Collectors.toMap(Function.identity(), value -> value.getAnnotation(ItAnnotation.class).queueNumber()));
    }

    private void useMethods(Method method) {
        Map<Method, Integer> map = commands();
        int queueNumber = map.get(method);

        map.forEach((key, value) -> {
            if (value <= queueNumber) {
                try {
                    System.out.println(key.invoke(this));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Test
    public void printCommands() {
        System.out.println(commands());
    }

    @Test
    public void testMethods() throws Exception {
        useMethods(this.getClass().getDeclaredMethod("firstMethod"));
        useMethods(this.getClass().getDeclaredMethod("secondMethod"));
        useMethods(this.getClass().getDeclaredMethod("thirdMethod"));
    }
}
