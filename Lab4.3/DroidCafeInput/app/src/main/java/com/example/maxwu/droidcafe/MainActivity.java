package com.example.maxwu.droidcafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE =
            "com.example.android.droidcafe.extra.MESSAGE";

    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.option_order:
                Intent intent = new Intent(this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE,message);
                displayToast(getString(R.string.action_order_message));
                startActivity(intent);
                return true;

            case R.id.option_Status:
                displayToast(getString(R.string.action_status_message));
                return true;

            case R.id.option_favorite:
                displayToast(getString(R.string.action_favorites_message));
                return true;

            case R.id.option_Contact:
                displayToast(getString(R.string.action_contact_message));
                return true;



        }
        return super.onOptionsItemSelected(item);
    }

    public void showDonutOrder(View view) {
        displayToast(getString(R.string.donut_order_message));
        message = getResources().getString(R.string.donut_order_message);
    }
    public void showIceCreamOrder(View view) {
        message = getResources().getString(R.string.ice_cream_order_message);
        displayToast(getString(R.string.ice_cream_order_message));
    }

    public void showFroyoOrder(View view) {
        displayToast(getString(R.string.froyo_order_message));
        message = getResources().getString(R.string.froyo_order_message);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }

}
