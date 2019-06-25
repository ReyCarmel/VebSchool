package com.venture.vebschool.MenuActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.venture.vebschool.Adapter.StudentDetailsAdapter;
import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;
import com.venture.vebschool.model.StudentModel;

import java.util.ArrayList;

public class StudentDetails extends AppCompatActivity {
   TextView t_admission,t_name,t_class,t_division,t_roll,t_email,t_gender,t_birthday,t_phone;
   ImageView imageView;
    ArrayList<StudentModel> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_details);
        try {
            Intent intent=getIntent();
            String id=intent.getStringExtra("id");
            arrayList = new ArrayList<StudentModel>();

            t_admission=findViewById(R.id.admission);
            t_name=findViewById(R.id.name);
            t_class=findViewById(R.id.s_class);
            t_division=findViewById(R.id.t_division);
            t_roll=findViewById(R.id.rollNo);
            t_email=findViewById(R.id.email);
            t_gender=findViewById(R.id.gender);
            t_birthday=findViewById(R.id.birh);
            t_phone=findViewById(R.id.phone);

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
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
