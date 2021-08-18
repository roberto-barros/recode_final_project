package com.example.recode_final_project.service;

import com.example.recode_final_project.model.Department;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DepartmentService {

    @GET("department")
    Call<List<Department>> getDepartments();

    @GET("department/{id}")
    Call<Department> getDepartmentById(@Path("id") int id);


}
