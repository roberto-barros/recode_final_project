package com.example.recode_final_project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("allocations")
public class Course {

    private int id;
    private String name;
    private Allocation allocations;

    public Course() {
    }

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Course(int id, String name, Allocation allocations) {
        this.id = id;
        this.name = name;
        this.allocations = allocations;
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

    public Allocation getAllocations() {
        return allocations;
    }

    public void setAllocations(Allocation allocations) {
        this.allocations = allocations;
    }
}
