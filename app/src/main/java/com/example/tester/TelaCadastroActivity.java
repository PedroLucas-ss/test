package com.example.tester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaCadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
    }

    public void mainactivity(View view) {
        Intent in = new Intent( TelaCadastroActivity.this, MainActivity.class);
        startActivity(in);
    }


    public void menuacti(View view) {
        Intent in = new Intent( TelaCadastroActivity.this, MenuActivity.class);
        startActivity(in);
    }
}