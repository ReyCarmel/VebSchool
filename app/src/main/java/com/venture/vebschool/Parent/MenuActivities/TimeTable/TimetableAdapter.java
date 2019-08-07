package com.venture.vebschool.Parent.MenuActivities.TimeTable;

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

public class TimetableAdapter extends RecyclerView.Adapter<TimetableAdapter.TimeTable> {
    Context context;
    ArrayList<StudentModel> arrayList=new ArrayList<>();
    public TimetableAdapter(Context applicationContext, ArrayList<StudentModel> arrayList) {
        this.context=applicationContext;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public TimeTable onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try{
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_timetable2,viewGroup,false);
            holder=new TimetableAdapter.TimeTable(view);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (TimetableAdapter.TimeTable) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TimeTable timeTable, final int i) {
        timeTable.t_name.setText(arrayList.get(i).getName());
        timeTable.t_email.setText(arrayList.get(i).getEmail());
        timeTable.t_class.setText(arrayList.get(i).getS_class());
        if(i %2 == 0)
        {
            timeTable.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));

        }
        else
        {
            timeTable.itemView.setBackgroundColor(Color.parseColor("#E2DEDE"));

        }
        timeTable.l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, TimeTableDetails.class);
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

    public class TimeTable extends RecyclerView.ViewHolder {
        TextView t_name,t_email,t_class;
        LinearLayout l;
        public TimeTable(@NonNull View itemView) {
            super(itemView);
            t_name=itemView.findViewById(R.id.parent_timetable2_name);
            t_email=itemView.findViewById(R.id.parent_timetable2_email);
            t_class=itemView.findViewById(R.id.parent_timetable2_class);
            l=itemView.findViewById(R.id.parent_timetable2_layout);
        }
    }
}
