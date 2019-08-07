package com.venture.vebschool.Parent.MenuActivities.Mark;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.venture.vebschool.R;

import java.util.ArrayList;

public class StudentMarkDetailsAdapter extends RecyclerView.Adapter<StudentMarkDetailsAdapter.Studmark>
{
    Context context;
    ArrayList<MarkModel> arrayList;

    public StudentMarkDetailsAdapter(Context applicationContext, ArrayList<MarkModel> arrayList) {
        this.context=applicationContext;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public StudentMarkDetailsAdapter.Studmark onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view=null;
        RecyclerView.ViewHolder holder=null;
        try
        {
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_mark4,viewGroup,false);
            holder=new StudentMarkDetailsAdapter.Studmark(view);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (StudentMarkDetailsAdapter.Studmark) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentMarkDetailsAdapter.Studmark studmark, int i) {
        studmark.s.setText(arrayList.get(i).getSubject());
        studmark.m.setText(arrayList.get(i).getMark()+"/100");

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Studmark extends RecyclerView.ViewHolder {
        TextView s,m;
        public Studmark(@NonNull View itemView) {
            super(itemView);
            s=itemView.findViewById(R.id.parent_mark4_sub);
            m=itemView.findViewById(R.id.parent_mark4_mark);
        }
    }
}
