package com.venture.vebschool.Parent.MenuActivities.Event;

import android.app.Application;
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

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.Event> {
    Context context;
    ArrayList<StudentModel> arrayList=new ArrayList<>();
    public EventAdapter(Application application, ArrayList<StudentModel> arrayList) {
        this.context=application;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public EventAdapter.Event onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try
        {
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_event2,viewGroup,false);
            holder=new EventAdapter.Event(view);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (EventAdapter.Event) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final EventAdapter.Event event, final int i) {
        event.name.setText(arrayList.get(i).getName());
        event.mail.setText(arrayList.get(i).getEmail());
        event.s_class.setText(arrayList.get(i).getS_class());
        if(i %2 == 0)
        {
            event.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));

        }
        else
        {
            event.itemView.setBackgroundColor(Color.parseColor("#E2DEDE"));

        }
        event.l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,EventDetails.class);
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

    public class Event extends RecyclerView.ViewHolder {
        TextView name, mail, s_class;
        LinearLayout l;

        public Event(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.parent_event2_name);
            mail = itemView.findViewById(R.id.parent_event2_mail);
            s_class = itemView.findViewById(R.id.parent_event2_class);
            l = itemView.findViewById(R.id.parent_event2_layout);
        }

    }
}
