package tests;

public class TestClass extends Square {
    public double squareArea(double side) {
        return area(side);
    }

    public double squarePerimeter(double side) {
        return perimeter(side);
    }

    public double changeSide (double n) {
        return setSide(n);
    }

    private String squareDraw(String color) {
        return draw(color,getFigureName());
    }
    public String squareDelete() {
        return delete();
    }
}
