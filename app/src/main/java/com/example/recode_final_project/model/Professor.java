package com.example.recode_final_project.model;

public class Professor {

    private int id;
    private String name;

    public Professor() {

    }

    public Professor(int id, String name){
        this.id = id;
        this.name = name;
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
}
