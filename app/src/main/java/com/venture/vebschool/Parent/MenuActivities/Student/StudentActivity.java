package com.venture.vebschool.Parent.MenuActivities.Student;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<StudentModel> arrayList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_student1);

        try {
            getSupportActionBar().setTitle("Students");
            recyclerView = findViewById(R.id.parent_student1_recycler);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {

            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
    }



