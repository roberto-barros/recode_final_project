package com.example.recode_final_project.model;

import java.time.DayOfWeek;
import java.util.Date;


public class Allocation {

    private int id;
    private DayOfWeek dayOfWeek;
    private Date start;
    private Date end;
    private Professor allocationProfessor;
    private Course allocationCourse;


    public Allocation() {

    }

    public Allocation(int id, DayOfWeek dayOfWeek, Date start, Date end, Professor allocationProfessor, Course allocationCourse) {
        this.id = id;
        this.dayOfWeek = dayOfWeek;
        this.start = start;
        this.end = end;
        this.allocationProfessor = allocationProfessor;
        this.allocationCourse = allocationCourse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Professor getAllocationProfessor() {
        return allocationProfessor;
    }

    public void setAllocationProfessor(Professor allocationProfessor) {
        this.allocationProfessor = allocationProfessor;
    }

    public Course getAllocationCourse() {
        return allocationCourse;
    }

    public void setAllocationCourse(Course allocationCourse) {
        this.allocationCourse = allocationCourse;
    }
}