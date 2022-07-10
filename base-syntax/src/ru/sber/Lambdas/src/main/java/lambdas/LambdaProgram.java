package lambdas;

public class LambdaProgram {

    public static String getMessage(ItFunctionalInterface message) {
        return message.out();
    }

    public static String getMessage(MessageFunctionInterface<String> message) {
        return message.get(MessageFunctionInterface.S);
    }

    public static String changeWord(String s1, String s2, ChangeFunctionInterface word) {
        return word.str(s1, s2);
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