package com.example.theunivercity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;



public class ComptesListTeam extends AppCompatActivity {
   private ListView comptesList ;
   private List<Compte> list ;
   private AdapterCompte adapterCompte ;
   private DatabaseReference myRef ;
   private Compte compte ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comptes_list);

        setProductList();
        comptesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ComptesListTeam.this,ChatRoom.class);
                intent.putExtra("idS",list.get(position).getId());
                intent.putExtra("sendBy","Listening Team");
                startActivity(intent);
            }
        });
    }


    private void setProductList (){
        comptesList = findViewById(R.id.comptesListView);
        list = new ArrayList<Compte>();
        adapterCompte = new AdapterCompte(this,R.layout.compte_item, list );

        myRef = FirebaseDatabase.getInstance().getReference();

        compte = new Compte();


        myRef.child("Comptes").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                    compte = dataSnapshot1.getValue(Compte.class);
                    list.add(compte);

                    comptesList.setAdapter(adapterCompte);

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

}

