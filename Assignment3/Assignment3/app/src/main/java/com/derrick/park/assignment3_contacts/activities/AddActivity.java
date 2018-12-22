package com.derrick.park.assignment3_contacts.activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.derrick.park.assignment3_contacts.R;

import org.w3c.dom.Text;

public class AddActivity extends AppCompatActivity {
    private TextView name;
    private TextView phone;
    private TextView fname;

    private TextView nametv;
    private TextView phonetv;
    private TextView fnametv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        name = findViewById(R.id.etn);
        fname = findViewById(R.id.etnf);
        phone = findViewById(R.id.etp);
        nametv = findViewById(R.id.lntv);
        phonetv = findViewById(R.id.ptv);
        fnametv = findViewById(R.id.fntv);
        nametv.setTextColor(Color.BLACK);
        fnametv.setTextColor(Color.BLACK);
        phonetv.setTextColor(Color.BLACK);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bmain, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.finish) {
            boolean phoneb = phone.getText().toString().matches("\\d{10}");
            boolean lnameb = !name.getText().toString().isEmpty();
            boolean fnameb = !fname.getText().toString().isEmpty();
            if ( lnameb && phoneb && fnameb) {

                Intent replyIntent = new Intent();
                replyIntent.putExtra("name", name.getText().toString());
                replyIntent.putExtra("phone", phone.getText().toString());
                replyIntent.putExtra("fname", fname.getText().toString());
                setResult(RESULT_OK, replyIntent);
                finish();
            } else
            {
                if (!lnameb)
                {
                    nametv.setTextColor(Color.RED);
                }else
                {
                    nametv.setTextColor(Color.BLACK);
                }
                if (!phoneb)
                {
                    phonetv.setTextColor(Color.RED);
                }else
                {
                    phonetv.setTextColor(Color.BLACK);

                }
                if (!fnameb)
                {
                    fnametv.setTextColor(Color.RED);
                }else
                {
                    fnametv.setTextColor(Color.BLACK);
                }
            }
        }
        return true;

    }
}


