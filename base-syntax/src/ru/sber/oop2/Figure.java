package ru.sber.oop2;
public abstract class Figure implements Drawable{
    Point point;
   String figureName;
   Color color;

    public Figure(Point point, String figureName) {
        this.point=point;
        this.figureName=figureName;
    }

    public abstract double area();
    public abstract double perimeter();
    public abstract void draw();
    public abstract void draw(Color color);

    public String figureColor(Color color){
        switch (color){
            case BLUE: return "голубого";
            case YELLOW: return "желтого";
            case PINK: return "розового";
            case RED: return "красного";
            case BLACK: return "черного";
        }
        return figureColor(color);
    }
}


