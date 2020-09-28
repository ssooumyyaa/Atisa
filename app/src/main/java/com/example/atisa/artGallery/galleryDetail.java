package com.example.atisa.artGallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.atisa.R;
import com.squareup.picasso.Picasso;

public class galleryDetail extends AppCompatActivity {
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_detail);
        img=findViewById(R.id.image);
        Picasso.get().load(getIntent().getExtras().getString("pic")).into(img);
    }
}
