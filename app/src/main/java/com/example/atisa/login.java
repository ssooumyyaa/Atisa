package com.example.atisa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class login extends AppCompatActivity {
    private EditText Umail, Upass;
    private ProgressBar loadp;
    private Button btn,btn2;
    private FirebaseAuth auth;
    private Intent MainActivity1;
    TextView fp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_login);
        Umail = findViewById(R.id.regMail);
        Upass = findViewById(R.id.pass);
        btn = findViewById(R.id.button);
        btn2=findViewById(R.id.button2);

        fp=findViewById(R.id.fp);
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in1=new Intent(login.this,Pass.class);
                startActivity(in1);
                finish();
            }
        });
        loadp = findViewById(R.id.progressBar);
        MainActivity1= new Intent(this,com.example.atisa.Feed.class);
        loadp.setVisibility(View.INVISIBLE);
        auth=FirebaseAuth.getInstance();
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(login.this,RegisterAct.class);
                startActivity(in);
                finish();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn.setVisibility(View.INVISIBLE);
                loadp.setVisibility(View.VISIBLE);
                final String email = Umail.getText().toString();
                final String pass = Upass.getText().toString();

                if (email.isEmpty() || pass.isEmpty()) {
                    showmsg("Please Verify All Fields");
                    btn.setVisibility(View.VISIBLE);
                    loadp.setVisibility(View.INVISIBLE);
                } else {
                    SignIn(email, pass);
                }


            }
        });
    }

    private void SignIn(String mail, String password)
    {
        auth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    loadp.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.INVISIBLE);
                    checkEmailVerification();
                }
                else
                {
                    showmsg(task.getException().getMessage());
                    btn.setVisibility(View.VISIBLE);
                    loadp.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private void updateUI() {
        startActivity(MainActivity1);
        finish();
    }

    private void showmsg(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=auth.getCurrentUser();
        if(user!=null)
        {
            updateUI();
        }
    }
    private void checkEmailVerification()
    {
        FirebaseUser firebaseUser=auth.getInstance().getCurrentUser();
        Boolean emailFlag =firebaseUser.isEmailVerified();
        if(emailFlag)
        {
            updateUI();
        }
        else
        {
            showmsg("Verify your Email");
            auth.signOut();
        }
    }
}
