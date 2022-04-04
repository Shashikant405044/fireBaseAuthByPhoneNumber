package com.example.firebaseapp.database;

import com.example.firebaseapp.pojo.StudentResponse;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class FireBaseDB {
    private final DatabaseReference databaseReference;
    public FireBaseDB() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference(StudentResponse.class.getSimpleName());

    }


public Task<Void> add(StudentResponse studentInfo) {

    return databaseReference.push().setValue(studentInfo);

}
public Query get()
{
    return databaseReference.orderByKey();

}



// second Table

}
