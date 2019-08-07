package com.venture.vebschool.Parent.MenuActivities.HomeWork;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;

import java.util.ArrayList;

public class HomeWorkDetails extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<HomeworkModel> arrayList=new ArrayList<>();
    String id,name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_homework3);

        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        name=intent.getStringExtra("name");
        getSupportActionBar().setTitle(name);

        try
        {
            recyclerView=findViewById(R.id.parent_homework3_recycler);
            arrayList= DBTransactionFunctions.getHomework();
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(HomeWorkDetails.this);
            HomeworkDetailsAdapter homeworkDetailsAdapter=new HomeworkDetailsAdapter(getApplicationContext(),arrayList);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(homeworkDetailsAdapter);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


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
