package com.example.atisa.event_listFrag;

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
import com.example.atisa.about;
import com.example.atisa.coordinator.coord;
import com.squareup.picasso.Picasso;

import java.util.List;

class artistAdapter extends RecyclerView.Adapter<artistAdapter.ViewHolder>{
    private List<artist> listData;
    Context mcontext;

    public  artistAdapter(List<artist> listData, Context context) {
        this.listData = listData;
        this.mcontext=context;
    }

    @NonNull
    @Override
    public  artistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.artist_row,parent,false);
        return new  artistAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull artistAdapter.ViewHolder holder, int position) {
         artist ld=listData.get(position);
         Picasso.get().load(ld.getPic()).into(holder.ui);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name,pic,rules;
        ImageView ui;
        public ViewHolder(View itemView) {
            super(itemView);
            ui=itemView.findViewById(R.id.img);

             ui.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View view) {

                    Intent postDetailActivity = new Intent(mcontext, about.class);

                    int position = getAdapterPosition();

                    postDetailActivity.putExtra("name", listData.get(position).getName());

                    postDetailActivity.putExtra("pic", listData.get(position).getPic());

                    postDetailActivity.putExtra("rules",listData.get(position).getRules());



                    //    long timestamp  = (long) mData.get(position).getTimeStamp();

                    //  postDetailActivity.putExtra("postDate",timestamp) ;

                    mcontext.startActivity(postDetailActivity);

                }

            });




        }
    }
}