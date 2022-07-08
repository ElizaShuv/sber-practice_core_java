package tests;

public class TestClass extends Square{

    public double SquareArea(double side){
        return  area(side);
    }

    public double SquarePerimeter(double side){
        return  perimeter(side);
    }

    public double ChangeSide (double n){
        return setSide(n);
    }

    private String SquareDraw(String color){
        return draw(color,figureName);
    }

    public String SquareDelete(){
        return delete();
    }
}
