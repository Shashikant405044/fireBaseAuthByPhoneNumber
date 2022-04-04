package com.example.firebaseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebaseapp.view.BatchDetailsActivity;
import com.example.firebaseapp.R;
import com.example.firebaseapp.pojo.StudentResponse;

import java.util.ArrayList;

public class BatchCreatAdapter extends RecyclerView.Adapter<BatchCreatAdapter.MyViewHolder> {

   private final Context context;
     ArrayList<StudentResponse> studentResponses = new ArrayList<>();

    public BatchCreatAdapter(Context context) {
        this.context = context;
       // this.studentResponses = studentResponses;
    }

    public void setStudentResponses(ArrayList<StudentResponse> studentResponses) {
        this.studentResponses = studentResponses;
    }

    @NonNull
    @Override
    public BatchCreatAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.create_batch_item_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BatchCreatAdapter.MyViewHolder holder, int position) {
         StudentResponse studentResponseList =  studentResponses.get(position);
         holder.batchName.setText(studentResponseList.getBatchName());
         holder.subName.setText(studentResponseList.getBatchSubject());
         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(view.getContext(), BatchDetailsActivity.class);
                 intent.putExtra("batch_name", studentResponseList.getBatchName());
                 intent.putExtra("batch_sub", studentResponseList.getBatchSubject());
                 context.startActivity(intent);

             }
         });
    }

    @Override
    public int getItemCount() {
        return studentResponses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView batchName, subName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            subName = itemView.findViewById(R.id.subjectName_adapter);
            batchName = itemView.findViewById(R.id.className_adapter);



        }
    }
}
