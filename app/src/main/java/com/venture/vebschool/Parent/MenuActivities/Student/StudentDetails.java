package com.venture.vebschool.Parent.MenuActivities.Student;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;

import java.util.ArrayList;

public class StudentDetails extends AppCompatActivity {
   TextView t_admission,t_name,t_class,t_division,t_roll,t_email,t_gender,t_birthday,t_phone;
   ImageView imageView;
    ArrayList<StudentModel> arrayList;
    String id,name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_student3);

        Intent intent=getIntent();
        id=intent.getStringExtra("id");

        name=intent.getStringExtra("name");
        getSupportActionBar().setTitle(name);
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            arrayList = new ArrayList<StudentModel>();

            t_admission=findViewById(R.id.parent_student3_ad);
            t_name=findViewById(R.id.parent_student3_name);
            t_class=findViewById(R.id.parent_student3_class);
            t_division=findViewById(R.id.parent_student3_div);
            t_roll=findViewById(R.id.parent_student3_no);
            t_email=findViewById(R.id.parent_student3_mail);
            t_gender=findViewById(R.id.parent_student3_gender);
            t_birthday=findViewById(R.id.parent_student3_bd);
            t_phone=findViewById(R.id.parent_student3_ph);

            arrayList = DBTransactionFunctions.getSingleStudentDetails(id);
            t_admission.setText(arrayList.get(0).getAdmission_no());
            t_name.setText(arrayList.get(0).getName());
            t_class.setText(arrayList.get(0).getS_class());
            t_division.setText(arrayList.get(0).getDivision());
            t_roll.setText(arrayList.get(0).getRoll_no());
            t_email.setText(arrayList.get(0).getEmail());
            t_gender.setText(arrayList.get(0).getGender());
            t_birthday.setText(arrayList.get(0).getBirthday());
            t_phone.setText(arrayList.get(0).getPhone_no());

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
