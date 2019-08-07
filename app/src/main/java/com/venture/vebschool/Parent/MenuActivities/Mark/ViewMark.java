package com.venture.vebschool.Parent.MenuActivities.Mark;

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

public class ViewMark extends AppCompatActivity {
    String item;
    ArrayList<MarkModel> arrayList=new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_mark6);

        try{
            Intent intent=getIntent();
            item=intent.getStringExtra("item");
            getSupportActionBar().setTitle(item);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            recyclerView=findViewById(R.id.parent_mark6_recycler);
            arrayList= DBTransactionFunctions.getMarkSheet();
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(ViewMark.this);
            ViewMarkAdapter viewMarkAdapter= new ViewMarkAdapter(getApplicationContext(),arrayList);

            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(viewMarkAdapter);


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
