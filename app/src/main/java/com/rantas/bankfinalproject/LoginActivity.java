package com.rantas.bankfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rantas.bankfinalproject.dao.Messenger;
import com.rantas.bankfinalproject.model.User;
import com.rantas.bankfinalproject.repository.RequestResult;
import com.rantas.bankfinalproject.repository.UserRepo;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn = (Button) findViewById(R.id.Btnlogin);

        btn.setOnClickListener(new View.OnClickListener() {
            TextView textView1 = findViewById(R.id.personName);
            TextView textView2 = findViewById(R.id.textPassword);
            User user1 = new User();
            @Override
            public void onClick(View view) {

                user1.setCpf(textView1.getText().toString());
                user1.setPws(textView2.getText().toString());

                UserRepo userRepo = new UserRepo();
                userRepo.getBankUser(new RequestResult() {
                    @Override
                    public <T> void successful(T result) {
                        User user = (User) result;
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        Log.d("fetch data",user.toString());
                        intent.putExtra("user",user);
                        startActivity(intent);
                    }

                    @Override
                    public void failureMessage(Messenger messenger) {
                        Toast.makeText(LoginActivity.this,messenger.getFailureMessage()+
                                " code: "+String.valueOf(messenger.getErrorCode()),Toast.LENGTH_LONG).show();
                    }
                },user1);
            }
        });
    }
}