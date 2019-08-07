package com.venture.vebschool.Parent.MenuActivities.Assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;
import java.util.ArrayList;

public class AssignmentData extends AppCompatActivity {
    TextView title,desc,refr;

    ArrayList<AssignmentModel> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_assignment5);
        try {
            Intent intent=getIntent();
            String id=intent.getStringExtra("id");

            getSupportActionBar().setTitle("Assignment Details");

            arrayList = new ArrayList<AssignmentModel>();

            title=findViewById(R.id.parent_assign5_title);
            desc=findViewById(R.id.parent_assign5_desc);
            refr=findViewById(R.id.parent_assign5_ref);

            arrayList = DBTransactionFunctions.getAssignmentData(id);
            title.setText(arrayList.get(0).getTit());
            desc.setText(arrayList.get(0).getDesc());
            refr.setText(arrayList.get(0).getRef());

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
