package com.example.recode_final_project.service;

import com.example.recode_final_project.model.Course;
import com.example.recode_final_project.model.Department;
import com.example.recode_final_project.model.Professor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CourseService {

    @GET("course")
    Call<List<Course>> getAllCourses();

    @GET("course/{id}")
    Call<Course> getCourseById(@Path("id") int id);

    @POST("course")
    Call<Professor> create(@Body Department department);

    @PUT("course/{id}")
    Call<Professor> update(@Path("id") int id, @Body Course course);

    @DELETE
    Call<Professor> delete(@Path("id") int id, @Body Course course);

}
