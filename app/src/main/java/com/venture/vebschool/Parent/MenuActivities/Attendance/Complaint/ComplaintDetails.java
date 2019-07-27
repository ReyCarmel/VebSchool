package com.venture.vebschool.Parent.MenuActivities.Attendance.Complaint;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.venture.vebschool.R;


public class ComplaintDetails extends AppCompatActivity {

    EditText title,description;
    Button button;
    String id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complaints);
        try
        {
            Intent intent=getIntent();
            id=intent.getStringExtra("id");

            getSupportActionBar().setTitle("Compose");

            title=findViewById(R.id.title);
            description=findViewById(R.id.desc);
            button=findViewById(R.id.btn);


            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ComplaintDetails.this, "Success", Toast.LENGTH_SHORT).show();
                }
            });


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
