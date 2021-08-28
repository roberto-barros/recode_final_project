package com.example.recode_final_project.retrofit;

import com.example.recode_final_project.service.CourseService;
import com.example.recode_final_project.service.DepartmentService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfiguration {

    private Retrofit retrofit;

    public RetrofitConfiguration() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://professor-allocation-walkiria.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public DepartmentService getDepartmentService() {
        return retrofit.create(DepartmentService.class);
    }

}
