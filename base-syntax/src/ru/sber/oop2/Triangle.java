package ru.sber.oop2;
public class Triangle extends Figure{
    private double aSide;
    private double bSide;
    private double cSide;
    public Triangle(Point point, double aSide, double bSide, double cSide) {
        super(point, "треугольник");
        this.aSide = aSide;
        this.bSide = bSide;
        this.cSide = cSide;
    }

    public double area(){
        double per = perimeter() / 2;
        return Math.sqrt(per * (per-aSide) * (per-bSide) * (per-cSide));
    }

    public double perimeter(){
        return (aSide + bSide + cSide);
    }

    public void setASide(double aSide) {
        this.aSide = aSide;
    }

    public void setBSide(double bSide) {
        this.bSide = bSide;
    }

    public void setCSide(double cSide) {
        this.cSide = cSide;
    }

    public double getASide() {
        return aSide;
    }

    public double getBSide() {
        return bSide;
    }

    public double getCSide() {
        return cSide;
    }

    @Override
    public void draw(){
        System.out.println(String.format("Нарисован %s черного цвета с координатами (%s, %s)", figureName, point.getX(),point.getY()));
    }

    @Override
    public void draw(Color color){
        System.out.println(String.format("Нарисован %s %s цвета с координатами (%s, %s)", figureName, figureColor(color), point.getX(),point.getY()));
    }
}

