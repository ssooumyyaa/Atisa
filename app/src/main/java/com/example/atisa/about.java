package com.example.atisa;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class about extends AppCompatActivity {
    ImageView img;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        img=findViewById(R.id.image);
        CollapsingToolbarLayout collapsingToolbarLayout= findViewById(R.id.collapseActionView);
        collapsingToolbarLayout.setTitle("Rules");

        txt=findViewById(R.id.txt);


        String txtun1=getIntent().getExtras().getString("rules");
        txt.setText(txtun1);


        Picasso.get().load(getIntent().getExtras().getString("pic")).into(img);


    }
}
