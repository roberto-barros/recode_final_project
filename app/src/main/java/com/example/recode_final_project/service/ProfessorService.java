package com.example.recode_final_project.service;

import com.example.recode_final_project.model.Professor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProfessorService {

    //CRUD

    @GET("professor")
    Call<List<Professor>> getProfessors();

    @GET("professor/{id}")
    Call<Professor> getProfessorById(@Path("id") int id);

    @POST("professor")
    Call<Professor> create(@Body Professor professor);

    @PUT("professor/{id}")
    Call<Professor> update(@Path("id") int id, @Body Professor professor);

    @DELETE
    Call<Professor> delete(@Path("id") int id, @Body Professor professor);
}
