package com.venture.vebschool.Teacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.synnapps.carouselview.CarouselView;
import com.venture.vebschool.R;
import com.venture.vebschool.Teacher.TeacherMenu.TAssignment.TeacherAssignment;
import com.venture.vebschool.Teacher.TeacherMenu.TAttendance.TeacherAttendance;
import com.venture.vebschool.Teacher.TeacherMenu.TEvents.TeacherEvents;
import com.venture.vebschool.Teacher.TeacherMenu.TExam.TeacherExam;
import com.venture.vebschool.Teacher.TeacherMenu.THome.TeacherHomeActivity;
import com.venture.vebschool.Teacher.TeacherMenu.THomeWork.TeacherHomeWork;
import com.venture.vebschool.Teacher.TeacherMenu.TMark.TeacherMarkSheet;
import com.venture.vebschool.Teacher.TeacherMenu.TMessage.TeacherMessage;
import com.venture.vebschool.Teacher.TeacherMenu.TNews.TeacherNews;
import com.venture.vebschool.Teacher.TeacherMenu.TPayment.TeacherPayment;
import com.venture.vebschool.Teacher.TeacherMenu.TStudent.TeacherStudent;
import com.venture.vebschool.Teacher.TeacherMenu.TTimeTable.TeacherTimeTable;

public class LayoutActivity extends Fragment {
    CardView c_student,c_attendance,c_mark,c_time,c_message,c_exam,c_events,c_news,c_payment,c_home,c_homework,c_assignment;
    TextView cancel,exit;
    CarouselView carouselView1 ;
    int[] sampleImages1 = {R.drawable.school, R.drawable.sl, R.drawable.slc, R.drawable.sch, R.drawable.s};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try
        {
        View view = inflater.inflate(R.layout.layout_activity, container, false);
      /*  carouselView1 = view.findViewById(R.id.sliderLayout1);

        carouselView1.setPageCount(sampleImages1.length);
        carouselView1.setSlideInterval(3000);
        carouselView1.setImageListener(imageListener1);*/


        c_student = view.findViewById(R.id.student_card);
        c_attendance = view.findViewById(R.id.attendance_card);
        c_mark = view.findViewById(R.id.marks_card);
        c_time = view.findViewById(R.id.timetble_card);
        c_message = view.findViewById(R.id.message_card);
        c_exam = view.findViewById(R.id.exam_card);
        c_events = view.findViewById(R.id.events_card);
        c_news = view.findViewById(R.id.news_card);
        c_payment = view.findViewById(R.id.payments_card);
        c_home = view.findViewById(R.id.home_card);
        c_homework = view.findViewById(R.id.homework_card);
        c_assignment = view.findViewById(R.id.assignment_card);


        c_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TeacherStudent.class);
                startActivity(intent);
            }
        });
        c_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TeacherAttendance.class);
                startActivity(intent);
            }
        });
        c_mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TeacherMarkSheet.class);
                startActivity(intent);
            }
        });
        c_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TeacherTimeTable.class);
                startActivity(intent);
            }
        });
        c_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TeacherMessage.class);
                startActivity(intent);
            }
        });
        c_exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TeacherExam.class);
                startActivity(intent);
            }
        });

        c_events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TeacherEvents.class);
                startActivity(intent);
            }
        });

        c_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TeacherNews.class);
                startActivity(intent);
            }
        });

        c_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TeacherPayment.class);
                startActivity(intent);
            }
        });
        c_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TeacherHomeActivity.class);
                startActivity(intent);
            }
        });
        c_homework.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TeacherHomeWork.class);
                startActivity(intent);
            }
        });
        c_assignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TeacherAssignment.class);
                startActivity(intent);
            }
        });
    }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return super.onCreateView(inflater, container, savedInstanceState);

    }


  /*  ImageListener imageListener1 = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {

            /*Picasso.with(this)
                    .load("https://cms-assets.tutsplus.com/uploads/users/21/posts/19431/featured_image/CodeFeature.jpg")
                    .into(imageView);*/
           /* imageView.setImageResource(sampleImages1[position]);
        }
    };
*/



}
