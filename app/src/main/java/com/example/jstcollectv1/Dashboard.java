package com.example.jstcollectv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    private Button mAddNewItem;
    private Button mCollections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mAddNewItem = findViewById(R.id.AddItemBtn);
        mCollections = findViewById(R.id.MyCollectionsBtn);

        mAddNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,AddAnItem.class);
                startActivity(intent);
            }
        });

        mCollections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,MyCollections.class);
                startActivity(intent);
            }
        });

    }
}