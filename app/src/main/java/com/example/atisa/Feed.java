package com.example.atisa;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.example.atisa.ambassdor.AmbassAct;
import com.example.atisa.artGallery.galleryAct;
import com.example.atisa.coordinator.coordinator;
import com.example.atisa.notif.notification;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.palette.graphics.Palette;

import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class Feed extends AppCompatActivity {
    private ViewFlipper simpleViewFlipper;

    private Context mContext;
    private float initialX;
    GridLayout mainGrid8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window w = getWindow();
        mContext = this;
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_feed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mainGrid8 = (GridLayout) findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid8);
        toolbar.setTitle("ATISA'20");
        CollapsingToolbarLayout collapsingToolbarLayout= findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle("ATISA'20");

        simpleViewFlipper = (ViewFlipper) findViewById(R.id.simpleViewFlipper); // get the reference of ViewFlipper


        // Declare in and out animations and load them using AnimationUtils class
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        // set the animation type's to ViewFlipper
        simpleViewFlipper.setInAnimation(in);
        simpleViewFlipper.setOutAnimation(out);
        // set interval time for flipping between views
        simpleViewFlipper.setFlipInterval(3000);
        // set auto start for flipping between views
        simpleViewFlipper.setAutoStart(true);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_feed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            FirebaseAuth.getInstance().signOut();
            Intent signout=new Intent(getApplicationContext(),login.class);
            startActivity(signout);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    private void setSingleEvent(GridLayout mainGrid5) {
        for (int i = 0; i < mainGrid5.getChildCount(); i++) {
            CardView cardview = (CardView) mainGrid5.getChildAt(i);
            final int finall = 0;
            final int finalI = i;
            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (0 == finalI) {
                        Intent intent = new Intent(Feed.this,aboutus.class);
                        startActivity(intent);

                    } else if (1 == finalI) {
                        Intent intent = new Intent(Feed.this,Event_list.class);
                        startActivity(intent);
                    } else if (2 == finalI) {
                        Toast toast=Toast. makeText(getApplicationContext(),"We Will Notify You",Toast. LENGTH_SHORT);
                        toast. setMargin(50,50);
                        toast. show();

                    } else if (3 == finalI) {
                        Intent intent = new Intent(Feed.this, notification.class);
                        startActivity(intent);
                    } else if (4 == finalI) {
                        Intent intent = new Intent(Feed.this, coordinator.class);
                        startActivity(intent);
                    } else if (5 == finalI) {
                        Intent intent = new Intent(Feed.this, AmbassAct.class);
                        startActivity(intent);
                    }
                    else if (6 == finalI) {
                        Intent intent = new Intent(Feed.this, galleryAct.class);
                        startActivity(intent);
                    }
                    else if (7== finalI) {
                        Toast toast = Toast.makeText(getApplicationContext(), "We Will Notify You", Toast.LENGTH_SHORT);
                        toast.setMargin(50, 50);
                        toast.show();
                    }
                    else if (8== finalI) {
                        Intent intent = new Intent(Feed.this,feedback.class);
                        startActivity(intent);

                    }
                    }
            });
        }
    }
}

