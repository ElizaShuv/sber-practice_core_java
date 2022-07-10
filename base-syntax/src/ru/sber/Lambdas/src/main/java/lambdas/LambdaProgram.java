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

    public static void main(String[] args) {
        String str1 = "World";
        String str2 = "Hello";

        getMessage(() -> {
            System.out.println(ItFunctionalInterface.S);
            return ItFunctionalInterface.S;
        });

        getMessage((s) -> {
            System.out.println(s + str1);
            return s + str1;
        });
        changeWord(str1, str2, (s1, s2) -> {
            String s3 = s2 + " " + s1;
            System.out.println(s3);
            return s3;
        });
    }
}