package ru.sber.oop1.Task1;

public class Phone {
    String number;
    String model;
    double weight;

    void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }

    public String getNumber(String number) {
        return number;
    }

    public Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone() {
    }

    void receiveCall(String name, String number) {
        System.out.println("Звонит " + name + " " + number);
    }

    void sendMessage() {
        String[] numbers = new String[7];

        numbers[0] = "+7-123-444-55-55";
        numbers[1] = "+7-111-222-33-44";
        numbers[2] = "+7-999-425-51-55";
        numbers[3] = "+7-953-321-20-05";
        numbers[4] = "+7-921-525-00-05";
        numbers[5] = "+7-996-125-78-78";
        numbers[6] = "+7-987-256-01-17";

        System.out.println("Список номеров телефона:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    @Override
    public String toString() {
        return String.format("Номер телефона: %s \nМодель телефона: %s \nВес телефона: %s ", number, model, weight);
    }
}

