package lambdas;

public class LambdaProgram {

    public static void getMessage(ItFunctionalInterface message) {
        message.out();
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
        });

        getMessage((s) -> {
            System.out.println(s+str1);
            return s+str1;
        });
        changeWord(str1, str2, (s1,s2) -> {
            String s3 = s2 + " " + s1;
            System.out.println(s3);
            return s3;
        });

        ItFunctionalInterface itFunctionalInterface = new ItFunctionalInterface() {
            @Override
            public void out() {
                System.out.println("It function interface");
            }
        };
        System.out.println();
        itFunctionalInterface.out();

        MessageFunctionInterface messageFunctionInterface = new MessageFunctionInterface() {
            @Override
            public String get(String mes) {
                return MessageFunctionInterface.S + mes;
            }
        };

        System.out.println(messageFunctionInterface.get(str1));

        ChangeFunctionInterface changeFunctionInterface = new ChangeFunctionInterface() {
            @Override
            public String str(String s1, String s2) {
                return s2 + " " + s1;
            }
        };

        System.out.println(changeFunctionInterface.str(str1, str2));

    }
}