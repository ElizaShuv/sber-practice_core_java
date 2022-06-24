package ru.sber.oop2;
public class PaintExample {
    public static void main(String[] args) {

        Point cPoint = new Point(1, 2);
        Circle circle = new Circle(cPoint, 8.0);
        System.out.println(String.format("'%s'\nРадиус: %s \nПлощадь: %s \nПериметр: %s", circle.figureName,circle.getRadius(),circle.area(), circle.perimeter()));
        circle.draw(Color.PINK);
        System.out.println();

        Point recPoint = new Point(0, 0);
        Rectangle rectangle = new Rectangle(recPoint, 5.0, 2.0);
        System.out.println(String.format("'%s'\nДлина: %s  Ширина: %s \nПлощадь: %s \nПериметр: %s", rectangle.figureName, rectangle.getHeight(),rectangle.getWidth(),rectangle.area(), rectangle.perimeter()));
        rectangle.draw(Color.BLUE);
        System.out.println();

        Point recPoint2 = new Point(10, 5);
        Rectangle rectangle2 = new Rectangle(recPoint2, 5.0, 5.0);
        rectangle2.draw();
        System.out.println();

        Point sqPoint = new Point(10, 10);
        Square square = new Square(sqPoint, 10);
        System.out.println(String.format("'%s'\nСторона: %s  \nПлощадь: %s \nПериметр: %s", square.figureName, square.getSide(),square.area(), square.perimeter()));
        square.draw();
        System.out.println();

        Point triPoint = new Point(-10, 2);
        Triangle triangle = new Triangle(triPoint, 5, 3,4);
        System.out.println(String.format("'%s'\nСтороны: %s, %s, %s  \nПлощадь: %s \nПериметр: %s", triangle.figureName, triangle.getASide(), triangle.getBSide(), triangle.getCSide(),triangle.area(), triangle.perimeter()));
        triangle.draw(Color.YELLOW);
    }
}

