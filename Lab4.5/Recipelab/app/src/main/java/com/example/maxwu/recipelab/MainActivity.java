package com.example.maxwu.recipelab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> foodnames = new ArrayList<>();
    ArrayList<String> foodtexts = new ArrayList<>();

    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        foodnames.add("Pasta1");
        foodnames.add("Pasta2");
        foodnames.add("Pasta3");
        foodtexts.add("It's a pasta");
        foodtexts.add("It's a pasta");
        foodtexts.add("It's a pasta");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        Adapter adapter = new Adapter(this, foodnames, foodtexts, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    void toRecipe(Intent intent)
    {
        startActivity(intent);
    }


}
