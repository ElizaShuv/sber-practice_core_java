package Tests;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TestClassTest {
    private final static double DELTA = 1e-15;
    private final static String TESTED_DRAW = "розовый квадрат нарисован" ;
    private final static String TESTED_DELETE = "Фигура удалена" ;
    private final static double TESTED_AREA = 25.0;
    private final static double TESTED_PERIMETER = 20.0;
   private final static TestClass testClass = new TestClass();

    @Test
    public void firstTest(){
    DrawFigure drawFigure = mock(DrawFigure.class);
    when(drawFigure.draw("розовый","квадрат")).thenReturn(TESTED_DRAW);
    assertEquals(TESTED_DRAW, testClass.draw("розовый","квадрат"));
    when(drawFigure.delete()).thenReturn(TESTED_DELETE);
    assertEquals(TESTED_DELETE, testClass.delete());

    Square square = mock(Square.class);
    when(square.area(5)).thenReturn(TESTED_AREA);
    assertEquals(TESTED_AREA, testClass.area(5), DELTA);
    when(square.perimeter(5)).thenReturn(TESTED_PERIMETER);
    assertEquals(TESTED_PERIMETER, testClass.perimeter(5), DELTA);
}

    @Test
    public void secondTest(){
        TestClass testClass = spy(TestClass.class);
        testClass.SquareArea(5);
        testClass.SquarePerimeter(5);
        testClass.ChangeSide(2);
        testClass.SquareDelete();

        verify(testClass, times(1)).area(5);
        verify(testClass, times(1)).perimeter(5);
        verify(testClass, times(1)).setSide(2);
        verify(testClass, times(1)).delete();

    }

    @Test(expected = IllegalStateException.class)
    public void thirdTest() {
        TestClass testClass = mock(TestClass.class);
        when(testClass.ChangeSide(anyDouble())).thenThrow(new IllegalStateException());
        testClass.ChangeSide(2);
        when(testClass.SquareArea(5)).thenThrow(new IllegalStateException());
        testClass.SquareArea(5);
    }
    @Test
    public void privateMethodTest() throws Exception {
        Method privateMethod = TestClass.class.getDeclaredMethod("SquareDraw", String.class);
        privateMethod.setAccessible(true);
        String returnValue = (String) privateMethod.invoke(testClass, "розовый");
        assertEquals("розовый квадрат нарисован", returnValue);
    }

}
