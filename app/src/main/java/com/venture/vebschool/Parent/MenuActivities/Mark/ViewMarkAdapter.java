package com.venture.vebschool.Parent.MenuActivities.Mark;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.venture.vebschool.R;

import java.util.ArrayList;

public class ViewMarkAdapter extends RecyclerView.Adapter<ViewMarkAdapter.Mark> {
    Context context;
    ArrayList<MarkModel> arrayList;
    public ViewMarkAdapter(Context applicationContext, ArrayList<MarkModel> arrayList) {
        this.context=applicationContext;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ViewMarkAdapter.Mark onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view=null;
        RecyclerView.ViewHolder holder=null;
        try
        {
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_mark7,viewGroup,false);
            holder=new ViewMarkAdapter.Mark(view);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (ViewMarkAdapter.Mark) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Mark mark, int i) {

        mark.s.setText(arrayList.get(i).getSubject());
        mark.m.setText(arrayList.get(i).getMark());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Mark extends RecyclerView.ViewHolder {
        TextView s,m;
        public Mark(@NonNull View itemView) {
            super(itemView);
            s=itemView.findViewById(R.id.parent_mark7_sub);
            m=itemView.findViewById(R.id.parent_mark7_mark);
        }
    }
}
