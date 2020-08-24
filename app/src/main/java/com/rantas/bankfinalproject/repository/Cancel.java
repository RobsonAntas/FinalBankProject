package com.rantas.bankfinalproject.repository;

import com.rantas.bankfinalproject.dao.Messenger;
import com.rantas.bankfinalproject.model.CancelAccount;
import com.rantas.bankfinalproject.model.InnerAccount;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Cancel {

    public void cancelAccount(final RequestResult requestResult, final InnerAccount account){

        Call<CancelAccount> callOn = new RetrofitConfig().getAllGetServices().cancelAccount(account.getCode(),account.getUser().getCpf(),account.getUser().getPws());


        callOn.enqueue(new Callback<CancelAccount>() {
            @Override
            public void onResponse(Call<CancelAccount> call, Response<CancelAccount> response) {
                if(response.isSuccessful()){
                    requestResult.successful(response.code());
                }else{
                    requestResult.failureMessage(new Messenger(response.code(),response.errorBody().toString()));
                }
            }

            @Override
            public void onFailure(Call<CancelAccount> call, Throwable t) {
                requestResult.failureMessage(new Messenger(500,t.getMessage()));
            }
        });

    }
}
