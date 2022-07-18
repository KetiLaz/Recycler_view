package com.example.askisi51;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        TextView txt_title = findViewById(R.id.txt_title);
        TextView txt_description = findViewById(R.id.txt_description);
        ImageButton image = findViewById(R.id.image);

        Recipe recipe = new Recipe(SecondActivity.this, getIntent().getExtras().getInt("recipe_id"));

        txt_title.setText(recipe.getTitle());
        txt_description.setText(recipe.getDescription());
        Picasso.get().load(recipe.getImage()).into(image);


    }
}