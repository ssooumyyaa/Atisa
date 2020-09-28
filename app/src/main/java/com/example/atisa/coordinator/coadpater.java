package com.example.atisa.coordinator;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atisa.R;
import com.squareup.picasso.Picasso;

import java.util.List;

class coadapter extends RecyclerView.Adapter<coadapter.ViewHolder>{
    private List<coord> listData;

    public coadapter(List<coord> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.coordinator_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         coord ld=listData.get(position);
        holder.mail.setText(ld.getEmail());
        holder.name.setText(ld.getName());
        holder.batch.setText(ld.getBatch());
        holder.branch.setText(ld.getBranch());
Picasso.get().load(ld.getPic()).into(holder.ui);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name,batch,branch,mail;
        ImageView ui;
        public ViewHolder(View itemView) {
            super(itemView);

            mail=itemView.findViewById(R.id.email);
            name=itemView.findViewById(R.id.coname);
            branch=itemView.findViewById(R.id.branch);
            batch=itemView.findViewById(R.id.batch);
             ui=itemView.findViewById(R.id.coimage);



        }
    }
}


