package com.venture.vebschool.Parent.MenuActivities.Mark;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;
import com.venture.vebschool.Parent.MenuActivities.Student.StudentModel;

import java.util.ArrayList;

public class MarkActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<StudentModel> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            getSupportActionBar().setTitle("Mark");

            setContentView(R.layout.parent_mark1);
            recyclerView=findViewById(R.id.parent_mark1_recycler);
            arrayList= DBTransactionFunctions.getMark();
            MarkDetailsAdapter markDetailsAdapter=new MarkDetailsAdapter(getApplicationContext(),arrayList);
            LinearLayoutManager linearLayoutManager= new LinearLayoutManager(MarkActivity.this);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(markDetailsAdapter);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
        catch (Exception e)
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
