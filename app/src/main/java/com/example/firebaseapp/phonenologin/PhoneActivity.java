package com.example.firebaseapp.phonenologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.firebaseapp.databinding.ActivityPhoneBinding;
public class PhoneActivity extends AppCompatActivity {
    ActivityPhoneBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.ccp.registerCarrierNumberEditText(binding.t1);

        binding.senotpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhoneActivity.this,OtpActivity.class);
                intent.putExtra("mobile",binding.ccp.getFullNumberWithPlus().replace("",""));
                startActivity(intent);
            }
        });

    }
    }

