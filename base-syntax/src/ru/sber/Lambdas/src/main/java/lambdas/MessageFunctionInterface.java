package lambdas;
@FunctionalInterface
public interface MessageFunctionInterface<T> {
    String S = "Message: ";
    T get(String mes);
}
