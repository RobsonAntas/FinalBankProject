package com.rantas.bankfinalproject.routerRepo;

import com.rantas.bankfinalproject.dao.Messenger;
import com.rantas.bankfinalproject.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllUserRepo {


    public void getAllBankUsers(final RequestResult requestResult, final User user){

        Call<List<User>> callOn = new RetrofitConfig().getAllGetServices().getAllUser(user.getCpf(),user.getPws());

        callOn.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){
                    requestResult.successful(response.body());
                }else{
                    requestResult.failureMessage(new Messenger(response.code(),response.errorBody().toString()));
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                    requestResult.failureMessage(new Messenger(500,t.getMessage()));
            }
        });
    }
}
