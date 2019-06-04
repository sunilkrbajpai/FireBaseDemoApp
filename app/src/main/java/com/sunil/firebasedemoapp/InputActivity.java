package com.sunil.firebasedemoapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Date;

public class InputActivity extends AppCompatActivity {

    private EditText name,age,rollno;
    private Button btn;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        name=(EditText)findViewById(R.id.name);
        age=(EditText)findViewById(R.id.Age);
        rollno=(EditText)findViewById(R.id.Rollno);
        btn=(Button)findViewById(R.id.btnSave);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Users");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddData();


                name.setText("");
                age.setText("");
                rollno.setText("");
            }
        });


    }
    public void AddData(){
        Date timenow= Calendar.getInstance().getTime();
        String Name=name.getText().toString().trim();
        String Date=timenow.toString();
        int RollNo= Integer.parseInt(rollno.getText().toString().trim());
        int Age=Integer.parseInt(age.getText().toString().trim());

        SaveData saveData=new SaveData(Name,Date,Age,RollNo);
        databaseReference.push().setValue(saveData);


       DatabaseReference dbref=FirebaseDatabase.getInstance().getReference();
       Query query=dbref.child("Users").limitToFirst(1);
       query.addListenerForSingleValueEvent(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               for(DataSnapshot snap:dataSnapshot.getChildren()){
                   snap.getRef().removeValue();
               }
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });
        Toast.makeText(getApplication()," Record Saved",Toast.LENGTH_LONG).show();
    }
}
