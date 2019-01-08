package com.example.maxwu.recyclerview;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mNumbers = new ArrayList<>();
    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mNames.add("John");
        mNames.add("Nick");
        mNumbers.add("1");
        mNumbers.add("2");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.contactrv);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ListSize = mNames.size();
                // Add a new word to the wordList.
                mNames.add("+ NewName " + ListSize);
                mNumbers.add("+ NewNumber " + ListSize);
                // Notify the adapter, that the data has changed.
                recyclerView.getAdapter().notifyItemInserted(ListSize);
                // Scroll to the bottom.
                recyclerView.smoothScrollToPosition(ListSize);
            }
        });
        ContactAdapter adapter = new ContactAdapter(this,mNames,mNumbers);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,R.integer.number));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.reset:
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }
}
