package com.venture.vebschool.MenuActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.venture.vebschool.Adapter.TimetableAdapter;
import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;
import com.venture.vebschool.model.StudentModel;

import java.util.ArrayList;

public class TimetableActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<StudentModel> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        try
        {
         recyclerView=findViewById(R.id.recycler_timeview);
         arrayList= DBTransactionFunctions.getStudentDetails();
         TimetableAdapter timetableAdapter=new TimetableAdapter(getApplicationContext(),arrayList);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(TimetableActivity.this);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(timetableAdapter);
        }catch (Exception e)
        {

        }
    }
}
