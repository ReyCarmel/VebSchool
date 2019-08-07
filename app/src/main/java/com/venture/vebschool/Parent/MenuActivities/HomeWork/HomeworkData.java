package com.venture.vebschool.Parent.MenuActivities.HomeWork;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;

import java.util.ArrayList;

public class HomeworkData extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<HomeworkModel> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_homework5);
        getSupportActionBar().setTitle("Homework");
        try
        {
            recyclerView=findViewById(R.id.parent_homework5_recycler);
            arrayList= DBTransactionFunctions.getHomeworkData();
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(HomeworkData.this);
            HomeworkDataAdapter homeworkDataAdapter=new HomeworkDataAdapter(getApplicationContext(),arrayList);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(homeworkDataAdapter);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }catch (Exception e)
        {

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
