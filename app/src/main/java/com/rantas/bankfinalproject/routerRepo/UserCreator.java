package com.rantas.bankfinalproject.routerRepo;

import com.rantas.bankfinalproject.dao.Messenger;
import com.rantas.bankfinalproject.model.Person;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserCreator {

    public void createBankAccountUser(final RequestResult requestResult, final Person person){

        Call<Person> callOn = new RetrofitConfig().getAllGetServices().createBankUser(person);

        callOn.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                if(response.isSuccessful()){
                    requestResult.successful(response.code());
                }else{
                    requestResult.failureMessage(new Messenger(response.code(),response.errorBody().toString()));
                }
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                requestResult.failureMessage(new Messenger(500,t.getMessage()));
            }
        });
    }

}
