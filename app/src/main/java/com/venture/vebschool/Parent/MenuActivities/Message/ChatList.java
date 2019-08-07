package com.venture.vebschool.Parent.MenuActivities.Message;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;

import java.util.ArrayList;

public class ChatList extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ContactModel> arrayList=new ArrayList<>();
    FloatingActionButton f;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_message3);
        getSupportActionBar().setTitle("Chats");
        try
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            f=findViewById(R.id.parent_message3_chat);
            recyclerView=findViewById(R.id.parent_message3_recycler);
            arrayList= DBTransactionFunctions.getContact();
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(ChatList.this);
            ChatListAdapter chatListAdapter=new ChatListAdapter(getApplicationContext(),arrayList);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(chatListAdapter);
            f.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(ChatList.this,AddContact.class);
                    startActivity(intent);
                }
            });
        }catch(Exception e)
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
