package com.venture.vebschool.Parent.MenuActivities.HomeWork;

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

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Home>{
    Context context;
    ArrayList<StudentModel> arrayList;
    public HomeAdapter(Context applicationContext, ArrayList<StudentModel> arrayList) {
        this.context=applicationContext;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public HomeAdapter.Home onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
                try
                {
                    view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_homework2,viewGroup,false);
                    holder=new HomeAdapter.Home(view);
                }catch(Exception e)
                {
                    e.printStackTrace();
                }


        return (HomeAdapter.Home) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Home home, final int i) {
    home.name.setText(arrayList.get(i).getName());
    home.email.setText(arrayList.get(i).getEmail());
    home.sclass.setText(arrayList.get(i).getS_class());
        if(i %2 == 0)
        {
            home.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));

        }
        else
        {
            home.itemView.setBackgroundColor(Color.parseColor("#E2DEDE"));

        }
        home.l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent=new Intent(context,HomeWorkDetails.class);
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

    public class Home extends RecyclerView.ViewHolder {
        TextView name,email,sclass;
        LinearLayout l;
        public Home(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.parent_homework2_name);
            email=itemView.findViewById(R.id.parent_homework2_mail);
            sclass=itemView.findViewById(R.id.parent_homework2_class);
            l=itemView.findViewById(R.id.parent_homework2_layout);
        }
    }
}
