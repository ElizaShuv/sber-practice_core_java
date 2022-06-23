package ru.sber.oop1.Task2;

public class Circle {
    double radius;
    String color;

    public double area(){
       double area = Math.PI*radius*radius;

       return area;
    }

    public double perimetr(){
        double perimetr = 2*Math.PI*radius;

        return perimetr;
    }

    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("Радиус: %s Цвет: %s Площадь: %s Периметр: %s", radius, color, area(), perimetr()) ;
    }
}
