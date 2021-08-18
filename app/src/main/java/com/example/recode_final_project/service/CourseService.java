package com.example.recode_final_project.service;

import com.example.recode_final_project.model.Course;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CourseService {

    @GET("course")
    Call<List<Course>> getCourses();

    @GET("course/{id}")
    Call<Course> getCourseById(@Path("id") int id);
}
