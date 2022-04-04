package com.example.firebaseapp.database;

import com.example.firebaseapp.pojo.AddStudentListresponse;
import com.example.firebaseapp.pojo.StudentResponse;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class FireBaseCreateStudentDb {


    private final DatabaseReference databaseReference1;

    public FireBaseCreateStudentDb() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference1 = firebaseDatabase.getReference(FireBaseCreateStudentDb.class.getSimpleName());

    }



    public Task<Void> addData(AddStudentListresponse studentInfo) {

        return databaseReference1.push().setValue(studentInfo);

    }

    public Query getData() {
        return databaseReference1.orderByKey();

    }
}