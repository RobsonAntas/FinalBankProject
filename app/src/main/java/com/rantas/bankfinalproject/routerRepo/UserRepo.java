package com.rantas.bankfinalproject.routerRepo;

import android.content.Context;
import android.util.Log;

import com.rantas.bankfinalproject.dao.Messenger;
import com.rantas.bankfinalproject.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepo{


    public void getBankUser(final RequestResult requestResult, final User user){

        Call<User> callon = new RetrofitConfig().getAllGetServices().getUser(user.getCpf(),user.getPws());

        callon.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    User user =response.body();
                    requestResult.successful(user);
                    Log.d("response",user.toString());
                }else{
                    requestResult.failureMessage(new Messenger(response.code(),response.errorBody().toString()));
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                requestResult.failureMessage(new Messenger(500,t.getMessage()));
            }
        });
    }
}
