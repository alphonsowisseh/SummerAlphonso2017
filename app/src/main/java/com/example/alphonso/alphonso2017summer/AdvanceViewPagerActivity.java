package com.example.alphonso.alphonso2017summer;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alphonso.alphonso2017summer.adapter.ViewFragmentStateAdapter;
import com.example.alphonso.alphonso2017summer.fragment.BlueFragment;
import com.example.alphonso.alphonso2017summer.fragment.GreenFragment;
import com.example.alphonso.alphonso2017summer.fragment.RedFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AdvanceViewPagerActivity extends AppCompatActivity {

   private ArrayList<Pair<String, Fragment>> list = new ArrayList<Pair<String, Fragment>>();

    @BindView(R.id.activity_advance_view_pager_tablayout)
    TabLayout tabLayout;

    @BindView(R.id.activity_advance_view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_view_pager);
        ButterKnife.bind(this);
        list.add(new Pair("Red",new  RedFragment()));
        list.add(new Pair("Blue",new BlueFragment()));
        list.add(new Pair("Green",new GreenFragment()));

        ViewFragmentStateAdapter adapter = new ViewFragmentStateAdapter(this.getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
