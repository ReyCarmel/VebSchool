package com.venture.vebschool.Parent.MenuActivities.News;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.venture.vebschool.R;

import java.util.ArrayList;

public class NewsDataAdapter extends RecyclerView.Adapter<NewsDataAdapter.AllNews> {
    Context context;
    ArrayList<NewsModel> arrayList=new ArrayList<>();
    public NewsDataAdapter(Context applicationContext, ArrayList<NewsModel> arrayList) {
        this.context=applicationContext;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public NewsDataAdapter.AllNews onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try
        {
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_news4,viewGroup,false);
            holder=new NewsDataAdapter.AllNews(view);

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return (NewsDataAdapter.AllNews) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AllNews allNews, int i) {
        allNews.title.setText(arrayList.get(i).getTitle());
        allNews.s_date.setText(arrayList.get(i).getDate());
        allNews.content.setText(arrayList.get(i).getContent());



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class AllNews extends RecyclerView.ViewHolder {
        TextView title,s_date,content;
        public AllNews(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.parent_news4_title);
            s_date=itemView.findViewById(R.id.parent_news4_date);
            content=itemView.findViewById(R.id.parent_news4_content);
        }
    }
}
