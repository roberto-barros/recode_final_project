package com.example.recode_final_project.dto;

public class DepartmentDTO {

    String name;

    public DepartmentDTO(String name) {
        this.name = name;
    }

    public DepartmentDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
