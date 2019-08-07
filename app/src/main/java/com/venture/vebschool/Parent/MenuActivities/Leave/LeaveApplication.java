package com.venture.vebschool.Parent.MenuActivities.Leave;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.venture.vebschool.R;
import java.util.ArrayList;

public class LeaveApplication extends AppCompatActivity {
   EditText e_date,e_sub,e_desc;
   Button button;
    ArrayList<LeaveModel> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_leave5);
        getSupportActionBar().setTitle("Leave Application");
        try{
            e_date=findViewById(R.id.parent_leave5_date);
            e_sub=findViewById(R.id.parent_leave5_sub);
            e_desc=findViewById(R.id.parent_leave5_des);
            button=findViewById(R.id.parent_leave5_submit);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(LeaveApplication.this, "Success", Toast.LENGTH_SHORT).show();
                    e_date.setText("");
                    e_sub.setText("");
                    e_desc.setText("");
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
