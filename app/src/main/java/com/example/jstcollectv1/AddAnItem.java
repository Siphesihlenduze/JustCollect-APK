package com.example.jstcollectv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddAnItem extends AppCompatActivity {

    private Button mAddExistCollection;
    private Button mAddNewCollection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_an_item);

        mAddExistCollection = findViewById(R.id.AddToExistingCollectionBtn);
        mAddNewCollection = findViewById(R.id.CreateNewCollectionBtn);

        mAddExistCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddAnItem.this,AddNewItemToCat.class);
                startActivity(intent);
            }
        });

        mAddNewCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddAnItem.this,NewCollection.class);
                startActivity(intent);
            }
        });

    }
}