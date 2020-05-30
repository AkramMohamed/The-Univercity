package com.example.theunivercity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {
    Button dirButton, teamButton, stdButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dirButton = findViewById(R.id.directorLogin);
        teamButton = findViewById(R.id.listeningTeamLogin);
        stdButton = findViewById(R.id.studentLogin);

        dirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , DirectorHome.class);
                startActivity(intent);
            }
        });

        teamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , TeamHome.class);
                startActivity(intent);
            }
        });

        stdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentLoginDialog();
            }
        });
    }

    DatabaseReference myRef ;
    Compte compte ;
    private void StudentLoginDialog() {
        final Dialog myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.student_login_dialog);
        myDialog.setCancelable(false);
        myDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Button login = myDialog.findViewById(R.id.studentLoginBtn);
        Button back = myDialog.findViewById(R.id.studentBackBtn);

        final EditText username = myDialog.findViewById(R.id.stdUsername);
        final EditText password = myDialog.findViewById(R.id.stdPassword);
        myDialog.show();

        compte = new Compte();
        myRef = FirebaseDatabase.getInstance().getReference();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Query query = myRef.child("Comptes").orderByChild("username").equalTo(username.getText().toString());
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot :dataSnapshot.getChildren()){

                            compte = snapshot.getValue(Compte.class);

                            if (compte.getPassword().equals( password.getText().toString())){
                                Toast.makeText(MainActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this,StudentHome.class);
                                intent.putExtra("idStd",compte.getId());
                                intent.putExtra("sendeBy",compte.getUsername());
                                startActivity(intent);
                            }else {
                                Toast.makeText(MainActivity.this, "Wrong password", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(MainActivity.this, "Wrong username", Toast.LENGTH_SHORT).show();
                    }
                });




            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
    }
}
