package com.venture.vebschool.Parent.MenuActivities.Leave;

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

public class LeaveAdapter extends RecyclerView.Adapter<LeaveAdapter.Leave> {
    Context context;
    ArrayList<StudentModel> arrayList;

    public LeaveAdapter(Context applicationContext, ArrayList<StudentModel> arrayList) {
        this.context=applicationContext;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public LeaveAdapter.Leave onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try
        {
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_leave2,viewGroup,false);
            holder=new LeaveAdapter.Leave(view);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (LeaveAdapter.Leave) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Leave leave,final int i) {
        leave.name.setText(arrayList.get(i).getName());
        leave.mail.setText(arrayList.get(i).getEmail());
        leave.lclass.setText(arrayList.get(i).getS_class());
        if(i %2 == 0)
        {
            leave.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));

        }
        else
        {
            leave.itemView.setBackgroundColor(Color.parseColor("#E2DEDE"));

        }
        leave.l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, LeaveDetails.class);
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

    public class Leave extends RecyclerView.ViewHolder {
        TextView name,mail,lclass;
        LinearLayout l;
        public Leave(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.parent_leave2_name);
            mail=itemView.findViewById(R.id.parent_leave2_mail);
            lclass=itemView.findViewById(R.id.parent_leave2_class);
            l=itemView.findViewById(R.id.parent_leave2_layout);
        }
    }
}
