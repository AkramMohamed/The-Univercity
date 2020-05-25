package com.example.theunivercity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    }
}
