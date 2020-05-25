package com.example.theunivercity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DirectorHome extends AppCompatActivity {
    Button accountsManagement ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_director_home);
        accountsManagement = findViewById(R.id.accountsManagementButton);
        accountsManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DirectorHome.this , ComptesList.class);
                startActivity(intent);
            }
        });
    }
}
