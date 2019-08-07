package com.venture.vebschool.Parent.MenuActivities.Event;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.venture.vebschool.R;

import java.util.ArrayList;

public class EventDetailsAdapter extends RecyclerView.Adapter<EventDetailsAdapter.EventDetails> {
    Context context;
    ArrayList<EventModel> arrayList=new ArrayList<>();

    TextView date,loc,desc;

    public EventDetailsAdapter(Context applicationContext, ArrayList<EventModel> arrayList) {
        this.context=applicationContext;
        this.arrayList=arrayList;

    }

    @NonNull
    @Override
    public EventDetailsAdapter.EventDetails onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try{
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_event4,viewGroup,false);
            holder=new EventDetailsAdapter.EventDetails(view);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (EventDetailsAdapter.EventDetails) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final EventDetails eventDetails, final int i) {
        try {
            eventDetails.event.setText(arrayList.get(i).getEvent());
            eventDetails.date.setText(arrayList.get(i).getDate());



        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class EventDetails extends RecyclerView.ViewHolder {
        TextView event,date;
        LinearLayout l;
        public EventDetails(@NonNull View itemView) {
            super(itemView);
            event=itemView.findViewById(R.id.parent_event4_eve);
            date=itemView.findViewById(R.id.parent_event4_date);
            l=itemView.findViewById(R.id.parent_event4_layout);
        }
    }
}
