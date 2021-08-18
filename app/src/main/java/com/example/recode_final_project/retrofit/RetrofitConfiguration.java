package com.example.recode_final_project.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfiguration {

    private Retrofit retrofit;

    public RetrofitConfiguration() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://professor-allocation.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }
}
