package com.example.himanshuahuja.todolist;

public class todo {
    private String name;
    private String day;
    private long id;

    public todo(String name, String day) {
        this.name = name;
        this.day = day;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}

