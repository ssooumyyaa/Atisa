package com.example.atisa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Pass extends AppCompatActivity {
    private EditText mail;
    private Button btn;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        setContentView(R.layout.activity_pass);
        btn=findViewById(R.id.button3);
        mail=findViewById(R.id.editText);
        auth=FirebaseAuth.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String umail=mail.getText().toString().trim();
                if(mail.equals(""))
                {
                    Toast.makeText(Pass.this,"Please Enter Your Registered Email Id",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    auth.sendPasswordResetEmail(umail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(Pass.this,"Email Send",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(Pass.this,login.class));
                            }
                        }
                    });
                }
            }
        });
    }
}

