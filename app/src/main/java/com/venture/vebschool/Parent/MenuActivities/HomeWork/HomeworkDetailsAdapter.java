package com.venture.vebschool.Parent.MenuActivities.HomeWork;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.venture.vebschool.R;

import java.util.ArrayList;

public class HomeworkDetailsAdapter extends RecyclerView.Adapter<HomeworkDetailsAdapter.HomeWork> {
    Context context;
    ArrayList<HomeworkModel> arrayList;
    public HomeworkDetailsAdapter(Context applicationContext, ArrayList<HomeworkModel> arrayList) {
        this.context=applicationContext;
        this.arrayList=arrayList;
    }


    @NonNull
    @Override
    public HomeworkDetailsAdapter.HomeWork onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try
        {
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_homework4,viewGroup,false);
            holder=new HomeworkDetailsAdapter.HomeWork(view);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return (HomeworkDetailsAdapter.HomeWork) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeWork homeWork, final int i) {
        homeWork.tit.setText(arrayList.get(i).getTitle());
        homeWork.des.setText(arrayList.get(i).getDesc());
        homeWork.date.setText(arrayList.get(i).getDate());
        homeWork.l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,HomeworkData.class);
                intent.putExtra("id",arrayList.get(i).getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class HomeWork extends RecyclerView.ViewHolder {
        TextView tit,des,date;
        LinearLayout l;
        public HomeWork(@NonNull View itemView) {
            super(itemView);
            tit=itemView.findViewById(R.id.parent_homework4_title);
            des=itemView.findViewById(R.id.parent_homework4_desc);
            date=itemView.findViewById(R.id.parent_homework4_date);
            l=itemView.findViewById(R.id.parent_homework4_layout);
        }
    }
}
