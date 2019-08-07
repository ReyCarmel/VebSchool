package com.venture.vebschool.Parent.MenuActivities.Subject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.venture.vebschool.R;
import com.venture.vebschool.Parent.MenuActivities.Student.StudentModel;

import java.util.ArrayList;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.Subjects> {
Context context;
ArrayList<StudentModel> arrayList=new ArrayList<>();

    public SubjectAdapter(Context context, ArrayList<StudentModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public SubjectAdapter.Subjects onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view=null;
        RecyclerView.ViewHolder holder=null;
        try
        {
         view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_subject2,viewGroup,false);
         holder=new SubjectAdapter.Subjects(view);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (SubjectAdapter.Subjects) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Subjects subjects, final int i) {
       subjects.name.setText(arrayList.get(i).getName());
        subjects.email.setText(arrayList.get(i).getEmail());
        subjects.eclass.setText(arrayList.get(i).getS_class());
        if(i %2 == 0)
        {
            subjects.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));

        }
        else
        {
            subjects.itemView.setBackgroundColor(Color.parseColor("#E2DEDE"));

        }
        subjects.l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Subjectdetails.class);
                intent.putExtra("id",arrayList.get(i).getId());
                intent.putExtra("name",arrayList.get(i).getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Subjects extends RecyclerView.ViewHolder {
        TextView name,email,eclass;
        LinearLayout l;
        public Subjects(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.parent_subject2_name);
            email=itemView.findViewById(R.id.parent_subject2_mail);
            eclass=itemView.findViewById(R.id.parent_subject2_class);
            l=itemView.findViewById(R.id.parent_subject2_layout);

        }
    }
}
