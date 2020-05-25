package com.example.theunivercity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TeamPosts extends AppCompatActivity {
    ListView listPosts ;
    List<Post> list ;
    AdapterPost adapterPost ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_posts);

        listPosts = findViewById(R.id.postsLV);
        list = new ArrayList<>();

        list.add(new Post(1,"10/10 2:30","haha","important!..","Can I do anything whit my android studio !!?"));
        list.add(new Post(1,"10/12 2:30","hem","days..","no of course you can't :D"));
        adapterPost = new AdapterPost(this,R.layout.post_item,list);

        listPosts.setAdapter(adapterPost);
    }

    public void addPost(View view) {
    }
}
