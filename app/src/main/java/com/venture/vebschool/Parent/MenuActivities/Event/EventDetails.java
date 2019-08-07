package com.venture.vebschool.Parent.MenuActivities.Event;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;

import java.util.ArrayList;

public class EventDetails extends AppCompatActivity
{
RecyclerView recyclerView;
TextView E_vent,E_date,date,loc,desc;
LinearLayout l;
String id,name;

ArrayList<EventModel> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_event3);
        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        name=intent.getStringExtra("name");
        getSupportActionBar().setTitle(name);
        try
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            recyclerView=findViewById(R.id.parent_event3_recycler);
            E_vent=findViewById(R.id.parent_event3_eve);
            E_date=findViewById(R.id.parent_event3_date);
            l=findViewById(R.id.parent_event3_layout);
            arrayList= DBTransactionFunctions.getEvents();
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(EventDetails.this);
            EventDetailsAdapter eventDetailsAdapter=new EventDetailsAdapter(getApplicationContext(),arrayList);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(eventDetailsAdapter);


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
