package com.example.atisa.notif;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.method.LinkMovementMethod;
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

import java.util.List;

public class messageAdapter extends RecyclerView.Adapter<messageAdapter.ViewHolder>{
    private List<mesaage> listData;
    Context mcontext;


    public messageAdapter(List<mesaage> listData, Context context) {

        this.listData = listData;
        this.mcontext=context;
    }

    @NonNull
    @Override
    public  messageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_notification,parent,false);
        return new  messageAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final messageAdapter.ViewHolder holder, int position) {
        mesaage d=listData.get(position);
        holder.title.setText(d.getTitle());
        holder.message.setText(d.getMessage());
        holder.link.setText(d.getLink());
       holder.link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = holder.link.getText().toString();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
               mcontext.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title,message,link;

        public ViewHolder(View itemView) {
            super(itemView);

             title=itemView.findViewById(R.id.title);
             message=itemView.findViewById(R.id.descript);
            link=itemView.findViewById(R.id.link);
            link.setMovementMethod(LinkMovementMethod.getInstance());











        }
    }
}
