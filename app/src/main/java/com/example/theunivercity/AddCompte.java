package com.example.theunivercity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class AddCompte extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner ;
    EditText firstName , familyName , password ;
    String speciality ;
    DatabaseReference myRef ;
    Button add , back ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_compte);
        firstName = findViewById(R.id.firstNameAdd);
        familyName = findViewById(R.id.familyNameAdd);
        password = findViewById(R.id.passwordAdd);
        add = findViewById(R.id.btnProductAdd);
        back = findViewById(R.id.back);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.speciality,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        myRef = FirebaseDatabase.getInstance().getReference() ;

        Intent intent = getIntent();
        final int id =intent.getIntExtra("id",0);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Comptes").push().setValue(new Compte(id,17172354,firstName.getText().toString(),familyName.getText().toString(),
                        speciality , password.getText().toString() ));
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
