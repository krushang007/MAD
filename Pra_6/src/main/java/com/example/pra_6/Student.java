package com.example.pra_6;

public class Student {
    private String name;
    private String rollNumber;
    private int photo;

    public Student(String name, String rollNumber, int photo) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public int getPhoto() {
        return photo;
    }
}
