package com.rantas.bankfinalproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rantas.bankfinalproject.ActionsActivity;
import com.rantas.bankfinalproject.R;

import java.util.List;

public class RecyclerAdapterF1 extends RecyclerView.Adapter<RecyclerAdapterF1.ViewHolder>{
    private Context context;
    private List<String> menuOptions;
    private LayoutInflater layoutInflater;

    public RecyclerAdapterF1(Context context, List<String> menuOptions) {
        this.context =context;
        this.layoutInflater = LayoutInflater.from(this.context);
        this.menuOptions =menuOptions;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        LinearLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.recyclerText);
            layout=(LinearLayout) itemView.findViewById(R.id.layoutInflated);

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent mIntent = new Intent(context, ActionsActivity.class);
                    context.startActivity(mIntent);
                }
            });
        }


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.inflatedview_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String option = menuOptions.get(position);
        holder.textView.setText(option);
    }

    @Override
    public int getItemCount() {
        return menuOptions.size();
    }
}
