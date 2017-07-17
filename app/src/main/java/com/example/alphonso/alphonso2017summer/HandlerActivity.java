package com.example.alphonso.alphonso2017summer;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.alphonso.alphonso2017summer.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HandlerActivity extends BaseActivity {

    @BindView(R.id.activity_handler_et)
    EditText editText;

    @BindView(R.id.activity_handler_bt)
    Button button;
    private View.OnClickListener startLisener;
    private View.OnClickListener stopListener;
    private View.OnClickListener resetListener;
    private Thread thread;
    public static final int TIMER = 123;

    Handler mHandler = new Handler(){


        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case TIMER:
                    Bundle bundle = msg.getData();
                    String string = bundle.getString("msg");
                    showToast("Message: " + string);
                    int number = Integer.valueOf(editText.getText().toString());
                    editText.setText(String.valueOf(--number));

                    if (number==0){
                        button.setText("Reset");
                        button.setOnClickListener(resetListener);
                    }else{
                        thread.run();
                    }
                    break;
                default:
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        ButterKnife.bind(this);

        startLisener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText("Stop");
                editText.setEnabled(false);
                button.setOnClickListener(stopListener);
                startThread();
            }
        };

        stopListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText("Reset");
                button.setOnClickListener(resetListener);
            }
        };

        resetListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText("Start");
                editText.setEnabled(true);
                button.setOnClickListener(startLisener);
            }
        };
        button.setOnClickListener(startLisener);


    }

    private void startThread() {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                    Message msg = new Message();
                    Bundle bundle = new Bundle();
                    bundle.putString("msg","TimerMessage");
                    msg.setData(bundle);
                    msg.what = TIMER;
                    mHandler.handleMessage(msg);
                    int num = Integer.valueOf(editText.getText().toString());
                    editText.setText(String.valueOf(num-1));
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        thread.start();

    }
}

