package com.sunil.firebasedemoapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    productAdapter adapter;
    List<Product> productList;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_add,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemAdd:
                OpenAct();
        }
        return super.onOptionsItemSelected(item);
    }

    public void OpenAct(){
        Intent intent;
        intent = new Intent(MainActivity.this,InputActivity.class);
        startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productList=new ArrayList<>();


       //DatabaseReference dbreference= FirebaseDatabase.getInstance().getReference("Users");
       DatabaseReference dbreference= FirebaseDatabase.getInstance().getReference();





        //nhdfajfja
        dbreference.child("Users").limitToLast(10).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    productList.clear();

                    for(DataSnapshot productsnapshot:dataSnapshot.getChildren()){
                        Product p=productsnapshot.getValue(Product.class);
                        productList.add(p);
                    }
                    adapter=new productAdapter(MainActivity.this,productList);
                    recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }
}
