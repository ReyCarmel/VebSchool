package com.venture.vebschool.Parent.MenuActivities.Subject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.venture.vebschool.R;
import com.venture.vebschool.Parent.MenuActivities.Message.ContactModel;

import java.util.ArrayList;

public class SubjectDetailsAdapter extends RecyclerView.Adapter<SubjectDetailsAdapter.Subjects> {
    Context context;
    ArrayList<ContactModel> arrayList;
    public SubjectDetailsAdapter(Context applicationContext, ArrayList<ContactModel> arrayList) {
        this.context=applicationContext;

        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public SubjectDetailsAdapter.Subjects onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        try
        {
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_subject4,viewGroup,false);
            holder=new SubjectDetailsAdapter.Subjects(view);
        }catch (Exception e)
        {
        e.printStackTrace();
        }
        return (SubjectDetailsAdapter.Subjects) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Subjects subjects, int i) {
    subjects.faculty.setText(arrayList.get(i).getName());
    subjects.subject.setText(arrayList.get(i).getSub());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Subjects extends RecyclerView.ViewHolder {
        TextView subject,faculty;
        public Subjects(@NonNull View itemView) {
            super(itemView);
            subject=itemView.findViewById(R.id.parent_subject4_sub);
            faculty=itemView.findViewById(R.id.parent_subject4_name);
        }
    }
}
