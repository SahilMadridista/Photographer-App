package com.example.photographerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class HomePageActivity extends AppCompatActivity {

   androidx.appcompat.widget.Toolbar toolbar;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_home_page);

      toolbar = findViewById(R.id.home_toolbar);
      setSupportActionBar(toolbar);


   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      MenuInflater inflater = getMenuInflater();
      inflater.inflate(R.menu.menu,menu);
      return super.onCreateOptionsMenu(menu);
   }

   @Override
   public boolean onOptionsItemSelected(@NonNull MenuItem item) {

      switch (item.getItemId()) {

         case R.id.settings:

            // Add code here

            startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
            break;

         default:
            return super.onOptionsItemSelected(item);
      }

      return true;

   }

}