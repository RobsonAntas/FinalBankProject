package com.rantas.bankfinalproject.repository;

import com.rantas.bankfinalproject.dao.Messenger;
import com.rantas.bankfinalproject.model.Account;
import com.rantas.bankfinalproject.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllAccountsRepo {

    public void getAllBankAccounts(final RequestResult requestResult, final User user){

        Call<List<Account>> callOn = new RetrofitConfig().getAllGetServices().getAllAccounts(user.getCpf(),user.getPws());

        callOn.enqueue(new Callback<List<Account>>() {
            @Override
            public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
                if(response.isSuccessful()){
                    requestResult.successful(response.body());
                }else{
                    requestResult.failureMessage(new Messenger(response.code(),response.errorBody().toString()));
                }
            }

            @Override
            public void onFailure(Call<List<Account>> call, Throwable t) {
                requestResult.failureMessage(new Messenger(500,t.getMessage()));
            }
        });
    }
}
