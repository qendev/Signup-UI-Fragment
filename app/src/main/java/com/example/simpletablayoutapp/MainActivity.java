package com.example.simpletablayoutapp;

import android.app.ActionBar;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TabHost;
import android.widget.ZoomControls;

import static android.view.animation.Animation.*;

public class MainActivity extends AppCompatActivity {


    private TabLayout tablayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tablayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);

        ViewPagerAdapter vadapter = new ViewPagerAdapter(getSupportFragmentManager());

        //adding fragments and giving them Titles
        vadapter.AddFragment(new FragmentSignin(), "SIGN IN");
        vadapter.AddFragment(new FragmentRegister(), "REGISTER");

        //setup adapter with the viewPager
        viewPager.setAdapter(vadapter);
        tablayout.setupWithViewPager(viewPager);
        viewPager.setPageTransformer(true,new ZoomOutPageTransformation());
    }
}




