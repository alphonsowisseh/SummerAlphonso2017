package com.example.alphonso.alphonso2017summer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.alphonso.alphonso2017summer.service.TestService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ServiceActivity extends AppCompatActivity {

    @BindView(R.id.service_text_view)
    TextView textView;
    private TestReceiver testReceiver;

    @OnClick(R.id.Service_start_button)
    public void StartService(View v){
        Intent intent = new Intent(this,TestService.class);
        intent.putExtra("Service","Start");
        startService(intent);
        registerBroadcast();
    }

    @OnClick(R.id.Service_stop_button)
    public void StopService(View v){
        Intent intent = new Intent(this,TestService.class);
        intent.putExtra("Service","Stop");
        startService(intent);
        registerBroadcast();
    }

    private void registerBroadcast() {
        testReceiver = new TestReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(TestService.ACTION);
        registerReceiver(testReceiver,filter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        ButterKnife.bind(this);
    }

    public class TestReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String action =intent.getAction();
            if(action.equals(TestService.ACTION)){
                int update = intent.getIntExtra("update",0);
                textView.setText(String.valueOf(update));
            }
        }
    }
}
