package com.example.alphonso.alphonso2017summer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class ResultActivity extends BaseActivity {

    private final int ACTIVITY1 = 123;
    private final int ACTIVITY2 = 321;


    @OnClick(R.id.activity_result_bt1)
    public void toResult1(View view){
        Intent intent1 = new Intent(ResultActivity.this,ResultActivity1.class);
        startActivityForResult(intent1,ACTIVITY1);
    }

    @OnClick(R.id.activity_result_bt2)
    public void toResult2(View view){
        Intent intent2 = new Intent(ResultActivity.this,ResultActivity2.class);
        startActivityForResult(intent2,ACTIVITY2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String s = data.getStringExtra("Data");
        switch (requestCode){
            case ACTIVITY1:
                showToast(s+" FromResultActivity1");
                break;
            case ACTIVITY2:
                showToast(s+" FromResultActivity2");
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
    }
}
