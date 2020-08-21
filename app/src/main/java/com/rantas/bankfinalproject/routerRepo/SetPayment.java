package com.rantas.bankfinalproject.routerRepo;

import com.rantas.bankfinalproject.dao.Messenger;
import com.rantas.bankfinalproject.model.Account;
import com.rantas.bankfinalproject.model.BankSlip;
import com.rantas.bankfinalproject.model.InnerAccount;
import com.rantas.bankfinalproject.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SetPayment {

    public void setPayment(final RequestResult requestResult, final InnerAccount account, BankSlip bankSlip){

        Call<BankSlip> callOn = new RetrofitConfig().getAllGetServices().doPayment(account.getCode(),account.getUser().getCpf(),account.getUser().getPws(),bankSlip);

        callOn.enqueue(new Callback<BankSlip>() {
            @Override
            public void onResponse(Call<BankSlip> call, Response<BankSlip> response) {
                if(response.isSuccessful()){
                    requestResult.successful(response.code());
                }else{
                    requestResult.failureMessage(new Messenger(response.code(),response.errorBody().toString()));
                }
            }

            @Override
            public void onFailure(Call<BankSlip> call, Throwable t) {
                requestResult.failureMessage(new Messenger(500,t.getMessage()));
            }
        });

    }
}
