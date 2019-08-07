package com.venture.vebschool.Parent.MenuActivities.HomeWork;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.venture.vebschool.R;

import java.util.ArrayList;

public class HomeworkDataAdapter extends RecyclerView.Adapter<HomeworkDataAdapter.Data> {
    Context context;
    ArrayList<HomeworkModel> arrayList;
    public HomeworkDataAdapter(Context applicationContext, ArrayList<HomeworkModel> arrayList) {
        this.context=applicationContext;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public HomeworkDataAdapter.Data onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try
        {
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_homework6,viewGroup,false);
            holder=new HomeworkDataAdapter.Data(view);
        }catch (Exception e)
        {
         e.printStackTrace();
        }
        return (HomeworkDataAdapter.Data) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Data data, int i) {
        data.title.setText(arrayList.get(i).getTitle());
        data.desc.setText(arrayList.get(i).getDesc());
        data.ref.setText(arrayList.get(i).getReference());
        data.attach.setText(arrayList.get(i).getAttach());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Data extends RecyclerView.ViewHolder {
        TextView title,desc,ref,attach;
        public Data(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.parent_homework6_title);
            desc=itemView.findViewById(R.id.parent_homework6_desc);
            ref=itemView.findViewById(R.id.parent_homework6_ref);
            attach=itemView.findViewById(R.id.parent_homework6_attach);
        }
    }
}
