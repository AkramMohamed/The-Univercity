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



public class ComptesList extends AppCompatActivity {
    ListView comptesList ;
    List<Compte> list ;
    AdapterCompte adapterCompte ;
    DatabaseReference myRef ;
    Compte compte ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comptes_list);

        setProductList();

    }


    private void setProductList (){
        comptesList = findViewById(R.id.comptesListView);
        list = new ArrayList<Compte>();
        adapterCompte = new AdapterCompte(this,R.layout.compte_item, list );

        myRef = FirebaseDatabase.getInstance().getReference();
        myRef.child("Comptes").keepSynced(true);

        compte = new Compte();


        myRef.child("Comptes").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               list.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                    compte = dataSnapshot1.getValue(Compte.class);
                    list.add(compte);
                    Toast.makeText(ComptesList.this, "wsal", Toast.LENGTH_SHORT).show();
                    comptesList.setAdapter(adapterCompte);

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }


    int id ;
    public void add(View view) {
       Intent intent = new Intent(ComptesList.this , AddCompte.class);
       if (list.isEmpty()){id = 1 ;}else {id = list.size();}
       intent.putExtra("id",id);
       startActivity(intent);
    }

}

