package com.rantas.bankfinalproject.routerRepo;

import com.rantas.bankfinalproject.dao.Messenger;
import com.rantas.bankfinalproject.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserUpdate {

    public void updateBankUser(final RequestResult requestResult, final User user){

        Call<User> callOn = new RetrofitConfig().getAllGetServices().updateUser(user.get_id(),user);

        callOn.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    requestResult.successful(response.code());
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
