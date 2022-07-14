package tests;

public class Square extends DrawFigure {
    private final String figureName = "квадрат";
    public String getFigureName() {
        return figureName;
    }
    public double setSide(double side) {
        return side;
    }
    public double area(double side) {
        return side*side;
    }
    public double perimeter(double side) {
        return side*4;
    }
}
