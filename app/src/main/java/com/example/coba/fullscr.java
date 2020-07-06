package com.example.coba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class fullscr extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscr);

        imageView = (ImageView) findViewById(R.id.imageview);

        Intent i = getIntent();

        int position = i.getExtras().getInt("id");

        imageadapter imageadapter = new imageadapter(this);

        imageView.setImageResource(imageadapter.imageArray[position]);

    }
}