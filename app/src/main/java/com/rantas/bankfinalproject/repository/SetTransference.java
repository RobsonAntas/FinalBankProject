package com.rantas.bankfinalproject.repository;

import com.rantas.bankfinalproject.dao.Messenger;
import com.rantas.bankfinalproject.model.DataTransference;
import com.rantas.bankfinalproject.model.TranfComprovante;
import com.rantas.bankfinalproject.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SetTransference {

    public void doMoneyTransference(final RequestResult requestResult, final User user,final DataTransference data){

        Call<TranfComprovante> callOn = new RetrofitConfig().getAllGetServices().doTransfer(user.getCpf(),user.getPws(),data);

        callOn.enqueue(new Callback<TranfComprovante>() {
            @Override
            public void onResponse(Call<TranfComprovante> call, Response<TranfComprovante> response) {
                if(response.isSuccessful()){
                    requestResult.successful(response.body());
                }else{
                    requestResult.failureMessage(new Messenger(response.code(),response.errorBody().toString()));
                }
            }

            @Override
            public void onFailure(Call<TranfComprovante> call, Throwable t) {
                requestResult.failureMessage(new Messenger(500,t.getMessage()));
            }
        });

    }
}
