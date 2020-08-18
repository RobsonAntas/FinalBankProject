package com.rantas.bankfinalproject.router;

import com.rantas.bankfinalproject.model.Account;
import com.rantas.bankfinalproject.model.Boleto;
import com.rantas.bankfinalproject.model.CurrentAccount;
import com.rantas.bankfinalproject.model.DataTransference;
import com.rantas.bankfinalproject.model.Person;
import com.rantas.bankfinalproject.model.User;
import com.rantas.bankfinalproject.service.AllServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class RetrofitConfig {

    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://newbank-backend.herokuapp.com/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();


    public AllServices createUserCall(){
        return retrofit.create(AllServices.class);
    };


    public AllServices findByUserCall(){
        return retrofit.create(AllServices.class);
    };


    public AllServices getAllUsersCall(){
        return retrofit.create(AllServices.class);
    };


    public AllServices addCurrentAccountCall(){
        return retrofit.create(AllServices.class);
    };


    public AllServices getAccountCall(){
        return retrofit.create(AllServices.class);
    };



    public AllServices bankSlipCall(){
        return retrofit.create(AllServices.class);
    };



    public AllServices dataTransferenceCall(){
        return retrofit.create(AllServices.class);
    };
}
