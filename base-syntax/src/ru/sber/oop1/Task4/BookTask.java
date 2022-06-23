package ru.sber.oop1.Task4;

import ru.sber.oop1.Task4.Autor;
import ru.sber.oop1.Task4.Book;

public class BookTask {
    public static void main(String[] args) {
        Autor autor = new Autor("И.И.Иванов", "муж", "Ivanov@gmail.com");
        Book book = new Book ("Книга", autor, 2021);
        System.out.println(autor.toString());
        System.out.println(book.toString());

        System.out.println( String.format("Произведение: %s '%s' ", autor.getName(), book.getName()));

        book.setName("Новая книга");
        book.setYear(2022);
        autor.setEmail("IvanovNew@gmail.com");
        System.out.println(book.toString());
    }
}
