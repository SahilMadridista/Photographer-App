package com.example.photographerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class SignUpActivityPartTwo extends AppCompatActivity {

   private Spinner CategorySpinner;
   private TextView CateText;
   ArrayList<String> Categories = new ArrayList<>();
   RecyclerView recyclerView;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_sign_up_part_two);

      CateText = findViewById(R.id.categories);
      CategorySpinner = findViewById(R.id.cate_spinner);
      ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
              R.array.category, android.R.layout.simple_spinner_item);
      adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      CategorySpinner.setAdapter(adapter);

      Button btn = findViewById(R.id.add_cate_btn);
      btn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            addcategory();
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


      recyclerView = findViewById(R.id.category_recyclerview);
      recyclerView.setHasFixedSize(true);
      recyclerView.setLayoutManager(new LinearLayoutManager(this));
      recyclerView.setAdapter(new CategoryAdapter(Categories));

      System.out.println("---------------------------------------------------------------");



      StringBuilder sb = new StringBuilder();
      Iterator<String> iterator = Categories.iterator();

      if (iterator.hasNext()) {
         sb.append(iterator.next());

         while (iterator.hasNext()) {
            sb.append(", ");
            sb.append(iterator.next());
         }
      }
      CateText.setText(sb);


   }

   public static int linearSearch(ArrayList<String> Categories, String key){
      for(int i=0;i<Categories.size();i++){
         if(Categories.get(i).equals(key)){
            return i;
         }
      }
      return -1;
   }



}