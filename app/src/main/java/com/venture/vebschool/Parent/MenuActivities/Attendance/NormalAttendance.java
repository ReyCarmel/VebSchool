package com.venture.vebschool.Parent.MenuActivities.Attendance;

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

public class NormalAttendance extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<AttendanceModel> arrayList=new ArrayList<>();
    String id,name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_attendance5);
        try
        {
            Intent intent=getIntent();
            id=intent.getStringExtra("id");
            name=intent.getStringExtra("name");
            getSupportActionBar().setTitle(name);

            recyclerView=findViewById(R.id.parent_attendance5_recycler);
            arrayList= DBTransactionFunctions.getAttendance();
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(NormalAttendance.this);
            NormalAttendanceAdapter attendanceDateAdapter=new NormalAttendanceAdapter(getApplicationContext(),arrayList);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(attendanceDateAdapter);
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
