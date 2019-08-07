package com.venture.vebschool.Parent;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import com.venture.vebschool.Login;
import com.venture.vebschool.Parent.MenuActivities.Assignment.AssignmentActivity;
import com.venture.vebschool.Parent.MenuActivities.Attendance.AttendanceActivity;
import com.venture.vebschool.Parent.MenuActivities.Complaint.ComplaintActivity;
import com.venture.vebschool.Parent.MenuActivities.Event.EventActivity;
import com.venture.vebschool.Parent.MenuActivities.Exam.ExamActivity;
import com.venture.vebschool.Parent.MenuActivities.HomeWork.HomeWorkActivity;
import com.venture.vebschool.Parent.MenuActivities.Leave.LeaveActivity;
import com.venture.vebschool.Parent.MenuActivities.Mark.MarkActivity;
import com.venture.vebschool.Parent.MenuActivities.Message.MessageActivity;
import com.venture.vebschool.Parent.MenuActivities.News.NewsActivity;
import com.venture.vebschool.Parent.MenuActivities.Holiday.HolidayActivity;
import com.venture.vebschool.Parent.MenuActivities.Student.StudentActivity;
import com.venture.vebschool.Parent.MenuActivities.Subject.SubjectActivity;
import com.venture.vebschool.Parent.MenuActivities.TimeTable.TimetableActivity;
import com.venture.vebschool.Parent.Submenu.ProfileActivity;
import com.venture.vebschool.Parent.Submenu.SettingsActivity;
import com.venture.vebschool.R;

public class Home extends AppCompatActivity {
    CardView cstudent,cattendance,cmark,ctime,cmessage,cexam,cevents,cnews,choliday,csub,chome,cleave,cassignment,complaint;
    TextView cancel,exit;
    CarouselView carouselView ;
    int[] sampleImages = {R.drawable.school, R.drawable.sl, R.drawable.slc, R.drawable.sch, R.drawable.s};
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_activity);
        carouselView = (CarouselView) findViewById(R.id.sliderLayout);

        carouselView.setPageCount(sampleImages.length);
        carouselView.setSlideInterval(3000);
        carouselView.setImageListener(imageListener);


        cstudent=findViewById(R.id.student);
        cattendance=findViewById(R.id.attendance);
        cmark=findViewById(R.id.marks);
        ctime=findViewById(R.id.timetble);
        cmessage=findViewById(R.id.message);
        cexam=findViewById(R.id.exam);
        cevents=findViewById(R.id.events);
        cnews=findViewById(R.id.news);
        choliday=findViewById(R.id.holiday);
        csub=findViewById(R.id.sub);
        chome=findViewById(R.id.home);
        cleave=findViewById(R.id.leave);
        cassignment=findViewById(R.id.assign);
        complaint=findViewById(R.id.com);

        cstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this, StudentActivity.class);
                startActivity(intent);
            }
        });
        cattendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this, AttendanceActivity.class);
                startActivity(intent);
            }
        });
        cmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this, MarkActivity.class);
                startActivity(intent);
            }
        });
        ctime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this, TimetableActivity.class);
                startActivity(intent);
            }
        });
        cmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this, MessageActivity.class);
                startActivity(intent);
            }
        });
        cexam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this, ExamActivity.class);
                startActivity(intent);
            }
        });
        cevents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this, EventActivity.class);
                startActivity(intent);
            }
        });
        cnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this, NewsActivity.class);
                startActivity(intent);
            }
        });
        choliday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this, HolidayActivity.class);
                startActivity(intent);
            }
        });
        csub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this, SubjectActivity.class);
                startActivity(intent);
            }
        });
        chome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,HomeWorkActivity.class);
                startActivity(intent);
            }
        });
        cleave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this, LeaveActivity.class);
                startActivity(intent);
            }
        });
        cassignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this, AssignmentActivity.class);
                startActivity(intent);
            }
        });
        complaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this, ComplaintActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menuprofile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();
        switch (id) {
            case R.id.profile:
                Intent intent = new Intent(Home.this, ProfileActivity.class);
                startActivity(intent);
                return true;
            case R.id.settings:
                Intent intent1 = new Intent(Home.this, SettingsActivity.class);
                startActivity(intent1);
                return true;
            case R.id.logout:
                Dialog dialog=new Dialog(Home.this);
                dialog.setContentView(R.layout.activity_logout);
                cancel=dialog.findViewById(R.id.can);
                exit=dialog.findViewById(R.id.ok);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent =new Intent(getApplicationContext(),Home.class);
                        startActivity(intent);
                    }
                });
                exit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Home.this, Login.class);
                        startActivity(intent);
                    }
                });
                dialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {

            /*Picasso.with(this)
                    .load("https://cms-assets.tutsplus.com/uploads/users/21/posts/19431/featured_image/CodeFeature.jpg")
                    .into(imageView);*/
            imageView.setImageResource(sampleImages[position]);
        }
    };
}
