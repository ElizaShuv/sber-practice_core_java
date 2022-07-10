package lambdas;

import org.junit.Test;
import static org.mockito.Mockito.*;

    public class TestLambdaProgram {
        private final static String TEST_STR1 = "Hello";
        private final static String TEST_STR2 = "World";
        private final static String TEST_STR = "Hello World";
        private final static String TEST_GET = "Message: World";

        @Test
        public void firstTest() {
            ChangeFunctionInterface changeFunctionInterface = mock(ChangeFunctionInterface.class);
            when(changeFunctionInterface.str(TEST_STR2,TEST_STR1)).thenReturn(TEST_STR);

            MessageFunctionInterface messageFunctionInterface = mock(MessageFunctionInterface.class);
            when(messageFunctionInterface.get(TEST_STR2)).thenReturn(TEST_GET);
        }

        @Test(expected = IllegalStateException.class)
        public void secondTest() {
            ChangeFunctionInterface changeFunctionInterface = mock(ChangeFunctionInterface.class);
            when(changeFunctionInterface.str(anyString(),anyString())).thenThrow(new IllegalStateException());
            changeFunctionInterface.str(TEST_STR2, TEST_STR1);

            MessageFunctionInterface messageFunctionInterface = mock(MessageFunctionInterface.class);
            when(messageFunctionInterface.get(anyString())).thenThrow(new IllegalStateException());
            messageFunctionInterface.get(TEST_STR2);
        }
}
