package com.rantas.bankfinalproject.service;

import com.rantas.bankfinalproject.model.Account;
import com.rantas.bankfinalproject.model.AddAccount;
import com.rantas.bankfinalproject.model.BankSlip;
import com.rantas.bankfinalproject.model.CancelAccount;
import com.rantas.bankfinalproject.model.DataTransference;
import com.rantas.bankfinalproject.model.Deposit;
import com.rantas.bankfinalproject.model.Person;
import com.rantas.bankfinalproject.model.AccountStatement;
import com.rantas.bankfinalproject.model.StatusAccount;
import com.rantas.bankfinalproject.model.User;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AllServices {

 @POST("users")
 Call<Person> createBankUser(@Body Person person);

 @GET("users")
 Call<User> getUser(@Header("cpf") String cpf, @Header("pws") String pws);

 @GET("getAllUsers")
 Call<List<User>> getAllUser(@Header("cpf") String cpf, @Header("pws") String pws);

 @PUT("update/{_id}")
 Call<User> updateUser(@Path("_id") String _id, @Body User user);

 //Services for Accounts

 @GET("accounts")
 Call<Account> getAccount(@Header("cpf") String cpf, @Header("pws") String pws);

 @GET("getAllAccounts")
 Call<List<Account>> getAllAccounts(@Header("cpf") String cpf, @Header("pws") String pws);

 @POST("accounts") //Headers cpf e pws, only for training @HeaderMap
 Call<AddAccount> addAccount(@HeaderMap Map<String,String> headers,@Body AddAccount addAccount);

 @PUT("accounts")
 Call<StatusAccount> updateAccount(@Header("cpf") String cpf, @Header("pws") String pws, @Body StatusAccount status);

 //Transactions

 @POST("pagamento")
 Call<BankSlip> doPayment(@Header("account") String account, @Header("cpf") String cpf, @Header("pws") String pws,@Body BankSlip bankSlip);

 @POST("transferencia")
 Call<DataTransference>  doTransfer(@Header("cpf") String cpf, @Header("pws") String pws, @Body DataTransference amount);

 @POST("deposito")
 Call<Deposit> doDeposit(@Header("account") String account, @Header("cpf") String cpf, @Header("pws") String pws, @Body Deposit amount);

 @PUT("accounts/cancel")
 Call<CancelAccount> cancelAccount(@Header("account") String account, @Header("cpf") String cpf, @Header("pws") String pws);

 @GET("getByUser")
 Call<AccountStatement> getStatement(@Header("cpf") String cpf, @Header("pws") String pws);

}
