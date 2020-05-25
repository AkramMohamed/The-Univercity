package com.example.theunivercity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TeamPosts extends AppCompatActivity {
    ListView listPosts ;
    List<Post> list ;
    AdapterPost adapterPost ;
    DatabaseReference myRef ;
    Post post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_posts);

       setProductList();


    }

    private void setProductList (){

        listPosts = findViewById(R.id.postsLV);
        list = new ArrayList<>();


        adapterPost = new AdapterPost(this,R.layout.post_item,list);


        myRef = FirebaseDatabase.getInstance().getReference();
        //myRef.child("Comptes").keepSynced(true);

        post = new Post( );


        myRef.child("Posts").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                    post = dataSnapshot1.getValue(Post.class);
                    list.add(post);

                    listPosts.setAdapter(adapterPost);

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

int id ;
    public void addPost(View view) {
        Intent intent = new Intent(TeamPosts.this , AddPost.class);
        if (list.isEmpty()){id = 1 ;}else {id = list.size();}
        intent.putExtra("idP",id);
        startActivity(intent);
    }
}
