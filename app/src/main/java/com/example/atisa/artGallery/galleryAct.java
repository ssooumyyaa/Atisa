package com.example.atisa.artGallery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Activity;
import android.os.Bundle;
import android.util.LayoutDirection;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.example.atisa.R;
import com.example.atisa.ambassdor.ambass;



import com.example.atisa.coordinator.coord;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;


public class galleryAct extends  AppCompatActivity {
    private List<gallery> listData,list2,list3,list4,list5;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView rpainting,rslogan,rpoetry,rphotography,rposter;
    Button poster,painting,photography,slogan,poetry;

    ProgressBar pb;
     galleryAdapt adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        rpainting=(RecyclerView)findViewById(R.id.imageList);
        rpoetry=(RecyclerView)findViewById(R.id.imageList2);
        rslogan=(RecyclerView)findViewById(R.id.imageList3);
        rphotography=(RecyclerView)findViewById(R.id.imageList4);
        rposter=(RecyclerView)findViewById(R.id.imageList5);

        poster=findViewById(R.id.poster);
        photography=findViewById(R.id.photograph);
        slogan=findViewById(R.id.slogan);
        poetry=findViewById(R.id.poetry);
        painting=findViewById(R.id.painting);
        pb=findViewById(R.id.pb);



        rpainting.setHasFixedSize(true);
        rposter.setHasFixedSize(true);
        rslogan.setHasFixedSize(true);
        rphotography.setHasFixedSize(true);
        rpoetry.setHasFixedSize(true);
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rposter.setLayoutManager(layoutManager);


        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rslogan.setLayoutManager(layoutManager);

        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rphotography.setLayoutManager(layoutManager);
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rpainting.setLayoutManager(layoutManager);
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rpoetry.setLayoutManager(layoutManager);



        listData=new ArrayList<>();
        list2=new ArrayList<>();
        list3=new ArrayList<>();
        list4=new ArrayList<>();
        list5=new ArrayList<>();
        slogan();
        painting();
        poetry();
        photography();
        poster();

        slogan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rphotography.setVisibility(View.GONE);
                rpoetry.setVisibility(View.GONE);
                rpainting.setVisibility(View.GONE);
                rposter.setVisibility(View.GONE);
                rslogan.setVisibility(View.VISIBLE);
            }
        });
         painting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rphotography.setVisibility(View.GONE);
                rpoetry.setVisibility(View.GONE);
                rslogan.setVisibility(View.GONE);
                rposter.setVisibility(View.GONE);
                rpainting.setVisibility(View.VISIBLE);
            }
        });
        photography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rpainting.setVisibility(View.GONE);
                rpoetry.setVisibility(View.GONE);
                rslogan.setVisibility(View.GONE);
                rposter.setVisibility(View.GONE);
                rphotography.setVisibility(View.VISIBLE);
            }
        });

        poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rphotography.setVisibility(View.GONE);
                rpoetry.setVisibility(View.GONE);
                rslogan.setVisibility(View.GONE);
                rpainting.setVisibility(View.GONE);
                rposter.setVisibility(View.VISIBLE);
            }
        });
        poetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rphotography.setVisibility(View.GONE);
                 rposter.setVisibility(View.GONE);
                rslogan.setVisibility(View.GONE);
                rpainting.setVisibility(View.GONE);
                rpoetry.setVisibility(View.VISIBLE);
            }
        });


    }

    private void poster() {
        final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("gallery").child("poster");
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                        gallery l=npsnapshot.getValue(gallery.class);
                        list2.add(l);
                        Collections.reverse(list2);
                    }
                    adapter= new galleryAdapt(list2,getApplicationContext());
                    rposter.setAdapter(adapter);
                    pb.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void photography() {
        final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("gallery").child("photography");
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                        gallery l=npsnapshot.getValue(gallery.class);
                        listData.add(l);
                        Collections.reverse(listData);
                    }
                    adapter= new galleryAdapt(listData,getApplicationContext());
                    rphotography.setAdapter(adapter);
                    pb.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void poetry() {
        final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("gallery").child("poetry");
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                        gallery l=npsnapshot.getValue(gallery.class);
                        list3.add(l);
                        Collections.reverse(list3);
                    }
                    adapter= new galleryAdapt(list3,getApplicationContext());
                    rpoetry.setAdapter(adapter);
                    pb.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void painting() {
        final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("gallery").child("painting");
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                        gallery l=npsnapshot.getValue(gallery.class);
                        list4.add(l);
                        Collections.reverse(list4);
                    }
                    adapter= new galleryAdapt(list4,getApplicationContext());
                    rpainting.setAdapter(adapter);
                    pb.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void slogan() {
        final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("gallery").child("slogan");
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                        gallery l=npsnapshot.getValue(gallery.class);
                        list5.add(l);
                        Collections.reverse(list5);
                    }
                    adapter= new galleryAdapt(list5,getApplicationContext());
                    rslogan.setAdapter(adapter);
                    pb.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


}






