package com.venture.vebschool.Parent.MenuActivities.Assignment;


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

public class AssignmentDetails extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<AssignmentModel> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_assignment3);
        try
        {
            Intent intent=getIntent();
            String id=intent.getStringExtra("id");
            String name=intent.getStringExtra("name");
            getSupportActionBar().setTitle(name);

         recyclerView=findViewById(R.id.parent_assign3_layout);
         arrayList= DBTransactionFunctions.getAssignment(id);

            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(AssignmentDetails.this);
            AssignmentDetailsAdapter assignmentDetailsAdapter =new AssignmentDetailsAdapter(getApplicationContext(),arrayList);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(assignmentDetailsAdapter);
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