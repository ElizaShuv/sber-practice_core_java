package ru.sber.oop1.Task1;

public class PhoneTask {
    public static void main(String[] args) {
        Phone phone = new Phone("+7-921-123-45-67","Apple",120.0 );
        Phone phone1 = new Phone("+7-999-999-99-99","Xiaomi");
        phone1.weight = 100.5;

        phone.receiveCall("Паша");
        phone.receiveCall("Наташа", "+7-888-414-55-55");
        phone.sendMessage();
        System.out.println(phone.toString());
        System.out.println(phone1.toString());
    }

}
