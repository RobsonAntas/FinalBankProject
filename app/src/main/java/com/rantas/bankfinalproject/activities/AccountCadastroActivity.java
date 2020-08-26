package com.rantas.bankfinalproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.rantas.bankfinalproject.R;
import com.rantas.bankfinalproject.dao.Messenger;
import com.rantas.bankfinalproject.model.Account;
import com.rantas.bankfinalproject.model.User;
import com.rantas.bankfinalproject.repository.AccountRepo;
import com.rantas.bankfinalproject.repository.RequestResult;

import static com.rantas.bankfinalproject.activities.MainActivity.HEADER_SHARED;

public class AccountCadastroActivity extends AppCompatActivity {
    private String pws;
    private String cpf;
    private String titular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_cadastro);

        Intent intent = getIntent();
        String action = intent.getStringExtra("conta");

        SharedPreferences preferences = getSharedPreferences(HEADER_SHARED,MODE_PRIVATE);
        this.cpf= preferences.getString("cpf","");
        this.pws=preferences.getString("pws","");
        this.titular=preferences.getString("nome","");

        AccountRepo accountRepo = new AccountRepo();
        User user =new User();
        user.setCpf(cpf);
        user.setPws(pws);

        accountRepo.getBankAccount(new RequestResult() {

            @Override
            public <T> void successful(T result) {
                Account conta = (Account) result;
                TextView textView1 = findViewById(R.id.Titular);
                TextView textView2 = findViewById(R.id.cpf);
                TextView textView3 = findViewById(R.id.recebeContaCadastro);
                textView1.setText(titular);
                textView2.setText(cpf);
                textView3.setText(conta.toString());
            }

            @Override
            public void failureMessage(Messenger messenger) {
                Toast.makeText(AccountCadastroActivity.this, messenger.getFailureMessage() +
                        " code: " + String.valueOf(messenger.getErrorCode()), Toast.LENGTH_LONG).show();
                Log.d("FALHA",messenger.getFailureMessage() +
                        " code: " + String.valueOf(messenger.getErrorCode()));

            }
        },user);




    }
}