package com.venture.vebschool.Parent.MenuActivities.HomeWork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;
import com.venture.vebschool.Parent.MenuActivities.Student.StudentModel;

import java.util.ArrayList;

public class HomeWorkActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<StudentModel> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_homework1);
        try{
            getSupportActionBar().setTitle("Homework");
            recyclerView=findViewById(R.id.parent_homework1_recycler);
            arrayList= DBTransactionFunctions.getStudentDetails();
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(HomeWorkActivity.this);
            HomeAdapter homeAdapter = new HomeAdapter(getApplicationContext(),arrayList);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(homeAdapter);
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
