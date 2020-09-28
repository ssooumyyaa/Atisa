package com.example.atisa.coordinator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.atisa.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class coordinator extends AppCompatActivity {
            private List<coord> listData;
            private RecyclerView rv;
            ProgressBar pb;
             coadapter adapter;
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_coordinator);
                rv=(RecyclerView)findViewById(R.id.recyclerView);
                pb=findViewById(R.id.pb);
                rv.setHasFixedSize(true);
                rv.setLayoutManager(new LinearLayoutManager(this));
                listData=new ArrayList<>();

                final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("coordinators");
                nm.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()){
                            for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                                coord l=npsnapshot.getValue(coord.class);
                                listData.add(l);
                            }
                            adapter= new coadapter(listData);
                            rv.setAdapter(adapter);
                            pb.setVisibility(View.INVISIBLE);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        }

