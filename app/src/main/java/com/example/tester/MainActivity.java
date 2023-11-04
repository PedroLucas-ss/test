package com.example.tester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
    }
    public void teladois(View view) {
        Intent in = new Intent( MainActivity.this, TelaDois.class);
        startActivity(in);
    }

    public void telacadastro(View view) {
        Intent in = new Intent( MainActivity.this, TelaCadastroActivity.class);
        startActivity(in);
    }
}