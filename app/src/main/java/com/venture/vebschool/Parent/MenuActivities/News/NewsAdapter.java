package com.venture.vebschool.Parent.MenuActivities.News;

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

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.News> {
    Context context;
    ArrayList<StudentModel> arrayList=new ArrayList<>();

    public NewsAdapter(Context context, ArrayList<StudentModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public NewsAdapter.News onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try
        {
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_news2,viewGroup,false);
            holder=new NewsAdapter.News(view);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (NewsAdapter.News) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull News news, final int i) {
        news.name.setText(arrayList.get(i).getName());
        news.email.setText(arrayList.get(i).getEmail());
        news.sclass.setText(arrayList.get(i).getS_class());
        if(i %2 == 0)
        {
            news.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));

        }
        else
        {
            news.itemView.setBackgroundColor(Color.parseColor("#E2DEDE"));

        }
        try{
            news.l.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,NewsData.class);
                    intent.putExtra("id",arrayList.get(i).getId());
                    context.startActivity(intent);
                }
            });

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class News extends RecyclerView.ViewHolder {
        TextView name,email,sclass;
        LinearLayout l;
        public News(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.parent_news2_name);
            email=itemView.findViewById(R.id.parent_news2_mail);
            sclass=itemView.findViewById(R.id.parent_news2_clas);
            l=itemView.findViewById(R.id.parent_news2_layout);

        }
    }

}
