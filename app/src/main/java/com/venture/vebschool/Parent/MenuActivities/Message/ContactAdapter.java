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

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.Contact> {
    Context context;
    ArrayList<ContactModel> arrayList=new ArrayList<>();
    public ContactAdapter(Context applicationContext, ArrayList<ContactModel> arrayList) {
        this.context=applicationContext;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public Contact onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try{
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_message6,viewGroup,false);
            holder=new ContactAdapter.Contact(view);

        }catch (Exception e){
            e.printStackTrace();
        }
        return (ContactAdapter.Contact) holder ;
    }

    @Override
    public void onBindViewHolder(@NonNull Contact contact, int i) {
        contact.name.setText(arrayList.get(i).getName());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Contact extends RecyclerView.ViewHolder {
        TextView name;
        LinearLayout l;
        public Contact(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.parent_message6_name);
            l=itemView.findViewById(R.id.parent_message6_layout);
        }
    }
}
