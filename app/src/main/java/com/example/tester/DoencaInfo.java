package com.example.tester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DoencaInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doenca_info);
    }

    public void voltarmenuu(View view) {
        Intent in = new Intent( DoencaInfo.this, MenuActivity.class);
        startActivity(in);
    }
}