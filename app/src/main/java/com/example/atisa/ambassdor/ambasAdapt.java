package com.example.atisa.ambassdor;

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

public  class ambasAdapt extends RecyclerView.Adapter<ambasAdapt.ViewHolder>{
    private List<ambass> listData;

    public ambasAdapt(List<ambass> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public  ambasAdapt.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_ambas,parent,false);
        return new  ambasAdapt.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  ambasAdapt.ViewHolder holder, int position) {
       ambass ld=listData.get(position);
        holder.college.setText(ld.getCollege());
        holder.name.setText(ld.getName());
        holder.batch.setText(ld.getBatch());
        holder.branch.setText(ld.getDept());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name,batch,branch,college;
        ImageView ui;
        public ViewHolder(View itemView) {
            super(itemView);

             college=itemView.findViewById(R.id.college);
            name=itemView.findViewById(R.id.asname);
            branch=itemView.findViewById(R.id.branch);
            batch=itemView.findViewById(R.id.batch);



        }
    }
}


