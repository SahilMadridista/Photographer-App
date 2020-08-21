package com.example.photographerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

   private ArrayList<String> Categories;

   public CategoryAdapter(ArrayList<String> Categories){
      this.Categories = Categories;
   }

   @NonNull
   @Override
   public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
      View view = layoutInflater.inflate(R.layout.recyclerview_single_item,parent,false);
      return new CategoryViewHolder(view);
   }

   @Override
   public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

      String data = Categories.get(position);
      holder.CategoryName.setText(data);

   }

   @Override
   public int getItemCount() {
      return 0;
   }

   public static class CategoryViewHolder extends RecyclerView.ViewHolder{

      TextView CategoryName;
      ImageView DeleteImage;

      public CategoryViewHolder(@NonNull View itemView) {
         super(itemView);

         CategoryName = itemView.findViewById(R.id.category_card_text);
         DeleteImage = itemView.findViewById(R.id.delete_icon);

      }

   }

}
