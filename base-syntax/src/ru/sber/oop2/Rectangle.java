package ru.sber.oop2;

public class Rectangle extends Figure{
    private double width;
    private double height;

    public Rectangle(Point point, double width, double height) {
        super(point, (width == height ? "квадрат": "прямоугольник"));
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return width * 2 + height * 2;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    @Override
    public void draw(){
        System.out.println(String.format("Нарисован %s черного цвета с с координатами (%s, %s;  %s, %s)", figureName, point.getX(),point.getY(),point.getX()+width,point.getY()-height));
    }

    @Override
    public void draw(Color color){
        System.out.println(String.format("Нарисован %s %s цвета с координатами (%s, %s;  %s, %s)", figureName, figureColor(color), point.getX(),point.getY(), point.getX()+width,point.getY()-height));
    }

}
