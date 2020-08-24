package com.rantas.bankfinalproject.repository;

import com.rantas.bankfinalproject.dao.Messenger;
import com.rantas.bankfinalproject.model.BankSlip;
import com.rantas.bankfinalproject.model.InnerAccount;
import com.rantas.bankfinalproject.model.Extrato;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SetPayment {

    public void setPayment(final RequestResult requestResult, final InnerAccount account, BankSlip bankSlip){

        Call<Extrato> callOn = new RetrofitConfig().getAllGetServices().doPayment(account.getCode(),account.getUser().getCpf(),account.getUser().getPws(),bankSlip);

        callOn.enqueue(new Callback<Extrato>() {
            @Override
            public void onResponse(Call<Extrato> call, Response<Extrato> response) {
                if(response.isSuccessful()){
                    requestResult.successful(response.body());
                }else{
                    requestResult.failureMessage(new Messenger(response.code(),response.errorBody().toString()));
                }
            }

            @Override
            public void onFailure(Call<Extrato> call, Throwable t) {
                requestResult.failureMessage(new Messenger(500,t.getMessage()));
            }
        });

    }
}
