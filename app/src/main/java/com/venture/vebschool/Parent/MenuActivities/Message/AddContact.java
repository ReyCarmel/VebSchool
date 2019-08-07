package com.venture.vebschool.Parent.MenuActivities.Message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;

import java.util.ArrayList;

public class AddContact extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ContactModel> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_message5);
        getSupportActionBar().setTitle("Contacts");
        try
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            recyclerView=findViewById(R.id.parent_message5_recycler);
            arrayList= DBTransactionFunctions.getContact();
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(AddContact.this);
            ContactAdapter contactAdapter=new ContactAdapter(getApplicationContext(),arrayList);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(contactAdapter);
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
