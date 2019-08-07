package com.venture.vebschool.Parent.MenuActivities.Attendance;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.venture.vebschool.R;

import java.util.ArrayList;

public class NormalAttendanceAdapter extends RecyclerView.Adapter<NormalAttendanceAdapter.Attendance> {
    Context context;
    ArrayList<AttendanceModel> arrayList;
    public NormalAttendanceAdapter(Context applicationContext, ArrayList<AttendanceModel> arrayList) {

        this.context=applicationContext;
        this.arrayList=arrayList ;
    }

    @NonNull
    @Override
    public NormalAttendanceAdapter.Attendance onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try{
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_attendance6,viewGroup,false);
            holder=new NormalAttendanceAdapter.Attendance(view);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (NormalAttendanceAdapter.Attendance) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Attendance attendance, int i) {
        attendance.date.setText(arrayList.get(i).getDate());
        attendance.status.setText(arrayList.get(i).getStatus());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Attendance extends RecyclerView.ViewHolder {
        TextView date,status;
        public Attendance(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.parent_attendance6_date);
        status=itemView.findViewById(R.id.parent_attendance6_st);
        }
    }
}
