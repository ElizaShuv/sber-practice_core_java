package lambdas;

public class LambdaProgram {

    public static void getMessage(ItFunctionalInterface message) {
        message.out();
    }

    public static void getMessage(MessageFunctionInterface<String> message) {
        message.get(MessageFunctionInterface.S);
    }

    public static void changeWord(String s1, String s2, ChangeFunctionInterface word) {
        word.str(s1, s2);
    }

}