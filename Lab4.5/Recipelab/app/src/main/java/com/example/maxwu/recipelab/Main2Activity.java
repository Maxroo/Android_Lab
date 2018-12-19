package com.example.maxwu.recipelab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView foodname,foodtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        foodname = findViewById(R.id.foodname2);
        foodtext = findViewById(R.id.foodtext2);
        Intent intent = getIntent();
        foodname.setText(intent.getStringExtra("FoodName"));
        String food = foodname.getText().toString();
//        int idfoodtext = getResources().getIdentifier("Pasta1","String",this.getPackageName());
//        foodtext.setText(R.string.idfoodtext);

        foodtext.setText(getResources().getIdentifier(foodname.getText().toString(),"string",this.getPackageName()));
    }
}
