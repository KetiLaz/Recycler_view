package com.example.askisi51;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter {
    ArrayList<Recipe> recipes;
    Context context;

    public RecipeAdapter() {
    }

    public RecipeAdapter(Context context, ArrayList<Recipe> recipes ) {
        this.context = context;
        this.recipes = recipes;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View row = layoutInflater.inflate(R.layout.my_row, parent, false);
        MyViewHolder holder = new MyViewHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder)holder).txtVw_title.setText(String.valueOf(recipes.get(position).getTitle()));
        ((MyViewHolder)holder).txtVw_description.setText(String.valueOf(recipes.get(position).getDescription()));
        Picasso.get().load(recipes.get(position).getImage()).into(((MyViewHolder)holder).img);

        int item_position = position;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("recipe_id", recipes.get(item_position).getId());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return this.recipes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtVw_title;
        TextView txtVw_description;
        ImageButton img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtVw_title = itemView.findViewById(R.id.txtVw_title);
            txtVw_description = itemView.findViewById(R.id.txtVw_description);
            img = itemView.findViewById(R.id.img);
        }
    }
}
