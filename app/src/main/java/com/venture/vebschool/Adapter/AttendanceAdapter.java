package com.venture.vebschool.Adapter;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.venture.vebschool.MenuActivities.AttendanceActivity;
import com.venture.vebschool.R;
import com.venture.vebschool.model.StudentModel;

import java.util.ArrayList;

public  class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.AttendanceDetails> {
    Context context;
    ArrayList<StudentModel> arrayList=new ArrayList<>();
    private ItemClickListener itemClickListener;
    public AttendanceAdapter(Context applicationContext, ArrayList<StudentModel> arrayList) {
        this.context=applicationContext;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public AttendanceAdapter.AttendanceDetails onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder holder=null;
        View view=null;
        try
        {
            view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.attendance_adapter,viewGroup,false);
            holder= new  AttendanceAdapter.AttendanceDetails(view);
        }
        catch (Exception e)
        {

        }
        return (AttendanceAdapter.AttendanceDetails) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AttendanceAdapter.AttendanceDetails attendanceDetails, int i) {
        attendanceDetails.name.setText(arrayList.get(i).getName());
        attendanceDetails.email.setText(arrayList.get(i).getEmail());
        attendanceDetails.a_class.setText(arrayList.get(i).getS_class());
        attendanceDetails.attendance.setText(arrayList.get(i).getAttendance());
        AttendanceActivity.setDate(arrayList.get(i).getDate());
        attendanceDetails.advance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
              /* final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_attendance_details);
                dialog.show();*/
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class AttendanceDetails extends RecyclerView.ViewHolder implements View.OnClickListener{

        LinearLayout l;
        TextView name, email, a_class, attendance;
        TextView advance;

        public AttendanceDetails(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.a_name);
            email = itemView.findViewById(R.id.a_mail);
            a_class = itemView.findViewById(R.id.a_class);
            attendance = itemView.findViewById(R.id.attendance);
            advance = itemView.findViewById(R.id.search);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            if(itemClickListener!=null)
            {
                itemClickListener.onItemClick(v,getAdapterPosition());
            }
        }
    }
    void setClickListener(ItemClickListener itemClickListener)
    {this.itemClickListener=itemClickListener; 

    }

    public  interface  ItemClickListener{
        void  onItemClick(View view,int position);
    }
}
