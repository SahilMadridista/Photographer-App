package com.example.photographerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {

   private ArrayList<String> Cities;

   public CityAdapter(ArrayList<String> Categories){
      this.Cities = Categories;
   }

   @NonNull
   @Override
   public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
      View view = layoutInflater.inflate(R.layout.recyclerview_single_item,parent,false);
      return new CityViewHolder(view);
   }

   @Override
   public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {

      String data = Cities.get(position);
      holder.CategoryName.setText(data);

   }

   @Override
   public int getItemCount() {
      return Cities.size();
   }

   public static class CityViewHolder extends RecyclerView.ViewHolder{

      TextView CategoryName;
      ImageView DeleteImage;

      public CityViewHolder(@NonNull View itemView) {
         super(itemView);

         CategoryName = itemView.findViewById(R.id.category_card_text);
         DeleteImage = itemView.findViewById(R.id.delete_icon);

      }


   }

}
