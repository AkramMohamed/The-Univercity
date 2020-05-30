package com.example.theunivercity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentHome extends AppCompatActivity {
    private Button message , posts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);
        message = findViewById(R.id.messageStudent);
        posts = findViewById(R.id.postsStudent);

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent() ;
                int idStd =intent1.getIntExtra("idStd",0);
                String sendBy = intent1.getStringExtra("sendeBy");
                Intent intent2 = new Intent(StudentHome.this,ChatRoom.class);
                intent2.putExtra("idS",idStd);
                intent2.putExtra("sendBy",sendBy);

                startActivity(intent2);
            }
        });

        posts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentHome.this,StudentPosts.class);
            }
        });
    }
}
