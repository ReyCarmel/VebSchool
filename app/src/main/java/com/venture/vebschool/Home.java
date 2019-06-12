package com.venture.vebschool;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

public class Home extends AppCompatActivity {

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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menuprofile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id=item.getItemId();
        switch (id){
            case R.id.profile:
                Intent intent=new Intent(Home.this,ProfileActivity.class);
                startActivity(intent);
                return true;
            case R.id.settings:
                    Intent intent1=new Intent(Home.this,SettingsActivity.class);
                    startActivity(intent1);
                        return true;
            case R.id.logout:
                    Intent intent2=new Intent(Home.this,LogoutActivity.class);
                return true;
            default:
                return super.onOptionsItemSelected(item);




            return super.onOptionsItemSelected(item);
    }
}
