package ru.sber.javaIO.SortNames;
import java.util.Arrays;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SortNames {
    public static final String ORIGINAL_PATH = "base-syntax/src/ru/sber/javaIO/SortNames/listNames.txt";
    public static final String SORTED_PATH = "base-syntax/src/ru/sber/javaIO/SortNames/SortListNames.txt";
    public static void main(String[] args) throws IOException {
    try (BufferedReader fileInputStream = Files.newBufferedReader(Paths.get(ORIGINAL_PATH));
         BufferedWriter fileOutputStream = Files.newBufferedWriter(Paths.get(SORTED_PATH))){
            String str;
            while((str = fileInputStream.readLine()) != null){
                String[] nameArr = str.split(", ");
                Arrays.sort(nameArr);
                for (int i = 0; i < nameArr.length; i++) {
                    fileOutputStream.write(nameArr[i] + "\n");
                }
                System.out.println("Выполнена запись в файл");
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}