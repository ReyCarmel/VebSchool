package com.venture.vebschool.Parent.MenuActivities.Subject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;
import com.venture.vebschool.Parent.MenuActivities.Student.StudentModel;

import java.util.ArrayList;

public class SubjectActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<StudentModel> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_subject1);
        try
        {
            getSupportActionBar().setTitle("Subjects");
            recyclerView=findViewById(R.id.parent_subject1_recycler);
            arrayList= DBTransactionFunctions.getStudentDetails();
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(SubjectActivity.this);
            SubjectAdapter subjectAdapter=new SubjectAdapter(getApplicationContext(),arrayList);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(subjectAdapter);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }catch(Exception e)
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
