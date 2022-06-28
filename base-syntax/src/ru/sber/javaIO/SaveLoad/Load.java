package ru.sber.javaIO.SaveLoad;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
public class Load {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream("JavaIO/src/ru/sber/javaio/SaveAndLoad/files/save.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            Racer hero = (Racer) objectInputStream.readObject();

            System.out.println(hero);
        }
    }
}