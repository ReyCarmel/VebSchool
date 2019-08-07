package com.venture.vebschool.Parent.MenuActivities.Attendance;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.venture.vebschool.R;
import com.venture.vebschool.Parent.MenuActivities.Student.StudentModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public  class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.AttendanceDetails> {
     public Context context;

    TextView fr,t,name;
    Button submit;
    RadioGroup radioGroup;
    RadioButton radioButton;
    ArrayList<StudentModel> arrayList=new ArrayList<>();
    public AttendanceAdapter(Context con, ArrayList<StudentModel> arrayList) {
        this.context=con;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public AttendanceAdapter.AttendanceDetails onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder holder=null;
        View view=null;
        try
        {
            view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_attendance2,viewGroup,false);
            holder= new  AttendanceAdapter.AttendanceDetails(view);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return (AttendanceAdapter.AttendanceDetails) holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AttendanceAdapter.AttendanceDetails attendanceDetails,final int i) {
        attendanceDetails.name.setText(arrayList.get(i).getName());
        attendanceDetails.email.setText(arrayList.get(i).getEmail());
        attendanceDetails.a_class.setText(arrayList.get(i).getS_class());
        attendanceDetails.attendance.setText(arrayList.get(i).getAttendance());
        AttendanceActivity.setDate(arrayList.get(i).getDate());
       attendanceDetails.advance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                final Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.parent_attendance3);
            name=dialog.findViewById(R.id.parent_attendance3_stud);
            fr=dialog.findViewById(R.id.parent_attendance3_from);
            t=dialog.findViewById(R.id.parent_attendance3_to);
            submit=dialog.findViewById(R.id.parent_attendance3_submit);
            radioGroup=dialog.findViewById(R.id.parent_attendance3_group);
            name.setText(arrayList.get(i).getName());
            fr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setDatePicker(fr);
                }
            });
            t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setDatePicker(t);
                }
            });
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int selectID=radioGroup.getCheckedRadioButtonId();
                    radioButton=dialog.findViewById(selectID);
                    if(radioButton.getText().toString().equals("Graph"))
                    {
                        Intent intent=new Intent(context,AttendanceGraph.class);
                        intent.putExtra("id",arrayList.get(i).getId());
                        intent.putExtra("name",arrayList.get(i).getName());
                        context.startActivity(intent);
                        dialog.cancel();

                    }
                    else
                    {
                        Intent intent=new Intent(context,NormalAttendance.class);
                        intent.putExtra("id",arrayList.get(i).getId());
                        intent.putExtra("name",arrayList.get(i).getName());
                        context.startActivity(intent);
                        dialog.cancel();
                    }



                }
            });
            dialog.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class AttendanceDetails extends RecyclerView.ViewHolder  {

        LinearLayout l;
        TextView name, email, a_class, attendance;
        TextView advance;

        public AttendanceDetails(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.parent_attendance2__name);
            email = itemView.findViewById(R.id.parent_attendance2_mail);
            a_class = itemView.findViewById(R.id.parent_attendance2_class);
            attendance = itemView.findViewById(R.id.parent_attendance2_at);
            advance = itemView.findViewById(R.id.parent_attendance2_search);
        }

    }
    private void setDatePicker(final TextView textView)
    {
        final Calendar currentDate = Calendar.getInstance();
        final Calendar date = Calendar.getInstance();
        new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
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
