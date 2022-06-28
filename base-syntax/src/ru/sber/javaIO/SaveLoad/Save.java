package ru.sber.javaIO.SaveLoad;

import ru.sber.javaIO.SaveLoad.ImpactResistance.HighSrength;
import ru.sber.javaIO.SaveLoad.Speed.HighSpeed;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Save {
    public static void main(String[] args) throws IOException {
        Racer racer = new Racer("Gamer1");

        System.out.println(racer);

        racer.setLvl(10);
        racer.setSpeed(new HighSpeed());
        racer.setImpactResistance(new HighSrength());

        System.out.println(racer);
        try (FileOutputStream outputStream = new FileOutputStream("base-syntax/src/ru/sber/javaIO/SaveLoad/Save.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(racer);
        }
    }
}
