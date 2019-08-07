package com.venture.vebschool.Parent.MenuActivities.Mark;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.venture.vebschool.R;
import com.venture.vebschool.Parent.MenuActivities.Exam.ExamModel;

import java.util.ArrayList;

public class ExamListAdapter extends RecyclerView.Adapter<ExamListAdapter.Exam> {
    Context context;
    ArrayList<ExamModel> arrayList;
    ArrayList<String> arrayList1=new ArrayList<>();
    public ExamListAdapter(Context applicationContext, ArrayList<ExamModel> examList) {
        this.context=applicationContext;
        this.arrayList=examList;
    }

    @NonNull
    @Override
    public ExamListAdapter.Exam onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try
        {
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_mark10,viewGroup,false);
            holder=new ExamListAdapter.Exam(view);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (ExamListAdapter.Exam) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Exam exam,final int i) {

        exam.examName.setText(arrayList.get(i).getName());
        exam.check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    arrayList1.add(arrayList.get(i).getName());
                    StudentMarkDetails.setExam(arrayList1);
                }
                else
                {
                    arrayList1.remove(arrayList.get(i).getName());
                    StudentMarkDetails.setExam(arrayList1);
                }
            }
        });
        exam.l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Exam extends RecyclerView.ViewHolder {
        CheckBox check;
        TextView examName;
        LinearLayout l;

        public Exam(@NonNull View itemView) {
            super(itemView);
            check=itemView.findViewById(R.id.parent_mark10_check);
            examName=itemView.findViewById(R.id.parent_mark10_exam);
            l=itemView.findViewById(R.id.parent_mark10_layout);
        }
    }
}
