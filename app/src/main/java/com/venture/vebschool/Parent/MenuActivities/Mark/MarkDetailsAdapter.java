package com.venture.vebschool.Parent.MenuActivities.Mark;

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

public class MarkDetailsAdapter extends RecyclerView.Adapter<MarkDetailsAdapter.MarkDetails>{
    Context context;
    ArrayList<StudentModel> arrayList;
    public MarkDetailsAdapter(Context applicationContext, ArrayList<StudentModel> arrayList) {
        this.context=applicationContext;
        this.arrayList=arrayList;
    }


    @NonNull
    @Override
    public MarkDetails onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try

        {
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_mark2,viewGroup,false);
            holder=new MarkDetailsAdapter.MarkDetails(view);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return (MarkDetailsAdapter.MarkDetails) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MarkDetails markDetails, final int i) {
        markDetails.t_name.setText(arrayList.get(i).getName());
        markDetails.t_email.setText(arrayList.get(i).getEmail());
        markDetails.t_class.setText(arrayList.get(i).getS_class());
        if(i %2 == 0)
        {
            markDetails.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));

        }
        else
        {
            markDetails.itemView.setBackgroundColor(Color.parseColor("#E2DEDE"));

        }
        markDetails.l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, StudentMarkDetails.class);
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

    public class MarkDetails extends RecyclerView.ViewHolder {
        LinearLayout l;
        TextView t_name,t_email,t_class;
        TextView mark;
        public MarkDetails(@NonNull View itemView) {
            super(itemView);
            t_class=itemView.findViewById(R.id.parent_mark2_class);
            t_email=itemView.findViewById(R.id.parent_mark2_mail);
            t_name=itemView.findViewById(R.id.parent_mark2_name);
            l=itemView.findViewById(R.id.parent_mark2_layout);

        }
    }
}
