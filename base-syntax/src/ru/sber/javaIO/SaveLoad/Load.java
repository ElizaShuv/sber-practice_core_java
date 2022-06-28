package ru.sber.javaIO.SaveLoad;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
public class Load {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream("base-syntax/src/ru/sber/javaIO/SaveLoad/Save.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            Racer racer = (Racer) objectInputStream.readObject();

            System.out.println(racer);
        }
    }
}