package com.example.himanshuahuja.todolist;

public class todo {
    private String name;
    private String day;

    public todo(String name, String day) {
        this.name = name;
        this.day = day;
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

    public void setDay(int position, String day) {
        this.day = day;
    }
}

