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
import android.widget.ImageView;
import android.widget.TextView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
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
    CardView c_student, c_attendance, c_mark, c_time, c_message, c_exam, c_events, c_news, c_payment, c_home, c_homework, c_assignment;
    CarouselView carouselView1;
    int[] sampleImages1 = {R.drawable.school, R.drawable.sl, R.drawable.slc, R.drawable.sch, R.drawable.s};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=null;
        try {
             view = inflater.inflate(R.layout.teacher_layout, container, false);


        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return view;
    }


    ImageListener imageListener1 = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView)
        {

            //Picasso.with(this)
                //    .load("https://cms-assets.tutsplus.com/uploads/users/21/posts/19431/featured_image/CodeFeature.jpg")
                //    .into(imageView);*/
           // imageView.setImageResource(sampleImages1[position]);
        }
    };




}
