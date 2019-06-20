package com.venture.vebschool.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.venture.vebschool.R;
import com.venture.vebschool.model.StudentModel;

import java.util.ArrayList;

public class StudentDetailsAdapter extends RecyclerView.Adapter<StudentDetailsAdapter.StudDetails>
{
    Context contex;
    ArrayList<StudentModel> arrayList=new ArrayList<StudentModel>();
    public StudentDetailsAdapter(@NonNull Context context,ArrayList<StudentModel> arrayList)
    {
         arrayList=new ArrayList<StudentModel>();
         this.contex=context;
         this.arrayList=arrayList;
    }


    @NonNull
    @Override
    public StudentDetailsAdapter.StudDetails onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_adapter,viewGroup,false);
        RecyclerView.ViewHolder holder=new StudentDetailsAdapter.StudDetails(view);
        return (StudentDetailsAdapter.StudDetails) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentDetailsAdapter.StudDetails studDetails, int i)
    {
        studDetails.t_name.setText(arrayList.get(i).getName());
        studDetails.t_class.setText(arrayList.get(i).getS_class());
        studDetails.t_email.setText(arrayList.get(i).getEmail());


    }

    @Override
    public int getItemCount() {
            return arrayList.size();
    }

    public class StudDetails extends RecyclerView.ViewHolder
    {
        TextView t_name,t_class,t_email;
        public StudDetails(@NonNull View itemView) {
            super(itemView);
            t_name=itemView.findViewById(R.id.tname);
            t_class=itemView.findViewById(R.id.tc);
            t_email=itemView.findViewById(R.id.temail);

        }
    }
}
