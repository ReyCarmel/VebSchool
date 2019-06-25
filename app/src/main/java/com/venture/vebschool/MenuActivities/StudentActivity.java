package com.venture.vebschool.MenuActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;

import com.venture.vebschool.Adapter.StudentDetailsAdapter;
import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;
import com.venture.vebschool.model.StudentModel;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<StudentModel> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_student);
            recyclerView = findViewById(R.id.recycler_view_student);
            arrayList = new ArrayList<StudentModel>();

            arrayList = DBTransactionFunctions.getStudentDetails();
            StudentDetailsAdapter studentDetailsAdapter = new StudentDetailsAdapter(getApplicationContext(), arrayList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(StudentActivity.this);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(studentDetailsAdapter);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }




}
    }



