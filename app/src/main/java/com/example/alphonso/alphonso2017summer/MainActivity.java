package com.example.alphonso.alphonso2017summer;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alphonso.alphonso2017summer.fragment.DemoFragment;
import com.example.alphonso.alphonso2017summer.fragment.WorkFragment;

public class MainActivity extends AppCompatActivity {
//
    private TextView demo_tv;
    private TextView work_tv;
    private TextView final_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialView();
        setListener();
        //
    }


    private void initialView() {
        demo_tv = (TextView) findViewById(R.id.activity_tool_demo);
        work_tv = (TextView) findViewById(R.id.activity_tool_work);
        final_tv = (TextView) findViewById(R.id.activity_tool_final);

    }

    private void setListener() {
       final  WorkFragment workfragment = new WorkFragment();
       final DemoFragment demofragment = new DemoFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_fragment,demofragment).commit();

        demo_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"you have clicked a demo button",Toast.LENGTH_SHORT).show();
                work_tv.setTextColor(Color.BLACK);
                demo_tv.setTextColor(Color.RED);
                final_tv.setTextColor(Color.BLACK);
                findViewById(R.id.activity_main_title).setVisibility(View.VISIBLE);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.activity_main_fragment,demofragment).commit();
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Hey this is your work",Toast.LENGTH_SHORT).show();
                work_tv.setTextColor(Color.RED);
                demo_tv.setTextColor(Color.BLACK);
                final_tv.setTextColor(Color.BLACK);
                findViewById(R.id.activity_main_title).setVisibility(View.VISIBLE);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.activity_main_fragment,workfragment).commit();
            }
        };
        work_tv.setOnClickListener(listener);


    }

    public void login(View v){
        Toast.makeText(MainActivity.this,"you clicked login",Toast.LENGTH_SHORT).show();
    }
}
