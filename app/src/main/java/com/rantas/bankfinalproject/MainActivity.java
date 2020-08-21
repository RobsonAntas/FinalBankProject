package com.rantas.bankfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private _1stAdapter adapter;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._1stlinear_layout);

        Intent mIntent = getIntent();

        list = new ArrayList<>();
        list.add("oi");
        list.add("como vai");
        list.add("Tudo bem");

        this.recyclerView = findViewById(R.id._1stRecycler);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.adapter = new _1stAdapter(this,this.list);
        this.recyclerView.setAdapter(this.adapter);
    }
}