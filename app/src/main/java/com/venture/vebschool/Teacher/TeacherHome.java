package com.venture.vebschool.Teacher;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import com.venture.vebschool.Login;
import com.venture.vebschool.R;
import com.venture.vebschool.Teacher.TeacherSubMenu.TeacherProfile;
import com.venture.vebschool.Teacher.TeacherSubMenu.TeacherSettings;

public class TeacherHome extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView t_exit,t_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fragment fm=new LayoutActivity();
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame1,fm).commit();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.teacher_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.profile:
                Intent intent = new Intent(TeacherHome.this, TeacherProfile.class);
                startActivity(intent);
                return true;
            case R.id.settings:
                Intent intent1 = new Intent(TeacherHome.this, TeacherSettings.class);
                startActivity(intent1);
                return true;
            case R.id.logout:
                Dialog dialog=new Dialog(TeacherHome.this);
                dialog.setContentView(R.layout.activity_logout);
                t_cancel=dialog.findViewById(R.id.can);
                t_exit=dialog.findViewById(R.id.ok);
                t_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent =new Intent(getApplicationContext(),TeacherHome.class);
                        startActivity(intent);
                    }
                });
                t_exit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(TeacherHome.this, Login.class);
                        startActivity(intent);
                    }
                });
                dialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_attendance) {
            // Handle the camera action
        } else if (id == R.id.nav_mark) {

        } else if (id == R.id.nav_homework) {

        } else if (id == R.id.nav_assign) {

        } else if (id == R.id.nav_exam) {

        } else if (id == R.id.nav_events) {

        }else if (id == R.id.nav_news) {

        }else if (id == R.id.nav_leaves) {

        }else if (id == R.id.nav_payment) {

        }



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
