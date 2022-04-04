package com.example.firebaseapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.firebaseapp.database.FireBaseDB;
import com.example.firebaseapp.pojo.StudentResponse;
import com.example.firebaseapp.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
public class BatchCreateActivity extends AppCompatActivity {
     ActivityMainBinding binding;
     FireBaseDB fireBaseDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BatchCreateActivity.this.setTitle("Add Batch Name ");
        fireBaseDB = new FireBaseDB();
        InsertData();

    }

    private void InsertData() {
        binding.createBatch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    StudentResponse response = new StudentResponse();
                    response.setBatchName(binding.batchName.getText().toString());
                    response.setBatchSubject(binding.subName.getText().toString());
                    fireBaseDB.add(response).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(BatchCreateActivity.this, "Data Inserted SuccessFully", Toast.LENGTH_SHORT).show();
                            finish();

                        }



                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(BatchCreateActivity.this, "Data Not  Inserted SuccessFully" + e.getMessage(), Toast.LENGTH_SHORT).show();

                        }

                    });

                }
            });
        }





    public boolean isValid(){
        return !binding.batchName.getText().toString().isEmpty() && !binding.subName.getText().toString().isEmpty();
    }



}