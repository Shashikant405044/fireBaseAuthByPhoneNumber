package com.example.firebaseapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.firebaseapp.R;
import com.example.firebaseapp.databinding.ActivityBatchDetailsBinding;

public class BatchDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityBatchDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBatchDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addStudents.setOnClickListener(this);

        Intent intent = getIntent();

        String BatchName = intent.getStringExtra("batch_name");
        String BatchSub = intent.getStringExtra("batch_sub");
        binding.batchNameDetails.setText(BatchName);
        binding.batchSubDetails.setText(BatchSub);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.add_students:

                Intent intent = new Intent(BatchDetailsActivity.this, AddStudentActivity.class);
                startActivity(intent);
                break;
        }
    }
}