package com.rantas.bankfinalproject.repository;

import com.rantas.bankfinalproject.dao.Messenger;
import com.rantas.bankfinalproject.model.Boleto;
import com.rantas.bankfinalproject.model.Deposit;
import com.rantas.bankfinalproject.model.InnerAccount;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SetDeposit {

    public void doBankDeposit(final RequestResult requestResult, final InnerAccount account, final Deposit amount) {


    Call<Boleto> callOn = new RetrofitConfig().getAllGetServices().doDeposit(account.getCode(),account.getUser().getCpf(),account.getUser().getPws(),amount);

    callOn.enqueue(new Callback<Boleto>() {
        @Override
        public void onResponse(Call<Boleto> call, Response<Boleto> response) {
            if(response.isSuccessful()){
                requestResult.successful(response.body());
            }else{
                requestResult.failureMessage(new Messenger(response.code(),response.errorBody().toString()));
            }
        }

        @Override
        public void onFailure(Call<Boleto> call, Throwable t) {
                requestResult.failureMessage(new Messenger(500,t.getMessage()));
        }
    });

    }
}
