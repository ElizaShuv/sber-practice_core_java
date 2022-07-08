package tests;

public class Square extends DrawFigure{
    protected String figureName = "квадрат";

    public double setSide(double side) {
        return side;
    }
    public double area(double side){
        return side*side;
    }
    public double perimeter(double side){
        return side*4;
    }

}
