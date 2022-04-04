package com.example.firebaseapp.view;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.firebaseapp.R;
import com.example.firebaseapp.database.FireBaseCreateStudentDb;
import com.example.firebaseapp.databinding.ActivityAddStudentBinding;
import com.example.firebaseapp.pojo.AddStudentListresponse;
import com.example.firebaseapp.pojo.StudentResponse;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class AddStudentActivity extends AppCompatActivity  {

    ActivityAddStudentBinding binding;
    FireBaseCreateStudentDb fireBaseCreateStudentDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fireBaseCreateStudentDb = new FireBaseCreateStudentDb();
        AddStudentData();
    }

    private void AddStudentData() {
        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddStudentListresponse response = new AddStudentListresponse();
                response.setName_student(binding.fName.getText().toString());
                response.setRegNo_student(binding.RollNO.getText().toString());
                response.setMobileNo_student(binding.phoneNo.getText().toString());
                response.setEmailNo(binding.emailId.getText().toString());
                fireBaseCreateStudentDb.addData(response).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddStudentActivity.this, "Data Inserted SuccessFully", Toast.LENGTH_SHORT).show();
                        finish();

                    }



                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddStudentActivity.this, "Data Not  Inserted SuccessFully" + e.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                });

            }
        });
    }

}
