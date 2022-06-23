package ru.sber.oop1.Task4;

import ru.sber.oop1.Task4.Autor;

public class Book {
    private String name;
    private Autor autor;
    private int year;

    public Book(String name, Autor autor, int year) {
        this.name = name;
        this.autor = autor;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public String toString() {
        return String.format("Название книги: %s;  Автор: ( %s);  Год: %s; ", name, autor, year);
    }
}