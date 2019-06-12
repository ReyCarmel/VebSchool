package com.venture.vebschool;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.venture.vebschool.MenuActivities.AttendanceActivity;
import com.venture.vebschool.MenuActivities.EventActivity;
import com.venture.vebschool.MenuActivities.ExamActivity;
import com.venture.vebschool.MenuActivities.MarkActivity;
import com.venture.vebschool.MenuActivities.MessageActivity;
import com.venture.vebschool.MenuActivities.NewsActivity;
import com.venture.vebschool.MenuActivities.PaymentActivity;
import com.venture.vebschool.MenuActivities.StudentActivity;
import com.venture.vebschool.MenuActivities.TimetableActivity;
import com.venture.vebschool.Submenu.LogoutActivity;
import com.venture.vebschool.Submenu.ProfileActivity;
import com.venture.vebschool.Submenu.SettingsActivity;

import java.util.HashMap;

public class Home extends AppCompatActivity {
    CardView cstudent,cattendance,cmark,ctime,cmessage,cexam,cevents,cnews,cpayment;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SliderLayout sliderLayout = (SliderLayout) findViewById(R.id.sliderLayout);
        HashMap<String, Integer> sliderImages = new HashMap<>();
        sliderImages.put(" ", R.drawable.veb_icon);
        sliderImages.put("  ", R.drawable.veb_icon);
        sliderImages.put(" ", R.drawable.veb_icon);
        sliderImages.put(" ", R.drawable.veb_icon);
        sliderImages.put(" ", R.drawable.veb_icon);

        for (String name : sliderImages.keySet()) {

            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView
                    .description(name)
                    .image(sliderImages.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);

        cstudent=findViewById(R.id.student);
        cattendance=findViewById(R.id.attendance);
        cmark=findViewById(R.id.marks);
        ctime=findViewById(R.id.timetble);
        cmessage=findViewById(R.id.message);
        cexam=findViewById(R.id.exam);
        cevents=findViewById(R.id.events);
        cnews=findViewById(R.id.news);
        cpayment=findViewById(R.id.payments);

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
        cpayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this, PaymentActivity.class);
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
                dialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
