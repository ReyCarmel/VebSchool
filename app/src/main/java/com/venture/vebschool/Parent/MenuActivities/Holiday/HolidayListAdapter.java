package com.venture.vebschool.Parent.MenuActivities.Holiday;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.venture.vebschool.R;

import java.util.ArrayList;

public class HolidayListAdapter extends RecyclerView.Adapter<HolidayListAdapter.Holiday> {
    Context context;
    ArrayList<HolidayModel> arrayList=new ArrayList<>();
    public HolidayListAdapter(Context applicationContext, ArrayList<HolidayModel> arrayList) {
        this.context=applicationContext;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public HolidayListAdapter.Holiday onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try
        {
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_holiday4,viewGroup,false);
            holder=new HolidayListAdapter.Holiday(view);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (HolidayListAdapter.Holiday) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holiday holiday, int i) {
        holiday.day.setText(arrayList.get(i).getName());
        holiday.date.setText(arrayList.get(i).getDate());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Holiday extends RecyclerView.ViewHolder {
        TextView day,date;
        public Holiday(@NonNull View itemView) {
            super(itemView);
            day=itemView.findViewById(R.id.parent_holiday4_holi);
            date=itemView.findViewById(R.id.parent_holiday4_date);
        }
    }
}
