package com.example.jstcollectv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyCollections extends AppCompatActivity {

    private Button mViewColl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collections);

        mViewColl = findViewById(R.id.ViewCollectionBtn);

        mViewColl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyCollections.this,ViewCollections.class);
                startActivity(intent);
            }
        });





    }
}