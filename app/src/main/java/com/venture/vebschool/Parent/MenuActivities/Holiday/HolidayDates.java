package com.venture.vebschool.Parent.MenuActivities.Holiday;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;

import java.util.ArrayList;

public class HolidayDates extends AppCompatActivity
{
    RecyclerView recyclerView;
    ArrayList<HolidayModel> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_holiday3);
        getSupportActionBar().setTitle("Holiday");
        try{
            recyclerView=findViewById(R.id.parent_holiday3_recycler);
            arrayList= DBTransactionFunctions.getHoliday();
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(HolidayDates.this);
            HolidayListAdapter holidayListAdapter=new HolidayListAdapter(getApplicationContext(),arrayList);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(holidayListAdapter);
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
