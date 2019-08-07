package com.venture.vebschool.Parent.MenuActivities.TimeTable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;
import com.venture.vebschool.Parent.MenuActivities.Student.StudentModel;

import java.util.ArrayList;

public class TimetableActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<StudentModel> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_timetable1);
        try
        {
            getSupportActionBar().setTitle("Time Table");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            recyclerView=findViewById(R.id.parent_timetable1_recycler);
            arrayList= DBTransactionFunctions.getStudentDetails();
            TimetableAdapter timetableAdapter=new TimetableAdapter(getApplicationContext(),arrayList);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(TimetableActivity.this);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(timetableAdapter);
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
