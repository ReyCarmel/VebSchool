package com.venture.vebschool.Parent.MenuActivities.Message;

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

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ChatData> {
    Context context;
    ArrayList<ContactModel> arrayList=new ArrayList<>();
    public ChatListAdapter(Context applicationContext, ArrayList<ContactModel> arrayList) {
        this.context=applicationContext;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ChatData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try
        {
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_message4,viewGroup,false);
            holder=new ChatListAdapter.ChatData(view);

        }catch (Exception e)
        {
        e.printStackTrace();
        }
        return (ChatListAdapter.ChatData) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatData chatData, int i) {
        chatData.name.setText(arrayList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ChatData extends RecyclerView.ViewHolder {
        TextView name;
        LinearLayout l;

        public ChatData(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.parent_message4_name);
            l=itemView.findViewById(R.id.parent_message4_layout);
        }
    }
}
