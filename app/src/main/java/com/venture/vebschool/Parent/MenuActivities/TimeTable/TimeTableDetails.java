package com.venture.vebschool.Parent.MenuActivities.TimeTable;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;


import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;
import com.venture.vebschool.Parent.model.TimetableModel;

import java.util.ArrayList;

public class TimeTableDetails  extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<TimetableModel> arrayList=new ArrayList<>();
    String id,name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable_details);

        Intent intent=getIntent();
        id= intent.getStringExtra("id");
        name=intent.getStringExtra("name");
        getSupportActionBar().setTitle(name);
        try{
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            recyclerView=findViewById(R.id.recycler_timeview);
            arrayList= DBTransactionFunctions.getTimetabele();
            TimetableDetailsAdapter timetableDetailsAdapter=new TimetableDetailsAdapter(getApplicationContext(),arrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
            recyclerView.setAdapter(timetableDetailsAdapter);
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
