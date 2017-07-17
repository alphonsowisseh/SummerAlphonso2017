package com.example.alphonso.alphonso2017summer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

   public void showToast(String s){
      Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
   }

   public void gotoActivity(Class activity) {
      Intent intent = new Intent(this, activity);
      startActivity(intent);
   }
}
