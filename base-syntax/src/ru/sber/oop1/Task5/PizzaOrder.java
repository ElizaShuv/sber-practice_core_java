package ru.sber.oop1.Task5;

public class PizzaOrder {
    private String name;
    private PizzaSize size;
    private boolean needSauce;
    private String adres;
    private boolean orderAdd;


    public PizzaOrder (String name, PizzaSize size, boolean needSauce, String adres){
        this.name =name;
        this.size = size;
        this.needSauce = needSauce;
        this.adres = adres;
    }

    public String nameSize(){
        switch (size){
            case BIG: return "Большая";
            case SMALL: return "Маленькая";
            case MEDIUM: return "Средняя";
        }
        return nameSize();
    }

    private int count;
    public void order(){
        orderAdd = true;
        count += 1;
        if(count <= 1){
            if (needSauce)
                System.out.println(String.format("Заказ принят. %s пицца '%s'  c соусом на адрес %s",nameSize(), name, adres));
            else
                System.out.println(String.format("Заказ принят. %s пицца '%s' без соуса на адрес %s",nameSize(), name, adres));
        }
        else
            System.out.println("Заказ уже принят");
    }

    public void cancel(){
        orderAdd = false;
        System.out.println("Закакз не принят");
    }

    public String ordStat(){
        if (orderAdd) return "Заказ принят";
        else return "Заказ не принет";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        System.out.println("Заказ изменен");
        this.size = size;
    }

    public boolean isNeedSauce() {
        return needSauce;
    }

    public void setNeedSauce(boolean needSauce) {
        System.out.println("Заказ изменен");
        this.needSauce = needSauce;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        System.out.println("Адрес изменен");
        this.adres = adres;
    }

    @Override
    public String toString() {
        if (needSauce)
          return String.format("Ваш заказ: %s пицца '%s' c соусом \nСтатус заказа: %s",nameSize(), name, ordStat());
        else
           return String.format("Ваш заказ: %s пицца '%s' без соуса \nСтатус заказа: %s",nameSize(), name, ordStat());
    }
}
