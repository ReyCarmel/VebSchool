package com.venture.vebschool.Parent.MenuActivities.Attendance.Complaint;

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
import com.venture.vebschool.Parent.model.StudentModel;

import java.util.ArrayList;

public class ComplaintAdapter extends RecyclerView.Adapter<ComplaintAdapter.Complaint> {
    Context context;
    ArrayList<StudentModel> arrayList;
    public ComplaintAdapter(Context applicationContext, ArrayList<StudentModel> arrayList) {
        this.context=applicationContext;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ComplaintAdapter.Complaint onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try
        {
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_complaint,viewGroup,false);
            holder=new ComplaintAdapter.Complaint(view);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (ComplaintAdapter.Complaint) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Complaint complaint, final int i) {
        complaint.name.setText(arrayList.get(i).getName());
        complaint.email.setText(arrayList.get(i).getEmail());
        complaint.s_class.setText(arrayList.get(i).getS_class());

        if(i %2 == 0)
        {
            complaint.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));

        }
        else
        {
            complaint.itemView.setBackgroundColor(Color.parseColor("#E2DEDE"));

        }

        complaint.l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ComplaintDetails.class);
                intent.putExtra("id",arrayList.get(i).getAdmission_no());
                intent.putExtra("name",arrayList.get(i).getName());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Complaint extends RecyclerView.ViewHolder {
        TextView name,email,s_class;
        LinearLayout l;
        public Complaint(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.tname);
            email=itemView.findViewById(R.id.temail);
            s_class=itemView.findViewById(R.id.tc);
            l=itemView.findViewById(R.id.layout);
        }
    }
}
