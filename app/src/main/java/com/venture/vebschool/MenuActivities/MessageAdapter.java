package com.venture.vebschool.MenuActivities;

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
import com.venture.vebschool.model.StudentModel;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.Message> {
    Context context;
    ArrayList<StudentModel> arrayList=new ArrayList<>();


    public MessageAdapter(Context applicationContext, ArrayList<StudentModel> arrayList) {
        this.context=applicationContext;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public Message onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try
        {
         view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.message_adapter,viewGroup,false);
         holder=new MessageAdapter.Message(view);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return (MessageAdapter.Message) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Message message, final int i) {
        message.name.setText(arrayList.get(i).getName());
        message.email.setText(arrayList.get(i).getEmail());
        message.mclass.setText(arrayList.get(i).getS_class());
        if(i %2 == 0)
        {
            message.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));

        }
        else
        {
            message.itemView.setBackgroundColor(Color.parseColor("#E2DEDE"));

        }
        message.l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,MessageHistory.class);
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

    public class Message extends RecyclerView.ViewHolder {
        TextView name,email,mclass;
        LinearLayout l;
        public Message(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.tname);
            email=itemView.findViewById(R.id.temail);
            mclass=itemView.findViewById(R.id.tc);
            l=itemView.findViewById(R.id.linearLayout);
        }
    }
}
