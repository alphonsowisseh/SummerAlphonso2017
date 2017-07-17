package com.example.alphonso.alphonso2017summer;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.alphonso.alphonso2017summer.adapter.ScalePagerAdapter;

import java.util.ArrayList;

public class PatchActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ScalePagerAdapter adapter;
    private View view1;
    private ArrayList<View> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patch);
        viewPager = (ViewPager) findViewById(R.id.activity_patch_view_Pager);
        LayoutInflater lf  = getLayoutInflater().from(this);

        view1 = lf.inflate(R.layout.view_9patch,null);


        list = new ArrayList<>();
        list.add(view1);

        adapter = new ScalePagerAdapter(list);

        viewPager.setAdapter(adapter);

    }
}
