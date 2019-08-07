package com.venture.vebschool.Parent.MenuActivities.Assignment;

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

public class AssignmentDetailsAdapter extends RecyclerView.Adapter<AssignmentDetailsAdapter.Assignment> {

    Context context;
    ArrayList<AssignmentModel> arrayList;
    public AssignmentDetailsAdapter(Context applicationContext, ArrayList<AssignmentModel> arrayList) {
        this.context=applicationContext;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public AssignmentDetailsAdapter.Assignment onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try
        {
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_assignment4,viewGroup,false);
            holder=new AssignmentDetailsAdapter.Assignment(view);

        }catch (Exception e)
        {
        e.printStackTrace();
        }
        return (AssignmentDetailsAdapter.Assignment) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Assignment assignment, final int i) {
        assignment.subject.setText(arrayList.get(i).getSub());
        assignment.title.setText(arrayList.get(i).getTit());
        assignment.date.setText(arrayList.get(i).getDate());

        assignment.l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,AssignmentData.class);
                intent.putExtra("id",arrayList.get(i).getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Assignment extends RecyclerView.ViewHolder {
        TextView subject,title,date;
        LinearLayout l;
        public Assignment(@NonNull View itemView) {
            super(itemView);
            subject=itemView.findViewById(R.id.parent_assign4_sub);
            title=itemView.findViewById(R.id.parent_assign4_title);
            date=itemView.findViewById(R.id.parent_assign4_date);
            l=itemView.findViewById(R.id.parent_assign4_layout);
        }
    }
}
