package reflection;

import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestAnimalClass {

    private static final Animal ANIMAL = new Animal("Кот", "Персик", 6.5);
    private static final Class<?> TEST_CLASS = ANIMAL.getClass();

    @Test
    public void firstTest() throws Exception {
        Field privateField = TEST_CLASS.getDeclaredField("weight");
        privateField.setAccessible(true);
        privateField.setDouble(ANIMAL, 6.8);
        System.out.println(privateField.getDouble(ANIMAL));
        System.out.println(TEST_CLASS.getDeclaredField("type").getName());
        System.out.println(TEST_CLASS.getDeclaredField("name").getType());
    }

    @Test
    public void secondTest() throws Exception {
        Method privateMethod = TEST_CLASS.getDeclaredMethod("weightInf");
        privateMethod.setAccessible(true);
        System.out.println(privateMethod.invoke(ANIMAL));

        for (Method m : TEST_CLASS.getSuperclass().getDeclaredMethods()) {
            System.out.println("Метод: " + m.getName());
        }

        Class[] exceptions = privateMethod.getExceptionTypes();
        for (Class e : exceptions) {
            System.out.println("Исключение: " + e.getSimpleName());
        }
    }

    @Test
    public void thirdTest() throws Exception {
        Constructor<Animal> publicConstructor = Animal.class.getDeclaredConstructor(String.class, String.class, double.class);
        System.out.println(publicConstructor);

        Constructor<Animal> privateConstructor = Animal.class.getDeclaredConstructor(String.class, double.class);
        privateConstructor.setAccessible(true);
        Animal animal = privateConstructor.newInstance("Пушок", 4.2);

        Class[] types = publicConstructor.getParameterTypes();
        for (Class t : types) {
            System.out.println("Тип: " + t.getName());
        }
    }
}

