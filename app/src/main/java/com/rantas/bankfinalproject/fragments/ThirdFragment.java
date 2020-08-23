package com.rantas.bankfinalproject.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rantas.bankfinalproject.R;
import com.rantas.bankfinalproject.adapters.RecyclerAdapterF1;
import com.rantas.bankfinalproject.adapters.RecyclerAdapterF3;

import java.util.ArrayList;
import java.util.List;

public class ThirdFragment extends Fragment {
    private List<String> menuOptions;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.third_fragment,container,false);

        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id._3thRecycler);

        this.menuOptions = new ArrayList<>();
        menuOptions.add("Atualizar Cadastro");
        menuOptions.add("Abrir c. Corrente");
        menuOptions.add("Atualizar c. Corrente");
        menuOptions.add("Vizualisar todas as c. correntes");
        menuOptions.add("Vizualisar todos os clientes");

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        final RecyclerAdapterF3 adapter = new RecyclerAdapterF3(getContext(),this.menuOptions);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }
}
