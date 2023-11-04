package com.example.tester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaDois extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mainactivity(View view) {
        Intent in = new Intent(TelaDois.this, MainActivity.class);
        startActivity(in);
    }


    public void menuact(View view) {
        Intent in = new Intent(TelaDois.this, MenuActivity.class);
        startActivity(in);
    }
}

