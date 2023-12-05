package com.example.tester;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.tester.TelaCadastroActivity.*;
import com.example.tester.*;


public class conta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta);
        EditText editTextUsername = findViewById(R.id.editTextUsername0);
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextCRO = findViewById(R.id.editTextCRO);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText editTextPhone= findViewById(R.id.editTextTelefone);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText editTextEstado = findViewById(R.id.editTextEstado);



        editTextUsername.setHint(Dentista.nomeDentista);
        editTextUsername.setEnabled(false);
        editTextEmail.setHint(Dentista.emailDentista);
        editTextEmail.setEnabled(false);
        editTextCRO.setHint(Dentista.CRO);
        editTextCRO.setEnabled(false);
        editTextPhone.setHint(Dentista.TelefoneDentista);
        editTextPhone.setEnabled(false);
        editTextEstado.setHint(Dentista.Estado);
        editTextEstado.setEnabled(false);

    }

    public void voltarmenu(View view) {
        Intent in = new Intent( conta.this, MenuActivity.class);
        startActivity(in);

    }
}