package tests;

public class DrawFigure  {

    private String color;

    public String draw(String color, String figureName){
        return String.format("%s %s нарисован", color, figureName);
    }

    public String delete(){
        return "Фигура удалена";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
