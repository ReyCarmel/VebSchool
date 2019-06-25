package com.venture.vebschool.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.venture.vebschool.MenuActivities.StudentDetails;
import com.venture.vebschool.R;
import com.venture.vebschool.model.StudentModel;

import java.util.ArrayList;

public class StudentDetailsAdapter extends RecyclerView.Adapter<StudentDetailsAdapter.StudDetails>
{

    Context contex;
    ArrayList<StudentModel> arrayList=new ArrayList<StudentModel>();
    public StudentDetailsAdapter(Context applicationContext, ArrayList<StudentModel> arrayList)
    {
        this.contex=applicationContext;
        this.arrayList=arrayList;

    }



    @NonNull
    @Override
    public StudentDetailsAdapter.StudDetails onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder holder=null;
        View view=null;

       try {
           view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_adapter, viewGroup, false);
            holder = new StudentDetailsAdapter.StudDetails(view);

       }
       catch (Exception e)
       {
           e.printStackTrace();
       }

        return (StudentDetailsAdapter.StudDetails) holder;

    }

    @Override
    public void onBindViewHolder(@NonNull final StudentDetailsAdapter.StudDetails studDetails, final int i)
    {
        studDetails.t_name.setText(arrayList.get(i).getName());
        studDetails.t_class.setText(arrayList.get(i).getS_class());
        studDetails.t_email.setText(arrayList.get(i).getEmail());
        if(i %2 == 0)
        {
            studDetails.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));

        }
        else
        {
            studDetails.itemView.setBackgroundColor(Color.parseColor("#E2DEDE"));

        }
        studDetails.l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(contex,StudentDetails.class);
               intent.putExtra("id",arrayList.get(i).getId());
                contex.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
            return arrayList.size();
    }

    public class StudDetails extends RecyclerView.ViewHolder
    {
        LinearLayout l;
        TextView t_name,t_class,t_email;
        public StudDetails(@NonNull View itemView) {
            super(itemView);
            t_name=itemView.findViewById(R.id.tname);
            t_email=itemView.findViewById(R.id.temail);
            t_class=itemView.findViewById(R.id.tc);
            l=itemView.findViewById(R.id.linearLayout);

        }
    }

}
