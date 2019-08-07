package com.venture.vebschool.Parent.MenuActivities.Exam;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;

import java.util.ArrayList;

public class ExamDate extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ExamModel> arrayList=new ArrayList<>();
    TextView ename,edate;
    String id,name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_exam3);

        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        name=intent.getStringExtra("name");
        getSupportActionBar().setTitle(name);

        try
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            recyclerView=findViewById(R.id.parent_exam3_recycler);
            ename=findViewById(R.id.parent_exam3_exam);
            edate=findViewById(R.id.parent_exam3_date);
            arrayList= DBTransactionFunctions.getExamDate();
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(ExamDate.this);
            ExamDateAdapter examDateAdapter=new ExamDateAdapter(getApplicationContext(),arrayList);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(examDateAdapter);


        }catch (Exception e)
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
