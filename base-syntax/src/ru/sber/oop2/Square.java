package ru.sber.oop2;
public class Square extends Figure{
    private double side;

    public Square(Point point, double side) {
        super(point, "квадрат");
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double perimeter() {
        return side * 4;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    @Override
    public void draw(){
        System.out.println(String.format("Нарисован %s черного цвета с с координатами (%s, %s;  %s, %s)", figureName, point.getX(),point.getY(),point.getX()+side,point.getY()-side));
    }

    @Override
    public void draw(Color color){
        System.out.println(String.format("Нарисован %s %s цвета с координатами (%s, %s;  %s, %s)", figureName, figureColor(color), point.getX(),point.getY(), point.getX()+side,point.getY()-side));
    }

}

