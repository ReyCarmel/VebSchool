package com.venture.vebschool.Parent.MenuActivities.Leave;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;

import java.util.ArrayList;

public class LeaveDetails extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<LeaveModel> arrayList=new ArrayList<>();
    FloatingActionButton l;
    String id,name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_leave3);

        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        name=intent.getStringExtra("name");
        getSupportActionBar().setTitle(name);
        try
        {
            recyclerView=findViewById(R.id.parent_leave3_recycler);
            arrayList= DBTransactionFunctions.getLeave();
            LinearLayoutManager linearLayoutManager= new LinearLayoutManager(LeaveDetails.this);
            LeaveDetailsadpater leaveDetailsadpater =new LeaveDetailsadpater(getApplicationContext(),arrayList);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(leaveDetailsadpater);
            l=findViewById(R.id.l_button);
            l.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(LeaveDetails.this,LeaveApplication.class);
                    startActivity(intent);

                }
            });
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
