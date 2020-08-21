package com.example.photographerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

   private RelativeLayout relativeLayout;
   private EditText editText;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_login);

      Button GetOTP = findViewById(R.id.submit_btn);
      relativeLayout = findViewById(R.id.parent);
      editText = findViewById(R.id.phone_et);
      final ImageView imageView = findViewById(R.id.phone_image);

      GetOTP.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            sendOTP();
         }
      });

      new Handler().postDelayed(new Runnable() {
         @Override
         public void run() {
            YoYo.with(Techniques.Swing)
                    .duration(1500)
                    .repeat(1500)
                    .playOn(imageView);
         }
      },0);

   }

   private void sendOTP() {

      if(editText.getText().toString().trim().isEmpty()){
         String snack = "Please enter phone number";
         showSnackbar(snack);
         return;
      }

      if(editText.getText().toString().trim().length() != 10){
         String snack = "Please enter valid phone number";
         showSnackbar(snack);
         return;
      }

      String hint = getResources().getString(R.string.rec_otp);
      String full = hint + editText.getText().toString().trim();

      Intent i = new Intent(getApplicationContext(),OtpVerificationActivity.class);
      i.putExtra("fullText",full);
      startActivity(i);


   }

   private void showSnackbar(String snack) {

      Snackbar snackbar = Snackbar.make(relativeLayout,snack,Snackbar.LENGTH_LONG);
      snackbar.show();

   }


}