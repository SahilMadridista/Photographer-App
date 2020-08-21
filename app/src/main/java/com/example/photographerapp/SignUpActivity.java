package com.example.photographerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.google.android.material.snackbar.Snackbar;

public class SignUpActivity extends AppCompatActivity {

   RelativeLayout relativeLayout;
   private Spinner GenderSpinner;
   private EditText Fname,Lname,Email,Phone,Address,City,PinCode;
   private ImageView image;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_sign_up);

      image = findViewById(R.id.user_image);
      Fname = findViewById(R.id.first_name_et);
      Lname = findViewById(R.id.last_name_et);
      Email = findViewById(R.id.email_et);
      Phone = findViewById(R.id.phone_et);
      Address = findViewById(R.id.address_et);
      City = findViewById(R.id.city_et);
      PinCode = findViewById(R.id.code_et);


      GenderSpinner = findViewById(R.id.spinner);
      relativeLayout = findViewById(R.id.content_layout);

      ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
              R.array.gender, android.R.layout.simple_spinner_item);
      adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      GenderSpinner.setAdapter(adapter);

      Button button = findViewById(R.id.next_btn);
      button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            checkDetails();
         }
      });


   }

   private void checkDetails() {

      /*Drawable myDrawable = image.getDrawable();
      if(myDrawable.equals(R.drawable.user)){
         String snack = "Please select a profile photo by click on the white user image on the top";
         showSnackbar(snack);
         return;
      }

      if(Fname.getText().toString().trim().isEmpty()){
         String snack = "Please enter your first name";
         showSnackbar(snack);
         return;
      }

      if(Email.getText().toString().trim().isEmpty()){
         String snack = "Please enter your email address";
         showSnackbar(snack);
         return;
      }

      if(!Patterns.EMAIL_ADDRESS.matcher(Email.getText().toString().trim()).matches()){
         String snack = "Please enter a valid email address";
         showSnackbar(snack);
         return;
      }

      if(Phone.getText().toString().trim().isEmpty()){
         String snack = "Please enter your phone number";
         showSnackbar(snack);
         return;
      }

      if(Phone.getText().toString().trim().length() != 10){
         String snack = "Please enter a valid phone number";
         showSnackbar(snack);
         return;
      }

      if(Address.getText().toString().trim().isEmpty()){
         String snack = "Please enter your residential address";
         showSnackbar(snack);
         return;
      }

      if(City.getText().toString().trim().isEmpty()){
         String snack = "Please enter your city";
         showSnackbar(snack);
         return;
      }

      if(PinCode.getText().toString().trim().isEmpty()){
         String snack = "Please enter your pin code";
         showSnackbar(snack);
         return;
      }

      if(GenderSpinner.getSelectedItem().toString().trim().equals("Gender")){
         String snack = "Please select your gender";
         showSnackbar(snack);
         return;
      }*/

      Intent i = new Intent(getApplicationContext(),SignUpActivityPartTwo.class);
      startActivity(i);


   }

   private void showSnackbar(String snack) {

      Snackbar snackbar = Snackbar.make(relativeLayout,snack,Snackbar.LENGTH_LONG);
      snackbar.show();

   }


}