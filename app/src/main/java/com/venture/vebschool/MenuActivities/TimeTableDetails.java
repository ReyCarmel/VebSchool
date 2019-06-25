package com.venture.vebschool.MenuActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.venture.vebschool.Adapter.TimetableDetailsAdapter;
import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;

import java.util.ArrayList;

public class TimeTableDetails  extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<TimetableModel> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable_details);
        try{
            recyclerView=findViewById(R.id.recycler_timeview);
            arrayList= DBTransactionFunctions.getTimetabele();
            TimetableDetailsAdapter timetableDetailsAdapter=new TimetableDetailsAdapter(getApplicationContext(),arrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
            recyclerView.setAdapter(timetableDetailsAdapter);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
