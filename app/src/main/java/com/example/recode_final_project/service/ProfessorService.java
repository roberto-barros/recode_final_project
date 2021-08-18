package com.example.recode_final_project.service;

import com.example.recode_final_project.model.Professor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProfessorService {

    @GET("professor")
    Call<List<Professor>> getProfessors();

    @GET("professor/{id}")
    Call<Professor> getProfessorById(@Path("id") int id);
}
