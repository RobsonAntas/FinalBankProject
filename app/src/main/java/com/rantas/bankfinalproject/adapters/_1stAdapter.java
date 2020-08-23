package com.rantas.bankfinalproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rantas.bankfinalproject.R;

import java.util.List;

public class _1stAdapter extends RecyclerView.Adapter<_1stAdapter._1stHolder> {
    private List<String> list;
    private LayoutInflater layoutInflater;
    private Context context;

    public _1stAdapter(Context context, List<String> list) {
        this.context =context;
        this.list =list;
        this.layoutInflater = LayoutInflater.from(this.context);

    }

    public class _1stHolder extends RecyclerView.ViewHolder{

        TextView textView;
        public _1stHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.recyclerText);
        }
    }

    @NonNull
    @Override
    public _1stHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = this.layoutInflater.inflate(R.layout.inflatedview_layout,parent,false);
        return new _1stHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull _1stHolder holder, int position) {

        holder.textView.setText(this.list.get(position));
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
}
