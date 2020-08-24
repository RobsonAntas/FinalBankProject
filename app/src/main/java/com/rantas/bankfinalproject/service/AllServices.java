package com.rantas.bankfinalproject.service;

import com.rantas.bankfinalproject.model.Account;
import com.rantas.bankfinalproject.model.AddAccount;
import com.rantas.bankfinalproject.model.BankSlip;
import com.rantas.bankfinalproject.model.Boleto;
import com.rantas.bankfinalproject.model.CancelAccount;
import com.rantas.bankfinalproject.model.DataTransference;
import com.rantas.bankfinalproject.model.Deposit;
import com.rantas.bankfinalproject.model.Extrato;
import com.rantas.bankfinalproject.model.Person;
import com.rantas.bankfinalproject.model.AccountStatement;
import com.rantas.bankfinalproject.model.StatusAccount;
import com.rantas.bankfinalproject.model.TranfComprovante;
import com.rantas.bankfinalproject.model.User;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AllServices {

 @Headers("Contenty-Type: application/json")
 @POST("users")
 Call<Person> createBankUser(@Body Person person);

 @Headers("Contenty-Type: application/json")
 @GET("users")
 Call<User> getUser(@Header("cpf") String cpf, @Header("pws") String pws);

 @Headers("Contenty-Type: application/json")
 @GET("getAllUsers")
 Call<List<User>> getAllUser(@Header("cpf") String cpf, @Header("pws") String pws);

 @Headers("Contenty-Type: application/json")
 @PUT("update/{_id}")
 Call<User> updateUser(@Path("_id") String _id, @Body User user);

 //Services for Accounts

 @Headers("Contenty-Type: application/json")
 @GET("accounts")
 Call<Account> getAccount(@Header("cpf") String cpf, @Header("pws") String pws);

 @Headers("Contenty-Type: application/json")
 @GET("getAllAccounts")
 Call<List<Account>> getAllAccounts(@Header("cpf") String cpf, @Header("pws") String pws);

 @Headers("Contenty-Type: application/json")
 @POST("accounts") //Headers cpf e pws, only for training @HeaderMap
 Call<AddAccount> addAccount(@HeaderMap Map<String,String> headers,@Body AddAccount addAccount);

 @Headers("Contenty-Type: application/json")
 @PUT("accounts")
 Call<StatusAccount> updateAccount(@Header("cpf") String cpf, @Header("pws") String pws, @Body StatusAccount status);

 //Transactions

 @Headers("Contenty-Type: application/json")
 @POST("transaction/pagamento")
 Call<Extrato> doPayment(@Header("account") String account, @Header("cpf") String cpf, @Header("pws") String pws, @Body BankSlip bankSlip);

 @Headers("Contenty-Type: application/json")
 @POST("transaction/transferencia")
 Call<TranfComprovante>  doTransfer(@Header("cpf") String cpf, @Header("pws") String pws, @Body DataTransference amount);

 @Headers("Contenty-Type: application/json")
 @POST("transaction/deposito")
 Call<Boleto> doDeposit(@Header("account") String account, @Header("cpf") String cpf, @Header("pws") String pws, @Body Deposit amount);

 @Headers("Contenty-Type: application/json")
 @PUT("accounts/cancel")
 Call<CancelAccount> cancelAccount(@Header("account") String account, @Header("cpf") String cpf, @Header("pws") String pws);

 @Headers("Contenty-Type: application/json")
 @GET("getByUser")
 Call<AccountStatement> getStatement(@Header("cpf") String cpf, @Header("pws") String pws);

}
