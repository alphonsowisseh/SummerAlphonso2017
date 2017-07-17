package com.example.alphonso.alphonso2017summer;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SharedPreferenceActivity extends BaseActivity {

    @BindView(R.id.activity_sharedpreference_email)
    EditText emailEditText;

    @BindView(R.id.activity_sharedpreference_password)
    EditText passEditText;

    @OnClick(R.id.activity_sharedpreference_login)
    public void login(View v){
        String email = emailEditText.getText().toString();
        String password = passEditText.getText().toString();
        if(check(email,password)){
            showToast("Login Success");
        }
    }

    @OnClick(R.id.activity_sharedpreference_clear)
    public void clear(View v){
        SharedPreferences sp  = getSharedPreferences("user", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
        emailEditText.setText("");
        passEditText.setText("");
        showToast("You have cleared");
    }

    private boolean check(String email, String password) {
        boolean passwordCorrect= true;
        if(passwordCorrect){
            SharedPreferences sp  = getSharedPreferences("user", MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("email",email);
            editor.putString("password",password);
            editor.commit();
            return true;

        }else
            return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        ButterKnife.bind(this);
        retriveLoginInfo();
    }

    private void retriveLoginInfo() {
        SharedPreferences sp = getSharedPreferences("user",MODE_PRIVATE);
        String email= sp.getString("email","null");
       String password = sp.getString("password","null");
        if(!email.equals("null")){
            emailEditText.setText(email);
            passEditText.setText(password);
        }
    }
}
