package ru.sber.oop1.Task5;

import ru.sber.oop1.Task5.PizzaOrder;
import ru.sber.oop1.Task5.PizzaSize;

public class PizzaTask {
    public static void main(String[] args) {
        PizzaOrder pizza = new PizzaOrder("Барбекю", PizzaSize.BIG, true, "Северная 10Б" );
        pizza.order();
        System.out.println(pizza.toString());

        pizza.setSize(PizzaSize.MEDIUM);
        System.out.println(pizza.toString());

        PizzaOrder pizza2 = new PizzaOrder("Всё и сразу", PizzaSize.SMALL, false, "Разина 23" );
        pizza2.cancel();
        System.out.println(pizza2.toString());
    }
}
