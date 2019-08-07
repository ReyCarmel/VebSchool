package com.venture.vebschool.Parent.MenuActivities.Mark;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.venture.vebschool.R;
import com.venture.vebschool.databases.DBTransactionFunctions;

import com.venture.vebschool.Parent.MenuActivities.Exam.ExamModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class StudentMarkDetails extends AppCompatActivity  {

    RecyclerView recyclerView;
    ArrayList<String> examModelArrayList=new ArrayList<>();
    TextView e_from;
    TextView view_mark;
    TextView e_to;
    TextView search;
    TextView compare;
    TextView s_name;
    static TextView ExamList;
    TextView studName,fromDate,toDate,ButtonCompare;
    Spinner spinner_mark,subSpinner;
    ArrayList<ExamModel> arrayExam=new ArrayList<>();
    RecyclerView examRecycler;
    TextView buttonExam;
    ArrayList<MarkModel> arrayList=new ArrayList<>();
    ArrayList<String> subjectList=new ArrayList<>();
    ArrayList<ExamModel> examList=new ArrayList<>();
    static int examCount=0;


    String id,name,item,item1,item2;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_mark3);

        final Intent intent = getIntent();
        id = intent.getStringExtra("id");
        name = intent.getStringExtra("name");
        getSupportActionBar().setTitle(name);

        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            arrayList = DBTransactionFunctions.getMarkSheet();
            recyclerView = findViewById(R.id.parent_mark3_recycler);
            search = findViewById(R.id.parent_mark3_exam);
            compare = findViewById(R.id.parent_mark3_compare);



            StudentMarkDetailsAdapter smarkDetailsAdapter = new StudentMarkDetailsAdapter(getApplicationContext(), arrayList);
            final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(StudentMarkDetails.this);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(smarkDetailsAdapter);

            search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        final Dialog dialog = new Dialog(StudentMarkDetails.this);
                        dialog.setContentView(R.layout.parent_mark5);
                        e_from = dialog.findViewById(R.id.parent_mark5_from);
                        e_to = dialog.findViewById(R.id.parent_mark5_to);
                        s_name = dialog.findViewById(R.id.parent_mark5_stud);
                        spinner_mark = dialog.findViewById(R.id.parent_mark5_spinner);
                        view_mark = dialog.findViewById(R.id.parent_mark5_submit);
                        s_name.setText(name);
                        examModelArrayList = DBTransactionFunctions.getExamName();

                       /* CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(getApplicationContext(), examModelArrayList);

                        spinner_mark.setAdapter(customSpinnerAdapter);*/
                        final ArrayAdapter<String> adapter1=new ArrayAdapter<String>(StudentMarkDetails.this,android.R.layout.simple_spinner_item,examModelArrayList);
                        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_mark.setAdapter(adapter1);
                        spinner_mark.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                item=examModelArrayList.get(position);
                                Toast.makeText(StudentMarkDetails.this, item, Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });

                        e_from.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setDatePicker(e_from);
                            }
                        });
                        e_to.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setDatePicker(e_to);
                            }
                        });
                        view_mark.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent1 = new Intent(getApplicationContext(), ViewMark.class);
                                intent1.putExtra("item", item);
                                dialog.cancel();
                                startActivity(intent1);
                            }
                        });

                        dialog.show();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                }
            });

            compare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try
                    {
                        final Dialog dialog=new Dialog(StudentMarkDetails.this);
                        dialog.setContentView(R.layout.parent_mark8);
                        studName=dialog.findViewById(R.id.parent_mark8_stud);
                        fromDate=dialog.findViewById(R.id.parent_mark8_from);
                        toDate=dialog.findViewById(R.id.parent_mark8_to);
                        ExamList=dialog.findViewById(R.id.parent_mark8_exam);
                        subSpinner=dialog.findViewById(R.id.parent_mark8_spinner);
                        ButtonCompare=dialog.findViewById(R.id.parent_mark8_submit);
                        studName.setText(name);
                        arrayExam=DBTransactionFunctions.getExam();
                        subjectList=DBTransactionFunctions.getSubjectsMark();




                        fromDate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setDatePicker(fromDate);
                            }
                        });
                        toDate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setDatePicker(toDate);
                            }
                        });
                        ExamList.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                final Dialog dialog=new Dialog(StudentMarkDetails.this);
                                dialog.setContentView(R.layout.parent_mark9);
                                examList=DBTransactionFunctions.getExam();
                                getSupportActionBar().setTitle("Select Exam");
                                buttonExam=dialog.findViewById(R.id.parent_mark9_done);
                                examRecycler=dialog.findViewById(R.id.parent_mark9_recycler);
                                LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(StudentMarkDetails.this);
                                ExamListAdapter examListAdapter=new ExamListAdapter(getApplicationContext(),examList);
                                examRecycler.setLayoutManager(linearLayoutManager1);
                                examRecycler.setAdapter(examListAdapter);
                                buttonExam.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (examCount<2)
                                        {
                                            Toast.makeText(StudentMarkDetails.this, "Select atleast two exams", Toast.LENGTH_SHORT).show();
                                        }else
                                        {
                                            dialog.cancel();
                                        }


                                    }
                                });

                                dialog.show();

                            }
                        });


                        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(StudentMarkDetails.this,android.R.layout.simple_spinner_item, subjectList);

                        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        subSpinner.setAdapter(adapter2);
                        subSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                item2=subjectList.get(position);
                                Toast.makeText(StudentMarkDetails.this, item2, Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });




                        ButtonCompare.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent1=new Intent(StudentMarkDetails.this,CompareMark.class);

                                dialog.cancel();
                                startActivity(intent1);
                            }
                        });


                        dialog.show();


                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                }
            });


        } catch (Exception e) {
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

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {

            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
public static void setExam(ArrayList<String> examDetails)
{
    String resultdata="";
    ExamList.setText(resultdata);
    examCount= examDetails.size();
for (int i=0;i<examDetails.size();i++)
    {
        resultdata=resultdata+" "+examDetails.get(i);
    }
    ExamList.setText(resultdata);
}

}






