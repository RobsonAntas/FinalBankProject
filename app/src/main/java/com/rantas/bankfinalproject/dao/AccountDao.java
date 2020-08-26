package com.rantas.bankfinalproject.dao;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.rantas.bankfinalproject.model.Account;
import com.rantas.bankfinalproject.model.User;
import com.rantas.bankfinalproject.repository.AccountRepo;
import com.rantas.bankfinalproject.repository.RequestResult;

public class AccountDao {
    private Context context;

    public AccountDao(Context context) {
        this.context = context;
    }

    public void getAccount(String cpf, String pws, final TextView saldo, final TextView updatedAt){

        User user = new User();
        user.setCpf(cpf);
        user.setPws(pws);
        AccountRepo accountRepo = new AccountRepo();
        accountRepo.getBankAccount(new RequestResult() {
            @Override
            public <T> void successful(T result) {
                Account account = (Account) result;

                saldo.setText(String.valueOf(account.getAccount_balance()));
                updatedAt.setText(account.getUpdatedAt());


            }

            @Override
            public void failureMessage(Messenger messenger) {
                Toast.makeText(context, messenger.getFailureMessage() +
                        " code: " + String.valueOf(messenger.getErrorCode()), Toast.LENGTH_LONG).show();
                Log.d("FALHA",messenger.getFailureMessage() +
                        " code: " + String.valueOf(messenger.getErrorCode()));

            }
        },user);


    }
}
