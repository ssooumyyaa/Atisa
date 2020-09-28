package com.example.atisa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class aboutus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Element versionElement = new Element();
        versionElement.setTitle("Version 1.0");



        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.atisa)
                .setDescription("In the Current Era of Advancement , Innovation And Leading edge, It is necessary to refurbish  the realistic methodologies.\n" +
                        "To Elevate the idea of  Valuable and  tenable growth,   ATISA- THE TECHNICAL FEST OF NCE is organising National Level Competition from 20 th May to 30th May 2020.  \n" +
                        "With Events aligning from gaming and photography to quizzes. ATISA  has events for everyone. The theme of Atisa'20 Is COVID-19. So,  Carve Up and Join the Events from May 20.\n\n Event Leader: Sumit Kumar  \nBranch:Computer Science & Engineering\n\n Developer: Soumya Sharma\n College:Nalanda College Of Engineering\n Branch:Computer Science & Engineering\nEmail:soumyabkp123@gmail.com")
                .addItem(versionElement)
                .addGroup("Connect with us")
                .addEmail("atisance.tcf@gmail.com ")
                .addFacebook("atisance")
                .addInstagram("atisa.nce")
                .addGitHub("ssooumyyaa")
                .addWebsite("https://atisance.netlify.app/")
                .addItem(createCopyright())
                .create();

        setContentView(aboutPage);
    }
    private Element  createCopyright()
    {
        Element copyright =new Element();
        final String copyrightString = String.format("Copyright (c) %d by Atisa", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightString);
        copyright.setIcon(R.mipmap.ic_launcher);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(aboutus.this,copyrightString,Toast.LENGTH_SHORT).show();
            }

        });
        return copyright;
    }
}
