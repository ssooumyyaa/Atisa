package com.example.atisa.ambassdor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.atisa.R;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class AmbassAct extends AppCompatActivity {
    private List<ambass> listData;
    private RecyclerView rv;
    ProgressBar pb;
    EditText search;
    ambasAdapt adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambass);
        rv=(RecyclerView)findViewById(R.id.search_rv);
        search=findViewById(R.id.search_bar);
        pb=findViewById(R.id.pb);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        listData=new ArrayList<>();
        adapter=new ambasAdapt(listData);
        rv.setAdapter(adapter);
        readUser();
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                searchUsers(charSequence.toString().toLowerCase());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    private void readUser()
    {
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference("ambas");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(search.getText().toString().equals(""))
                {
                    listData.clear();
                    for(DataSnapshot snapshot:dataSnapshot.getChildren())
                    {
                        ambass User =snapshot.getValue(ambass.class);
                        listData.add(User);
                        pb.setVisibility(View.INVISIBLE);
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private void searchUsers(String s)
    {
        Query query=FirebaseDatabase.getInstance().getReference("ambas").orderByChild("college").startAt(s).endAt(s+"\uf8ff");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listData.clear();
                for (DataSnapshot snapshot: dataSnapshot.getChildren())
                {
                    ambass user=snapshot.getValue(ambass.class);
                    listData.add(user);
                }
                 adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}

