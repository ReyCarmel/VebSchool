package com.venture.vebschool.Parent.MenuActivities.Mark;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.venture.vebschool.R;
import com.venture.vebschool.Parent.MenuActivities.Exam.ExamModel;
import java.util.ArrayList;

public class CustomSpinnerAdapter extends BaseAdapter {
    Context context;
    ArrayList<ExamModel> arrayList;
    public CustomSpinnerAdapter(Context applicationContext, ArrayList<ExamModel> arrayList1) {
        this.context=applicationContext;
        this.arrayList=arrayList1;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_mark9,parent,false);
        TextView exam=convertView.findViewById(R.id.parent_mark9_recycler);
       // CheckBox checkBox=convertView.findViewById(R.id.e_check);
        exam.setText(arrayList.get(position).getName());

        return convertView;
    }
}