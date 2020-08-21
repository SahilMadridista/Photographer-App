package com.example.photographerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SignUpActivityPartTwo extends AppCompatActivity {

   private Spinner CategorySpinner;
   ArrayList<String> Categories = new ArrayList<>();
   ArrayList<String> Cities = new ArrayList<>();
   RecyclerView CategoryRecyclerView,CityRecyclerView;
   EditText CityEditText;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_sign_up_part_two);

      CategorySpinner = findViewById(R.id.cate_spinner);
      ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
              R.array.category, android.R.layout.simple_spinner_item);
      adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      CategorySpinner.setAdapter(adapter);


      CityEditText = findViewById(R.id.city_et);
      Button btn = findViewById(R.id.add_cate_btn);
      btn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            addcategory();
         }
      });

      Button AddCityButton = findViewById(R.id.add_city_btn);
      AddCityButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            AddCity();
         }
      });


      Button button = findViewById(R.id.signup_v_btn);
      button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            startActivity(new Intent(getApplicationContext(),HomePageActivity.class));
         }
      });


   }

   private void AddCity() {

      String City = CityEditText.getText().toString().trim();

      if(City.isEmpty()){
         Toast.makeText(getApplicationContext(),"Please enter a city",Toast.LENGTH_SHORT).show();
         return;
      }

      if(Cities.size() == 0){
         Cities.add(City);
      }

      else{

         int i = citySearch(Cities,City);

         if(i == -1){
            Cities.add(City);
         }

         else{
            Toast.makeText(getApplicationContext(),"The city is already selected",Toast.LENGTH_SHORT).show();
         }
      }

      CityRecyclerView = findViewById(R.id.city_recyclerview);
      CityRecyclerView.setHasFixedSize(true);
      CityRecyclerView.setLayoutManager(new LinearLayoutManager(this));
      CityAdapter adapter = new CityAdapter(Cities);
      CityRecyclerView.setAdapter(adapter);

      CityEditText.getText().clear();



   }

   private void addcategory() {

      String Categ = CategorySpinner.getSelectedItem().toString().trim();

      if(Categ.equals("Categories")){
         Toast.makeText(getApplicationContext(),"Please select a category",Toast.LENGTH_SHORT).show();
      }

      else{

         if(Categories.size() == 0){
            Categories.add(Categ);
         }

         else{

            int i = linearSearch(Categories,Categ);

            if(i == -1){
               Categories.add(Categ);
            }

            else{
               Toast.makeText(getApplicationContext(),"The category is already selected",Toast.LENGTH_SHORT).show();
            }
         }
      }


      CategoryRecyclerView = findViewById(R.id.category_recyclerview);
      CategoryRecyclerView.setHasFixedSize(true);
      CategoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
      CategoryAdapter adapter = new CategoryAdapter(Categories);
      CategoryRecyclerView.setAdapter(adapter);


   }

   public static int linearSearch(ArrayList<String> Categories, String key){
      for(int i=0;i<Categories.size();i++){
         if(Categories.get(i).toLowerCase().equals(key.toLowerCase())){
            return i;
         }
      }
      return -1;
   }

   public static int citySearch(ArrayList<String> Cities, String key){
      for(int i=0;i<Cities.size();i++){
         if(Cities.get(i).equals(key)){
            return i;
         }
      }
      return -1;
   }



}