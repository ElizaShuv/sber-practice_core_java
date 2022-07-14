package lambdas;

import org.junit.Test;

import static lambdas.LambdaProgram.changeWord;
import static lambdas.LambdaProgram.getMessage;
import static org.junit.Assert.assertEquals;


public class TestLambdaProgram {
    private final static String TEST_STR1 = "Hello";
    private final static String TEST_STR2 = "World";
    private final static String TEST_STR = "Hello World";
    private final static String TEST_GET = "Message: World";
    private final static String TEST_OUT = "It function interface";

    @Test
    public void firstTest() {
        ItFunctionalInterface itFunctionalInterface = new ItFunctionalInterface() {
            @Override
            public String out() {
                return "It function interface";
            }
        };
        assertEquals(TEST_OUT, itFunctionalInterface.out());
    }

    @Test
    public void secondTest() {
        MessageFunctionInterface messageFunctionInterface = new MessageFunctionInterface() {
            @Override
            public String get(String mes) {
                return MessageFunctionInterface.S + mes;
            }
        };
        assertEquals(TEST_GET, messageFunctionInterface.get(TEST_STR2));
    }

    @Test
    public void thirdTest() {
        ChangeFunctionInterface changeFunctionInterface = new ChangeFunctionInterface() {
            @Override
            public String str(String s1, String s2) {
                return s2 + " " + s1;
            }
        };
        assertEquals(TEST_STR, changeFunctionInterface.str(TEST_STR2, TEST_STR1));
    }

    @Test
    public void fourthTest() {
        getMessage(() -> ItFunctionalInterface.S);
    }

    @Test
    public void fifthTest() {
        getMessage((s) -> s + TEST_STR2);
    }

    @Test
    public void sixthTest() {
        changeWord(TEST_STR2, TEST_STR1, (s1, s2) -> s2 + " " + s1);
    }
}
