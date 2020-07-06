package com.example.coba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class uta extends AppCompatActivity {
    TextView mProfil, mGaleri, mKontak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uta);

        mProfil = findViewById(R.id.profile);
        mGaleri = findViewById(R.id.galeri);
        mKontak = findViewById(R.id.kontakk);

        mProfil.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           startActivity(new Intent(getApplicationContext(), profile.class));
                                       }
                                   });

        mGaleri.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             startActivity(new Intent(getApplicationContext(), galeri.class));
                                         }
                                     });
        mKontak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), kontakk.class));
            }
        });

    }
}
