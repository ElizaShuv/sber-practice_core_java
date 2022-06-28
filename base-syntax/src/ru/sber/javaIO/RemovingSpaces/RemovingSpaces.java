package ru.sber.javaIO.RemovingSpaces;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Files;

public class RemovingSpaces {

    public static final String ORIGINAL_PATH = "base-syntax/src/ru/sber/javaIO/RemovingSpaces/Borodino.txt";
    public static final String REMOVING_PATH = "base-syntax/src/ru/sber/javaIO/RemovingSpaces/NewBorodino.txt";

    public static void main(String[] args) throws IOException {

        try (BufferedReader fileInputStream = Files.newBufferedReader(Paths.get(ORIGINAL_PATH));
             BufferedWriter fileOutputStream = Files.newBufferedWriter(Paths.get(REMOVING_PATH))) {
                String str;
                while((str = fileInputStream.readLine()) != null){
                fileOutputStream.write(str.replaceAll("\\s+", " ") + "\n");
            }
            System.out.println("Выполнена запись в файл");
        } catch(IOException exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }
}