package com.example.maxwu.levellistdraw;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    ImageView textView;
    int level = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.appCompatImageView);
        textView.setImageLevel(level);

    }

    public void minus(View view) {
        level = level -1;
        setLevel(level);
    }

    public void plus(View view) {
        level = level + 1;
        setLevel(level);
    }

    public void setLevel(int level) {
        if (level > 3)
        {
            level = 3;
        }else if (level < 0)
        {
            level = 0;
        }
        textView.setImageLevel(level);
    }
}
