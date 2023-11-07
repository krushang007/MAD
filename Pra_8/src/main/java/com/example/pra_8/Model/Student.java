package com.example.pra_8.Model;

public class Student {
    private int id;
    private String name;
    private  String spi;
    private String cpi;

    public Student(int id, String name, String spi, String cpi) {
        this.id = id;
        this.name = name;
        this.spi = spi;
        this.cpi = cpi;
    }

    public Student(String name, String spi, String cpi) {
        this.name = name;
        this.spi = spi;
        this.cpi = cpi;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpi() {
        return spi;
    }

    public void setSpi(String spi) {
        this.spi = spi;
    }

    public String getCpi() {
        return cpi;
    }

    public void setCpi(String cpi) {
        this.cpi = cpi;
    }
}
