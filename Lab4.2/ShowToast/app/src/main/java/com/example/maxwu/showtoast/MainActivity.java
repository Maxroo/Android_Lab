package com.example.maxwu.showtoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox a,b,c,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = findViewById(R.id.AA);
        b = findViewById(R.id.BB);
        c = findViewById(R.id.CC);
        d = findViewById(R.id.DD);

    }

    public void ShowToast(View view) {
        String result = "";
        a.isChecked();
        result += checklisten(a);
        result += checklisten(b);
        result += checklisten(c);
        result += checklisten(d);
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
    public String checklisten(CheckBox x)
    {
        boolean u;
        u = x.isChecked();
        if (u)
        {
           return x.getText().toString();
        }
        return "";
    }
}
