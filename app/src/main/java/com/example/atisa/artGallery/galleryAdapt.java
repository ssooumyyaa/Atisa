package com.example.atisa.artGallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atisa.R;
import com.example.atisa.coordinator.coord;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

class galleryAdapt extends RecyclerView.Adapter<galleryAdapt.ViewHolder>{
    private List<gallery> listData;
    Context mcontext;

    public galleryAdapt(List<gallery> listData, Context context) {
        this.listData = listData;
        this.mcontext=context;
    }

    @NonNull
    @Override
    public galleryAdapt.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_row,parent,false);
        return new  galleryAdapt.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull galleryAdapt.ViewHolder holder, int position) {
         gallery ld=listData.get(position);

        holder.name.setText(ld.getName());
        holder.clg.setText(ld.getClg());
        Picasso.get().load(ld.getPic()).into(holder.ui);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name,clg;
        ImageView ui;
        public ViewHolder(View itemView) {
            super(itemView);
            clg=itemView.findViewById(R.id.clg);
             name=itemView.findViewById(R.id.photographer);
            ui=itemView.findViewById(R.id.image);

             ui.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View view) {

                    Intent postDetailActivity = new Intent(mcontext,galleryDetail.class);

                    int position = getAdapterPosition();



                    postDetailActivity.putExtra("pic",listData.get(position).getPic());


                    //    long timestamp  = (long) mData.get(position).getTimeStamp();

                    //  postDetailActivity.putExtra("postDate",timestamp) ;

                    mcontext.startActivity(postDetailActivity);

                }

            });


        }
    }
}

