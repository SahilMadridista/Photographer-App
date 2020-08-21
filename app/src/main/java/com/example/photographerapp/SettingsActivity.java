package com.example.photographerapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.Objects;

public class SettingsActivity extends AppCompatActivity {


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_settings);

      String[] settings = getResources().getStringArray(R.array.settings_options);

      ListView listView = findViewById(R.id.listview);

      final ArrayAdapter adapter = new ArrayAdapter(this,
              R.layout.list_item, R.id.list_text, settings);

      listView.setAdapter(adapter);

      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

            Toast.makeText(getApplicationContext(),
                    Objects.requireNonNull(adapter.getItem(position)).toString(),
                    Toast.LENGTH_SHORT).show();

         }
      });

   }
}