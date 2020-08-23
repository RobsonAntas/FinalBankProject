package com.rantas.bankfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.rantas.bankfinalproject.dao.Messenger;
import com.rantas.bankfinalproject.model.Account;
import com.rantas.bankfinalproject.model.User;
import com.rantas.bankfinalproject.routerRepo.AccountRepo;
import com.rantas.bankfinalproject.routerRepo.RequestResult;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private RecyclerView recyclerView;
//    private RecyclerView.LayoutManager layoutManager;
//    private _1stAdapter adapter;
//    private List<String> list;
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._1stlinear_layout);

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

        AccountRepo accountRepo = new AccountRepo();
        accountRepo.getBankAccount(new RequestResult() {
            @Override
            public <T> void successful(T result) {
                Account account = (Account) result;
                TextView textView1 = (TextView)findViewById(R.id.numeroCC);
                textView1.setText(account.getCode());

                TextView textView2 = (TextView)findViewById(R.id.numeroCpf);
                textView2.setText(account.getUser());

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

//        this.list = new ArrayList<>();
//        this.list.add("Pagar");
//        this.list.add("Transferir");
//        this.list.add("Depósito");
//        this.list.add("Extrato");
//
//        this.recyclerView = findViewById(R.id._1stRecycler);
//        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        this.adapter = new _1stAdapter(this,this.list);
//        this.recyclerView.setAdapter(this.adapter);
    }
}