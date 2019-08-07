package com.venture.vebschool.Parent.MenuActivities.Exam;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.venture.vebschool.R;

import java.util.ArrayList;

public class ExamDateAdapter extends RecyclerView.Adapter<ExamDateAdapter.ExamDate> {
    Context context;
    ArrayList<ExamModel> arrayList;
    public ExamDateAdapter(Context applicationContext, ArrayList<ExamModel> arrayList) {
        this.context=applicationContext;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ExamDateAdapter.ExamDate onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try
        {
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_exam4,viewGroup,false);
            holder=new ExamDateAdapter.ExamDate(view);

        }catch (Exception e)
        {
            e.printStackTrace();

        }
        return (ExamDateAdapter.ExamDate) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExamDate examDate, int i) {
        examDate.ename.setText(arrayList.get(i).getName());
        examDate.edate.setText(arrayList.get(i).getSdate());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ExamDate extends RecyclerView.ViewHolder {
        TextView ename,edate;
        public ExamDate(@NonNull View itemView) {
            super(itemView);
            ename=itemView.findViewById(R.id.parent_exam4_exam);
            edate=itemView.findViewById(R.id.parent_exam4_date);
        }
    }
}
