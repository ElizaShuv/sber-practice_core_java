package ru.sber.oop1.Task4;

public class Autor {
    private String name;
    private String gender;
    private String email;

    public Autor(String name, String gender, String email) {
        this.name = name;
        this.gender = gender;
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Имя автора: %s;  Пол: %s;  email: %s ", name, gender, email);
    }
}
