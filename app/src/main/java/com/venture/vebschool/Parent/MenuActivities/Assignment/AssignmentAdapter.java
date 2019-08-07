package com.venture.vebschool.Parent.MenuActivities.Assignment;

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

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.Assign> {
    Context context;
    ArrayList<StudentModel> arrayList;
    public AssignmentAdapter(Context applicationContext, ArrayList<StudentModel> arrayList) {
        this.context=applicationContext;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public AssignmentAdapter.Assign onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try
        {
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_assignment2,viewGroup,false);
            holder=new AssignmentAdapter.Assign(view);

        }catch (Exception e)
        {
        e.printStackTrace();
        }
        return ( AssignmentAdapter.Assign) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Assign assign,final int i) {

        assign.name.setText(arrayList.get(i).getName());

        assign.email.setText(arrayList.get(i).getEmail());
        assign.a_class.setText(arrayList.get(i).getS_class());
        if(i %2 == 0)
        {
            assign.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));

        }
        else
        {
            assign.itemView.setBackgroundColor(Color.parseColor("#E2DEDE"));

        }
        assign.l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,AssignmentDetails.class);
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

    public class Assign extends RecyclerView.ViewHolder {
        TextView name,a_class,email;
        LinearLayout l;
        public Assign(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.parent_assign2_name);
            a_class=itemView.findViewById(R.id.parent_assign2_class);
            email=itemView.findViewById(R.id.parent_assign2_mail);
            l=itemView.findViewById(R.id.parent_assign2_layout);
        }
    }
}
