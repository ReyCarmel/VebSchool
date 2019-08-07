package com.venture.vebschool.Parent.MenuActivities.Holiday;

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

public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.HoliDay> {
    Context context;
    ArrayList<StudentModel> arrayList=new ArrayList<>();
    public HolidayAdapter(Context applicationContext, ArrayList<StudentModel> arrayList) {
        this.context=applicationContext;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public HolidayAdapter.HoliDay onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try{
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_holiday2,viewGroup,false);
            holder=new HolidayAdapter.HoliDay(view);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (HolidayAdapter.HoliDay) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HoliDay holiDay, final int i) {
        holiDay.name.setText(arrayList.get(i).getName());
        holiDay.email.setText(arrayList.get(i).getEmail());
        holiDay.sclass.setText(arrayList.get(i).getS_class());
        if(i %2 == 0)
        {
            holiDay.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));

        }
        else
        {
            holiDay.itemView.setBackgroundColor(Color.parseColor("#E2DEDE"));

        }
        holiDay.l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,HolidayDates.class);
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

    public class HoliDay extends RecyclerView.ViewHolder {
        TextView name,email,sclass;
        LinearLayout l;
        public HoliDay(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.parent_holiday2_name);
            email=itemView.findViewById(R.id.parent_holiday2_mail);
            sclass=itemView.findViewById(R.id.parent_holiday2_class);
            l=itemView.findViewById(R.id.parent_holiday2_layout);
        }
    }
}
