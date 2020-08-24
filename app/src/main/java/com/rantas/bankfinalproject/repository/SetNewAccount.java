package com.rantas.bankfinalproject.repository;

import com.rantas.bankfinalproject.dao.Messenger;
import com.rantas.bankfinalproject.model.AddAccount;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SetNewAccount {

    public void addNewAccount(final RequestResult requestResult, final Map<String,String> headers,final AddAccount data){

        Call<AddAccount> callOn = new RetrofitConfig().getAllGetServices().addAccount(headers,data);

        callOn.enqueue(new Callback<AddAccount>() {
            @Override
            public void onResponse(Call<AddAccount> call, Response<AddAccount> response) {
                if(response.isSuccessful()){
                    requestResult.successful(response.code());
                }else {
                    requestResult.failureMessage(new Messenger(response.code(),response.errorBody().toString()));
                }

            }

            @Override
            public void onFailure(Call<AddAccount> call, Throwable t) {
                    requestResult.failureMessage(new Messenger(500,t.getMessage()));
            }
        });
    }
}
