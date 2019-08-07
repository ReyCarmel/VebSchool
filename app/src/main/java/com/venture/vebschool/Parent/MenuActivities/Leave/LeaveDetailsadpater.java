package com.venture.vebschool.Parent.MenuActivities.Leave;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.venture.vebschool.R;
import java.util.ArrayList;

public class LeaveDetailsadpater extends RecyclerView.Adapter<LeaveDetailsadpater.LeaveDetails> {
    Context context;
    ArrayList<LeaveModel> arrayList;
    public LeaveDetailsadpater(Context applicationContext, ArrayList<LeaveModel> arrayList) {
        this.context=applicationContext;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public LeaveDetailsadpater.LeaveDetails onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try{
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_leave4,viewGroup,false);
            holder=new LeaveDetailsadpater.LeaveDetails(view);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (LeaveDetailsadpater.LeaveDetails) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LeaveDetails leaveDetails, final int i) {
        leaveDetails.date.setText(arrayList.get(i).getDate());
        leaveDetails.reason.setText(arrayList.get(i).getReason());
        leaveDetails.status.setText(arrayList.get(i).getStatus());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class LeaveDetails extends RecyclerView.ViewHolder {
        TextView date,reason,status;

        public LeaveDetails(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.parent_leave4_date);
            reason=itemView.findViewById(R.id.parent_leave4_rs);
            status=itemView.findViewById(R.id.parent_leave4_st);
        }
    }
}
