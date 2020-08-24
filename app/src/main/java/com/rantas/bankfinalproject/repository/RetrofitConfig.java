package com.rantas.bankfinalproject.repository;


import com.rantas.bankfinalproject.service.AllServices;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


public class RetrofitConfig {

    private Retrofit retrofit;
    public RetrofitConfig() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://newbank-backend.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        this.retrofit =retrofit;
    }

    public AllServices getAllGetServices(){
        return this.retrofit.create(AllServices.class);
    };

}