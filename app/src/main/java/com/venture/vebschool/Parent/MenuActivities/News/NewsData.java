package com.venture.vebschool.Parent.MenuActivities.News;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;

import java.util.ArrayList;

public class NewsData extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<NewsModel> arrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_news3);
        getSupportActionBar().setTitle("Current News");
        try
        {
            recyclerView=findViewById(R.id.parent_news3_recycler);
            arrayList= DBTransactionFunctions.getNews();
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(NewsData.this);
            NewsDataAdapter  newsDataAdapter=new NewsDataAdapter(getApplicationContext(),arrayList);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(newsDataAdapter);
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
