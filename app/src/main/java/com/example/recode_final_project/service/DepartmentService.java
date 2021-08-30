package com.example.recode_final_project.service;

import com.example.recode_final_project.dto.DepartmentDTO;
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

public interface DepartmentService {

    @GET("departments")
    Call<List<Department>> getDepartments();

    @GET("departments/{id}")
    Call<Department> getDepartmentById(@Path("id") int id);

    @POST("departments")
    Call<Department> createDepartment(@Body DepartmentDTO department);

    @PUT("departments/{id}")
    Call<Department> updateDepartment(@Path("id") int id, @Body Department department);

    @DELETE
    Call<Professor> delete(@Path("id") int id, @Body Department department);



    @POST("department")
    Call<Professor> create(@Body Department department);

    @PUT("department/{id}")
    Call<Professor> update(@Path("id") int id, @Body Department department);




}
