package com.laundrrmast.codesoft.rr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseArtest;
    ListView listvieware;
    Query query;
    List<artest> AList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AList =new ArrayList<>();
        listvieware =(ListView) findViewById(R.id.listview11);
        databaseArtest = FirebaseDatabase.getInstance().getReference("ar");

        query= databaseArtest.orderByChild("artestName").equalTo("fares");




        Button b1=(Button) findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addart();
            }
        });

        Button b2=(Button) findViewById(R.id.button3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowSingalValue();
            }
        });

    }

    private void ShowSingalValue() {

        Query   mDatabase = databaseArtest.orderByChild("artestName").equalTo("fares").limitToFirst(1);

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot artSnapshot : dataSnapshot.getChildren()){

                String carid = artSnapshot.child("artestName").getValue().toString();
                Toast.makeText(MainActivity.this,carid,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
            }
        };
        mDatabase.addValueEventListener(postListener);

    }

    @Override
    protected void onStart() {
        super.onStart();



//        databaseArtest.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                AList.clear();
//                for(DataSnapshot artSnapshot : dataSnapshot.getChildren()){
//
//        artest artest00 = artSnapshot.getValue(artest.class);
//                    AList.add(artest00);
//                }
//artistlist adpter = new artistlist(MainActivity.this,AList);
//                listvieware.setAdapter(adpter);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });


        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                AList.clear();
                for(DataSnapshot artSnapshot : dataSnapshot.getChildren()){

        artest artest00 = artSnapshot.getValue(artest.class);
                    AList.add(artest00);
                }
artistlist adpter = new artistlist(MainActivity.this,AList);
                listvieware.setAdapter(adpter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //
            }
        };
        query.addValueEventListener(eventListener);
    }

    public void addart(){

       String id= databaseArtest.push().getKey();
artest aa = new artest(id,"fares","fa");
        databaseArtest.child(id).setValue(aa);
        Toast.makeText(this,"add",Toast.LENGTH_SHORT).show();

    }
}
