package com.venture.vebschool.Parent.MenuActivities.Attendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;
import com.venture.vebschool.Parent.MenuActivities.Student.StudentModel;

import java.util.ArrayList;

public class AttendanceActivity extends AppCompatActivity  {
    RecyclerView recyclerView;
    ArrayList<StudentModel> arrayList;
   public static TextView t_date = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.parent_attendance1);
            recyclerView = findViewById(R.id.parent_attendance1_recycler);
            arrayList=new ArrayList<StudentModel>();
            t_date=findViewById(R.id.parent_attendance1_date);

            getSupportActionBar().setTitle("Attendance");
            arrayList=DBTransactionFunctions.getAttendanceDetails();
           AttendanceAdapter attendanceAdapter= new AttendanceAdapter(AttendanceActivity.this,arrayList);
           LinearLayoutManager linearLayoutManager=new LinearLayoutManager(AttendanceActivity.this);
           recyclerView.setLayoutManager(linearLayoutManager);
           recyclerView.setAdapter(attendanceAdapter);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void  setDate(String date)
    {
        t_date.setText(date);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {

            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

}
