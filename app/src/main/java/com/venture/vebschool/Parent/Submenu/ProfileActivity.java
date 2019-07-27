package com.venture.vebschool.Parent.Submenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    TextView name,gender,email,address,phone;
    ArrayList<ProfileModel> arrayList=new ArrayList<>();
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        try
        {
            getSupportActionBar().setTitle("Profile");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            arrayList= DBTransactionFunctions.getProfile();
            name=findViewById(R.id.nam);
            gender=findViewById(R.id.gen);
            email=findViewById(R.id.em);
            address=findViewById(R.id.ad);
            phone=findViewById(R.id.ph);

            name.setText(arrayList.get(0).getNa());
            gender.setText(arrayList.get(0).getGe());
            email.setText(arrayList.get(0).getEm());
            address.setText(arrayList.get(0).getAd());
            phone.setText(arrayList.get(0).getPh());




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
