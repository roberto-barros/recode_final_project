package com.example.recode_final_project.model;

import java.util.List;

public class Allocation {

    private int id;
    private List<Professor> professors;
    private List<Course> courses;

    public Allocation() {
    }

    public Allocation(int id, List<Professor> professors) {
        this.id = id;
        this.professors = professors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
