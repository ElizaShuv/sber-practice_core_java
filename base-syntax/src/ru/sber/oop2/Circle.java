package ru.sber.oop2;

public class Circle extends Figure{
    private double radius;

    public Circle(Point point, double radius){
        super(point,"круг");
        this.radius = radius;
    }

    @Override
    public double area() {

        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return Math.PI * radius * 2;
    }

    @Override
    public void draw(){
        System.out.println(String.format("Нарисован %s черного цвета с центром в координатах (%s, %s)", figureName, point.getX(),point.getY()));
    }

    @Override
    public void draw(Color color){
        System.out.println(String.format("Нарисован %s %s цвета с центром в координатах (%s, %s)", figureName, figureColor(color), point.getX(),point.getY()));
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }



}
