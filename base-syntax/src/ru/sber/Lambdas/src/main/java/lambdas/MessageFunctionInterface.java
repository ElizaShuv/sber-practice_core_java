package lambdas;
@FunctionalInterface
public interface MessageFunctionInterface<T> {
    String s = "Message: ";
    T get(String mes);
}
