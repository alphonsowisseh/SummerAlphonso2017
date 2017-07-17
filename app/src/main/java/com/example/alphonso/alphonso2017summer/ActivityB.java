package com.example.alphonso.alphonso2017summer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.alphonso.alphonso2017summer.util.UtilLog;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityB extends BaseActivity {


    @OnClick(R.id.Button_A)
    public void clickA(View v){
        gotoActivity(ActivityA.class);
    }

    @OnClick(R.id.Button_B)
    public void clickB(View v){
        gotoActivity(ActivityB.class);
    }

    @OnClick(R.id.Button_C)
    public void clickC(View v){
        gotoActivity(ActivityC.class);

    }

    @OnClick(R.id.Button_D)
    public void clickD(View v){
        gotoActivity(ActivityD.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        ButterKnife.bind(this);
        showToast("OnCreate");
        UtilLog.d("LifeCycle","OnCreate B");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        showToast("OnNewIntent");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle","onStart B");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle","onStop B");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle","onDestroy B");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle","onPause B");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle","onResume B");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle","onRestart B");
    }
}
