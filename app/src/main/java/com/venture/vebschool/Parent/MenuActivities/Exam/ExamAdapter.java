package com.venture.vebschool.Parent.MenuActivities.Exam;

import android.app.Application;
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

public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.Exam> {
    Context context;
    ArrayList<StudentModel> arrayList=new ArrayList<>();
    public ExamAdapter(Application application, ArrayList<StudentModel> arrayList) {
        this.context=application;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public Exam onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try
        {
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_exam2,viewGroup,false);
            holder=new ExamAdapter.Exam(view);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (ExamAdapter.Exam) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Exam exam, final int i) {
        exam.name.setText(arrayList.get(i).getName());
        exam.mail.setText(arrayList.get(i).getEmail());
        exam.s_class.setText(arrayList.get(i).getS_class());
        if(i %2 == 0)
        {
            exam.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));

        }
        else
        {
            exam.itemView.setBackgroundColor(Color.parseColor("#E2DEDE"));

        }
        exam.l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ExamDate.class);
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

    public class Exam extends RecyclerView.ViewHolder {
        TextView name,mail,s_class;
        LinearLayout l;
        public Exam(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.parent_exam2_name);
            mail=itemView.findViewById(R.id.parent_exam2_mail);
            s_class=itemView.findViewById(R.id.parent_exam2_class);
            l=itemView.findViewById(R.id.parent_exam2_layout);
        }
    }
}
