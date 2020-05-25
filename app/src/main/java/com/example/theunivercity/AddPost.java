package com.example.theunivercity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class AddPost extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
EditText titleP , textP;
Spinner spinner ;
String speciality;
    DatabaseReference myRef ;
private  Button addP , back ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        spinner = findViewById(R.id.spinnerPost);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.postSpeciality,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        titleP = findViewById(R.id.titlePostAdd);
        textP = findViewById(R.id.textPostAdd);
        addP= findViewById(R.id.addPost);
        back = findViewById(R.id.back);

        myRef = FirebaseDatabase.getInstance().getReference() ;

        Intent intent = getIntent();
        final int idP =intent.getIntExtra("idP",0);
        addP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                String time=c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE);
                myRef.child("Posts").push().setValue(new Post(idP,time,speciality,titleP.getText().toString(),
                        textP.getText().toString(),0,0,""));
                finish();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        speciality = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
