package lambdas;

public class LambdaProgram {

    public static void getMessage(ItFunctionalInterface message) {
        message.out();
    }

    public static String getMessage(MessageFunctionInterface<String> message) {
        return message.get("");
    }

    public static String changeWord(String s1, String s2, ChangeFunctionInterface word) {
        return word.str(s1, s2);
    }

    public static void main(String[] args) {

        getMessage(() -> {
            String mes = "Message: ";
            System.out.println(mes+ItFunctionalInterface.s);
        });

        getMessage((s) -> {
            String s1 = s + "Hello world";
            System.out.println(s1);
            return s1;
        });

        changeWord("World", "Hello", (s1,s2) -> {
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
                return MessageFunctionInterface.s + mes;
            }
        };

        System.out.println(messageFunctionInterface.get("World"));

        ChangeFunctionInterface changeFunctionInterface = new ChangeFunctionInterface() {
            @Override
            public String str(String s1, String s2) {
                return s2 + s1;
            }
        };

        System.out.println(changeFunctionInterface.str(" Hello", "World"));

    }
}