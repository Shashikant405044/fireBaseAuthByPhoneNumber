package com.example.firebaseapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.firebaseapp.database.FireBaseDB;
import com.example.firebaseapp.pojo.StudentResponse;
import com.example.firebaseapp.adapter.BatchCreatAdapter;
import com.example.firebaseapp.databinding.ActivityBatchListBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BatchListActivity extends AppCompatActivity {

    ActivityBatchListBinding binding;
    FireBaseDB fireBaseDB;
     ProgressDialog progressDialog;

    BatchCreatAdapter batchCreatAdapter;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBatchListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BatchListActivity.this.setTitle(" Department DashBoard");
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Batch List Loading ");
        progressDialog.setCancelable(false);
        progressDialog.show();
        fireBaseDB = new FireBaseDB();
        GetListData();

        binding.recyclerViewMain.setHasFixedSize(true);
        batchCreatAdapter = new BatchCreatAdapter(this);
        binding.recyclerViewMain.setAdapter(batchCreatAdapter);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

       // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.recyclerViewMain.setLayoutManager(staggeredGridLayoutManager);


    }

    private void GetListData() {

        fireBaseDB.get().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                progressDialog.hide();
                ArrayList<StudentResponse> stdarray = new ArrayList<>();
                for(DataSnapshot data : snapshot.getChildren())  {
                StudentResponse std = data.getValue(StudentResponse.class);
                stdarray.add(std);
            }
                batchCreatAdapter.setStudentResponses(stdarray);
                batchCreatAdapter.notifyDataSetChanged();

                }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressDialog.hide();
                Toast.makeText(BatchListActivity.this, "error"+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }








    public void fabclick(View view) {
        Intent intent = new Intent(BatchListActivity.this, BatchCreateActivity.class);
        startActivity(intent);
    }
}
