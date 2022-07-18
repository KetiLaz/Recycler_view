package com.example.askisi51;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Recipe {
    private int id;
    private String title;
    private String description;
    private String image;

    public Recipe() {
    }

    public Recipe(String title, String description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public static ArrayList<Recipe> getAll(Context context) {
        ArrayList<Recipe> recipes = new ArrayList<>();

        SQlite sqlite = new SQlite(context);
        SQLiteDatabase database = sqlite.getWritableDatabase();

        Cursor cursor = database.query(SQlite.TABLE_RECIPE, SQlite.RECIPE_COLUMN,null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Recipe recipe = new Recipe();
            recipe.id = cursor.getInt(0);
            recipe.title = cursor.getString(1);
            recipe.description = cursor.getString(2);
            recipe.image = cursor.getString(3);

            recipes.add(recipe);

            cursor.moveToNext();
        }
        database.close();
        sqlite.close();
        return recipes;
    }

    public Recipe(Context context, int id) {
        SQlite sql = new SQlite(context);
        SQLiteDatabase database = sql.getWritableDatabase();

        Cursor cursor = database.query(SQlite.TABLE_RECIPE, SQlite.RECIPE_COLUMN, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        cursor.moveToFirst();

        this.id = id;
        this.title = cursor.getString(1);
        this.description = cursor.getString(2);
        this.image = cursor.getString(3);

        database.close();
        sql.close();
    }

    public String getImage() {
        return image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
