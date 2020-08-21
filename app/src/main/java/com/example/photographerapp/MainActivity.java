package com.example.photographerapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      requestWindowFeature(Window.FEATURE_NO_TITLE);
      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
              WindowManager.LayoutParams.FLAG_FULLSCREEN);

      setContentView(R.layout.activity_main);

      TextView AppName,TagLine;
      final Button LoginButton;
      final TextView CreateAccText = findViewById(R.id.create_account_text);
      CreateAccText.setPaintFlags(CreateAccText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

      AppName = findViewById(R.id.title_text);
      TagLine = findViewById(R.id.tag_line_text);
      LoginButton = findViewById(R.id.button);

      AppName.animate().alpha(1).setDuration(800);
      TagLine.animate().alpha(1).setDuration(800);

      new Handler().postDelayed(new Runnable() {
         @Override
         public void run() {
            LoginButton.setVisibility(View.VISIBLE);

            YoYo.with(Techniques.BounceIn)
                    .repeat(0)
                    .duration(1000)
                    .playOn(LoginButton);

            CreateAccText.setVisibility(View.VISIBLE);

            YoYo.with(Techniques.BounceIn)
                    .repeat(0)
                    .duration(1000)
                    .playOn(CreateAccText);

         }
      },800);

      LoginButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
         }
      });

      CreateAccText.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            startActivity(new Intent(getApplicationContext(),SignUpActivity.class));
         }
      });

   }

}