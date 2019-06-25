package com.venture.vebschool.MenuActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.venture.vebschool.Adapter.MarkDetailsAdapter;
import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;
import com.venture.vebschool.model.StudentModel;

import java.util.ArrayList;

public class MarkActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<StudentModel> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            setContentView(R.layout.mark);
            recyclerView=findViewById(R.id.recylerview_mark);
            arrayList= DBTransactionFunctions.getMark();
            MarkDetailsAdapter markDetailsAdapter=new MarkDetailsAdapter(getApplicationContext(),arrayList);
            LinearLayoutManager linearLayoutManager= new LinearLayoutManager(MarkActivity.this);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(markDetailsAdapter);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
