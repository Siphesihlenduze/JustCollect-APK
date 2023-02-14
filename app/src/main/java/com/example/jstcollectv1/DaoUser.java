package com.example.jstcollectv1;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DaoUser {

    private DatabaseReference databaseReference;
    public DaoUser()

    {

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(User.class.getSimpleName());
    }

    public Task<Void> add (User user){

        return databaseReference.push().setValue(user);
    }

    public Task<Void> update (String key, HashMap<String, Object> hashMap){

        return databaseReference.child(key).updateChildren(hashMap);

    }



}
