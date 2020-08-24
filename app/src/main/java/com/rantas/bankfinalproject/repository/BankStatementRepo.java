package com.rantas.bankfinalproject.repository;

import com.rantas.bankfinalproject.dao.Messenger;
import com.rantas.bankfinalproject.model.AccountStatement;
import com.rantas.bankfinalproject.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BankStatementRepo {

    public void getBankStatement(final RequestResult requestResult, final User user){

        Call<AccountStatement> callOn = new RetrofitConfig().getAllGetServices().getStatement(user.getCpf(),user.getPws());

        callOn.enqueue(new Callback<AccountStatement>() {
            @Override
            public void onResponse(Call<AccountStatement> call, Response<AccountStatement> response) {
                if(response.isSuccessful()){
                    requestResult.successful(response.body());
                }else{
                    requestResult.failureMessage(new Messenger(response.code(),response.errorBody().toString()));
                }
            }

            @Override
            public void onFailure(Call<AccountStatement> call, Throwable t) {
                    requestResult.failureMessage(new Messenger(500, t.getMessage()));
            }
        });
    }
}
