package com.example.atisa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegisterAct extends AppCompatActivity {
    ImageView userpic;
    static int PReqCode=1,REQUESCODE=1;
    Uri pickedImgUri;
    private FirebaseAuth auth;
    private EditText Uname,Umail,Upass,Upass2,Uclg;
    private ProgressBar loadp;
    private Button btn;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_register);
        Uname=findViewById(R.id.regName);
        Umail=findViewById(R.id.regMail);
        Upass=findViewById(R.id.pass);
        Upass2=findViewById(R.id.regpassn);
        Uclg=findViewById(R.id.regclg);
        btn=findViewById(R.id.button);

        loadp=findViewById(R.id.progressBar);
        loadp.setVisibility(View.INVISIBLE);

        auth=FirebaseAuth.getInstance();

        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       btn.setVisibility(View.INVISIBLE);
                                       loadp.setVisibility(View.VISIBLE);
                                       final String email=Umail.getText().toString();
                                       final String name=Uname.getText().toString();
                                       final String pass=Upass.getText().toString();
                                       final String pass2=Upass2.getText().toString();
                                       final String clg=Uclg.getText().toString();

                                       if(email.isEmpty()|| name.isEmpty()||pass.isEmpty()||  !pass.equals(pass2)||clg.isEmpty())
                                       {
                                           showmsg("Please Verify All Fields");
                                           btn.setVisibility(View.VISIBLE);
                                           loadp.setVisibility(View.INVISIBLE);
                                       }
                                       else if(pass.length()< 6){
                                           showmsg("Password Must Have 6 Character");
                                           btn.setVisibility(View.VISIBLE);
                                           loadp.setVisibility(View.INVISIBLE);

                                       }
                                       else
                                       {
                                           createAccount(email,name,clg,pass);
                                       }


                                   }
                               }
        );
        userpic=findViewById(R.id.regUserPic);


    }


    private void createAccount(final String mail, final String name, final String clg, String pass)
    {
        auth.createUserWithEmailAndPassword(mail,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            showmsg("Account Created");
                            FirebaseUser firebaseUser=auth.getCurrentUser();
                            String userid=firebaseUser.getUid();
                            reference=FirebaseDatabase.getInstance().getReference().child("users").child(userid);
                            HashMap<String,Object> hashMap= new HashMap<>();
                            hashMap.put("id",userid);
                            hashMap.put("username",name);
                            hashMap.put("Email",firebaseUser.getEmail());
                            hashMap.put("college",clg);

                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful())
                                    {
                                        sendEmailVerif();
                                    }
                                }
                            });

                        }
                        else
                        {
                            showmsg("account creation failed"+task.getException().getMessage());
                            btn.setVisibility(View.VISIBLE);
                            loadp.setVisibility(View.INVISIBLE);
                        }
                    }


                });

    }


    private void updateUI() {
        Intent hm= new Intent(RegisterAct.this,login.class);
        startActivity(hm);
        finish();
    }


    private void showmsg(String msg)
    {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }


    private void sendEmailVerif()
    {
        FirebaseUser firebaseUser=auth.getCurrentUser();
        if (firebaseUser!=null)
        {
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful())
                    {
                        showmsg("Successfully Registered , Verification mail sent");
                        auth.signOut();
                        updateUI();
                    }
                    else{
                        showmsg("Verification mail has not been sent");
                    }
                }
            });
        }

    }

}