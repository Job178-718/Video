package com.example.video.activity;

import android.os.Bundle;
import android.view.Menu;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import com.example.video.R;
import com.example.video.adapter.MyViewPagerAdapter;
import com.example.video.fragment.CategoryFragment;
import com.example.video.fragment.home.HomeFragment;
import com.example.video.fragment.MeFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private View mTab0, mTab1, mTab2;
    private ImageView igView0,igView1,igView2;
    private TextView tView0,tView1,tView2;
    private HomeActivity homeActivity = null;
    private List<Fragment> listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        homeActivity = this;

        viewPager = findViewById(R.id.tabhomepager);
        listFragment = new ArrayList<>();

        viewPager.addOnPageChangeListener(this);
        mTab0 = findViewById(R.id.tab0);
        mTab1 = findViewById(R.id.tab1);
        mTab2 = findViewById(R.id.tab2);

        igView0 = findViewById(R.id.index_tab0_img);
        igView1 = findViewById(R.id.index_tab1_img);
        igView2 = findViewById(R.id.index_tab2_img);

        igView0.setOnClickListener(this);
        igView1.setOnClickListener(this);
        igView2.setOnClickListener(this);

        tView0 = findViewById(R.id.index_tab0_text);
        tView1 = findViewById(R.id.index_tab1_text);
        tView2 = findViewById(R.id.index_tab2_text);


        HomeFragment homeFragment = new HomeFragment();

        CategoryFragment categoryFragment = new CategoryFragment();
        MeFragment meFragment = new MeFragment();

        listFragment.add(homeFragment);
        listFragment.add(categoryFragment);
        listFragment.add(meFragment);


        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(),listFragment);
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.setCurrentItem(0);
    }

    @Override
    public void onClick(View view) {
        initViewColor();
        switch (view.getId()){
            case R.id.index_tab0_img:
                igView0.setImageDrawable(ContextCompat.getDrawable(homeActivity, R.mipmap.home_blur));
                tView0.setTextColor(ContextCompat.getColor(homeActivity, R.color.main_color));
                viewPager.setCurrentItem(0);
                break;
            case R.id.index_tab1_img:
                igView1.setImageDrawable(ContextCompat.getDrawable(homeActivity, R.mipmap.category_blur));
                tView1.setTextColor(ContextCompat.getColor(homeActivity, R.color.main_color));
                viewPager.setCurrentItem(1);
                break;
            case R.id.index_tab2_img:
                igView2.setImageDrawable(ContextCompat.getDrawable(homeActivity, R.mipmap.wo_blur));
                tView2.setTextColor(ContextCompat.getColor(homeActivity, R.color.main_color));
                viewPager.setCurrentItem(2);
                break;
            default:
                break;
        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        initViewColor();
        switch (position) {
            case 0:
                igView0.setImageDrawable(ContextCompat.getDrawable(homeActivity, R.mipmap.home_blur));
                tView0.setTextColor(ContextCompat.getColor(homeActivity, R.color.main_color));
                break;
            case 1:
                igView1.setImageDrawable(ContextCompat.getDrawable(homeActivity, R.mipmap.category_blur));
                tView1.setTextColor(ContextCompat.getColor(homeActivity, R.color.main_color));
                break;
            case 2:
                igView2.setImageDrawable(ContextCompat.getDrawable(homeActivity, R.mipmap.wo_blur));
                tView2.setTextColor(ContextCompat.getColor(homeActivity, R.color.main_color));
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageSelected(int position) {
        // Fragment fragment = listFragment.get(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    public void initViewColor(){
        igView0.setImageDrawable(ContextCompat.getDrawable(homeActivity, R.mipmap.home));
        igView1.setImageDrawable(ContextCompat.getDrawable(homeActivity, R.mipmap.category));
        igView2.setImageDrawable(ContextCompat.getDrawable(homeActivity, R.mipmap.wo));

        tView0.setTextColor(ContextCompat.getColor(homeActivity, R.color.main_color_disabled));
        tView1.setTextColor(ContextCompat.getColor(homeActivity, R.color.main_color_disabled));
        tView2.setTextColor(ContextCompat.getColor(homeActivity, R.color.main_color_disabled));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item = menu.findItem(R.id.menu_search);
        ActionProvider searchView = MenuItemCompat.getActionProvider(item);
        return super.onCreateOptionsMenu(menu);
    }

}