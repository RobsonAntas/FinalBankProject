package com.rantas.bankfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.rantas.bankfinalproject.dao.Messenger;
import com.rantas.bankfinalproject.model.User;
import com.rantas.bankfinalproject.repository.RequestResult;
import com.rantas.bankfinalproject.repository.UserRepo;

import static com.rantas.bankfinalproject.MainActivity.HEADER_SHARED;

public class UserCadastroActivity extends AppCompatActivity {

    private String pws;
    private String cpf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_cadastro);

        Intent intent = getIntent();
        String mostra = intent.getStringExtra("cadastro");

        SharedPreferences preferences = getSharedPreferences(HEADER_SHARED,MODE_PRIVATE);
        this.cpf= preferences.getString("cpf","");
        this.pws=preferences.getString("pws","");

        UserRepo userRepo = new UserRepo();
        User user =new User();
        user.setCpf(cpf);
        user.setPws(pws);
        userRepo.getBankUser(new RequestResult() {

            @Override
            public <T> void successful(T result) {
                User user1 = (User) result;
                TextView textView = findViewById(R.id.recebeUserCadastro);
                textView.setText(user1.toString());
            }

            @Override
            public void failureMessage(Messenger messenger) {
                Toast.makeText(UserCadastroActivity.this, messenger.getFailureMessage() +
                        " code: " + String.valueOf(messenger.getErrorCode()), Toast.LENGTH_LONG).show();
                Log.d("FALHA",messenger.getFailureMessage() +
                        " code: " + String.valueOf(messenger.getErrorCode()));

            }
        },user);

    }
}