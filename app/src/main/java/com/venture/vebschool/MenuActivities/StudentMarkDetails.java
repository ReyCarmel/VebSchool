package com.venture.vebschool.MenuActivities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toolbar;

import com.venture.vebschool.Adapter.CustomSpinnerAdapter;
import com.venture.vebschool.Adapter.StudentMarkDetailsAdapter;
import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;
import com.venture.vebschool.model.Exam;
import com.venture.vebschool.model.MarkModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class StudentMarkDetails extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView search,from,to;
    Spinner s_exam;
    ArrayList<MarkModel> arrayList=new ArrayList<>();
    String id,name;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_marksheet);
        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        name=intent.getStringExtra("name");

        getSupportActionBar().setTitle(name);
        try
        {
            arrayList = DBTransactionFunctions.getMarkSheet();
            recyclerView=findViewById(R.id.recylerview_mark);
            search=findViewById(R.id.advance);
            StudentMarkDetailsAdapter smarkDetailsAdapter = new StudentMarkDetailsAdapter(getApplicationContext(), arrayList);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(StudentMarkDetails.this);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(smarkDetailsAdapter);
            search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Dialog dialog = new Dialog(StudentMarkDetails.this);
                    ArrayList<Exam> arrayList1=new ArrayList<>();
                    dialog.setContentView(R.layout.dialog_mark_details);
                    TextView dname=dialog.findViewById(R.id.d_name);
                    from=dialog.findViewById(R.id.d_from);
                    to=dialog.findViewById(R.id.d_to);
                    s_exam=dialog.findViewById(R.id.d_spinner);
                    dname.setText(name);
                    arrayList1=DBTransactionFunctions.getExam();
                    CustomSpinnerAdapter customSpinnerAdapter=new CustomSpinnerAdapter(StudentMarkDetails.this,arrayList1);
                    s_exam.setAdapter(customSpinnerAdapter);

                    from.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setDatePicker(from);
                        }


                    });
                    to.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setDatePicker(to);
                        }
                    });

                    dialog.show();
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void setDatePicker(final TextView textView)
    {
        final Calendar currentDate = Calendar.getInstance();
        final Calendar date = Calendar.getInstance();
        new DatePickerDialog(StudentMarkDetails.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                date.set(year, monthOfYear, dayOfMonth);
                                 String myFormat = "dd/MM/yy"; // your own format
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                        String  formated_time = sdf.format(date.getTime());
                        textView.setText(formated_time);
                    }
        }, currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE)).show();
    }
}
