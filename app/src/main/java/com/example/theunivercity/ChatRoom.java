package com.example.theunivercity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ChatRoom extends AppCompatActivity {
    private DatabaseReference myRef ;
    private int id ;
    private String sendBy ;
    private EditText text;
    private Message message ;
    private List<Message> list ;
    private AdapterMessage adapterMessage ;
    private ListView listMessages ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);

        Intent intent = getIntent();

        id =intent.getIntExtra("idS",0);
        sendBy= intent.getStringExtra("sendBy");
        text = findViewById(R.id.messageSending);

        setProductList();
    }

    private void setProductList (){

        myRef= FirebaseDatabase.getInstance().getReference() ;

        listMessages = findViewById(R.id.messagesList);

        list = new ArrayList<>();

        adapterMessage = new AdapterMessage(this,R.layout.message_item ,list);

        message = new Message();

        myRef.child("Messages").child("roomT"+id).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                    message = dataSnapshot1.getValue(Message.class);

                    list.add(message);

                    listMessages.setAdapter(adapterMessage);
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    public void send(View view) {
        Calendar c = Calendar.getInstance();
        String time=c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE);
        myRef.child("Messages").child("roomT"+id).push().setValue(new Message(000,000, text.getText().toString(),sendBy,time));
    text.setText("");
    }



}
