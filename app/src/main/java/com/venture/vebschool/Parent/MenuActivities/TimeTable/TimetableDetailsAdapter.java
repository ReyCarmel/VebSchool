package com.venture.vebschool.Parent.MenuActivities.TimeTable;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.venture.vebschool.R;

import java.util.ArrayList;

public class TimetableDetailsAdapter extends RecyclerView.Adapter<TimetableDetailsAdapter.TImeTable> {
    Context context;
    ArrayList<TimetableModel> arrayList=new ArrayList<>();
    public TimetableDetailsAdapter(Context applicationContext, ArrayList<TimetableModel> arrayList) {
        this.context=applicationContext;
        this.arrayList=arrayList;

    }


    @NonNull
    @Override
    public TimetableDetailsAdapter.TImeTable onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        RecyclerView.ViewHolder holder=null;
        try{
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_timetable4,viewGroup,false);
            holder=new TimetableDetailsAdapter.TImeTable(view);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (TimetableDetailsAdapter.TImeTable) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TimetableDetailsAdapter.TImeTable tImeTable, int i) {

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class TImeTable extends RecyclerView.ViewHolder {
        public TImeTable(@NonNull View itemView) {
            super(itemView);
        }
    }
}
