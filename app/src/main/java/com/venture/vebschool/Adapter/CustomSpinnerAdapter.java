package com.venture.vebschool.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.venture.vebschool.R;
import com.venture.vebschool.model.Exam;
import com.venture.vebschool.model.MarkModel;

import java.util.ArrayList;
import java.util.List;

public class CustomSpinnerAdapter extends ArrayAdapter<String> {

    private final LayoutInflater mInflater;
    private final Context mContext;
    private final List<Exam> items;

    public CustomSpinnerAdapter (Context context, List objects)
    {
        super(context,  0, objects);

        mContext = context;
        mInflater = LayoutInflater.from(context);

        items = objects;
    }




    @Override
    public View getDropDownView(int position,  View convertView, ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    @Override
    public @NonNull
    View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent){
        final View view = mInflater.inflate(R.layout.select_exam_mark_adapter, parent, false);

        TextView exam = (TextView) view.findViewById(R.id.e_xam);


        Exam offerData = items.get(position);

        exam.setText(offerData.getName());


        return view;
    }
}