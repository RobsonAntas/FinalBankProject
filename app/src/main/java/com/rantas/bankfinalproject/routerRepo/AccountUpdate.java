package com.rantas.bankfinalproject.routerRepo;

import com.rantas.bankfinalproject.dao.Messenger;
import com.rantas.bankfinalproject.model.StatusAccount;
import com.rantas.bankfinalproject.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountUpdate {

    public void updateAccount(final RequestResult requestResult, final StatusAccount statusAccount,final User user){

        Call<StatusAccount> callOn = new RetrofitConfig().getAllGetServices().updateAccount(user.getCpf(),user.getPws(),statusAccount);

        callOn.enqueue(new Callback<StatusAccount>() {
            @Override
            public void onResponse(Call<StatusAccount> call, Response<StatusAccount> response) {
                if(response.isSuccessful()){
                    requestResult.successful(response.code());
                }else{
                    requestResult.failureMessage(new Messenger(response.code(),response.errorBody().toString()));
                }
            }

            @Override
            public void onFailure(Call<StatusAccount> call, Throwable t) {
                requestResult.failureMessage(new Messenger(500,t.getMessage()));
            }
        });

    }
}
