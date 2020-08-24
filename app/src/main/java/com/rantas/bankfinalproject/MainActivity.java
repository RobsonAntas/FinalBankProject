package com.rantas.bankfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.rantas.bankfinalproject.adapters.PageAdapter;
import com.rantas.bankfinalproject.dao.Messenger;
import com.rantas.bankfinalproject.model.Account;
import com.rantas.bankfinalproject.model.User;
import com.rantas.bankfinalproject.repository.AccountRepo;
import com.rantas.bankfinalproject.repository.RequestResult;

public class MainActivity extends AppCompatActivity {
    public static final String HEADER_SHARED ="header";
    public SharedPreferences preferences;
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._1stlinear_layout);

        preferences = getSharedPreferences(HEADER_SHARED, Context.MODE_PRIVATE);

        this.textView = (TextView) findViewById(R.id.nomeCliente);
        this.imageView = (ImageView) findViewById(R.id._1stAvatar);


        Intent mIntent = getIntent();
        User user = (User) mIntent.getSerializableExtra("user");
        Log.d("user p/t main", user.toString());
        /* Se a url referenciando a imagem não for de uma imagem então --- SkImageDecoder::Factory returned null */
        String url = user.getAvatar();
        Log.d("url", url);
//        Picasso.get().load(url).into(imageView);
        this.textView.setText(user.getName());

        //O retorno da user da conta é o id e não o cpf, porisso sharedpreferance
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("cpf",user.getCpf());
        editor.putString("pws",user.getPws());
        editor.putString("nome",user.getName());
        editor.apply();

        AccountRepo accountRepo = new AccountRepo();
        accountRepo.getBankAccount(new RequestResult() {
            @Override
            public <T> void successful(T result) {
                Account account = (Account) result;
                TextView textView1 = (TextView)findViewById(R.id.numeroCC);
                textView1.setText(account.getCode());
                SharedPreferences.Editor editor1 = preferences.edit();
                editor1.putString("Nccorrente",account.getCode());
                editor1.apply();

                TextView textView2 = (TextView)findViewById(R.id.numeroCpf);
                textView2.setText(preferences.getString("cpf",""));
                Log.d("sharedPreferance",preferences.getString("cpf",""));
            }

            @Override
            public void failureMessage(Messenger messenger) {
                Toast.makeText(MainActivity.this,messenger.getFailureMessage()+
                        " code: "+String.valueOf(messenger.getErrorCode()),Toast.LENGTH_LONG).show();
            }
        },user);

        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(),this);
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(pageAdapter);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);


    }
}