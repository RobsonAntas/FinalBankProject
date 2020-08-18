package com.rantas.bankfinalproject.service;

import com.rantas.bankfinalproject.model.Account;
import com.rantas.bankfinalproject.model.Boleto;
import com.rantas.bankfinalproject.model.CurrentAccount;
import com.rantas.bankfinalproject.model.DataTransference;
import com.rantas.bankfinalproject.model.Person;
import com.rantas.bankfinalproject.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AllServices {

 @POST("users")
 Call<Person> createUser(@Body Person person);

 @GET("{cpf}/users")
 Call<User> findByUser(@Path("cpf") String cpf);

 @GET("getAllUsers")
 Call<List<User>> getAllUsers();

 @POST("accounts")
 Call<CurrentAccount> addCurrentAccount(@Body CurrentAccount currentAccount);

 @GET("{cpf}/account")
 Call<List<Account>> getAccount(@Path("cpf") String cpf);

//Transactions

 @POST("transaction/pagamento")
 Call<List<Boleto>> bankSlip(@Body Boleto boleto);


 @POST("transaction/transferencia")
 Call<DataTransference> dataTransference(@Body DataTransference transference);


}
