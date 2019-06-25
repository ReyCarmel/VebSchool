package com.venture.vebschool.MenuActivities;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.venture.vebschool.Adapter.AttendanceAdapter;
import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;
import com.venture.vebschool.model.StudentModel;

import java.util.ArrayList;

public class AttendanceActivity extends AppCompatActivity implements AttendanceAdapter.ItemClickListener {
    RecyclerView recyclerView;
    ArrayList<StudentModel> arrayList;
   public static TextView t_date = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_attendance);
            recyclerView = findViewById(R.id.recycler_view_attendance);
            arrayList=new ArrayList<StudentModel>();
            t_date=findViewById(R.id.date);

            arrayList=DBTransactionFunctions.getAttendanceDetails();
           AttendanceAdapter attendanceAdapter= new AttendanceAdapter(getApplicationContext(),arrayList);
           LinearLayoutManager linearLayoutManager=new LinearLayoutManager(AttendanceActivity.this);
           recyclerView.setLayoutManager(linearLayoutManager);
           recyclerView.setAdapter(attendanceAdapter);

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
    public void onItemClick(View view, int position) {
        Dialog dialog = new Dialog(AttendanceActivity.this);
        dialog.setContentView(R.layout.dialog_attendance_details);
        dialog.show();
    }
}
