package com.example.tester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class TelaCadastroActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        Spinner spinner =findViewById(R.id.menuEstado);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.estados, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        EditText usernameEditText = findViewById(R.id.editTextUsername);
        EditText passwordEditText = findViewById(R.id.editTextPassword);
        EditText croEditText = findViewById(R.id.editTextCRO);
        EditText emailEditText = findViewById(R.id.editTextEmail);
        EditText phoneEditText = findViewById(R.id.editTextPhone);
        Spinner menuEstado = findViewById(R.id.menuEstado);
        Button registerButton = findViewById(R.id.buttonLogin);


        BancodeDados dbHelper = BancodeDados.ShareInstance(this);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  username = usernameEditText.getText().toString();
                String passwordString = passwordEditText.getText().toString();
                int password = Integer.parseInt(passwordString);
                String croString = croEditText.getText().toString();
                int cro = Integer.parseInt(croString);
                String email = emailEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String estado = menuEstado.getSelectedItem().toString();;

                 Dentista dentista = new Dentista();
                dentista.nomeDentista = username;
                dentista.senhaDentista = String.valueOf(password);
                dentista.CRO = String.valueOf(cro);
                dentista.emailDentista = email;
                dentista.TelefoneDentista = phone;
                dentista.Estado=  estado;




                long id = dbHelper.insert(dentista);
                if (id != -1L) {
                    Toast.makeText(TelaCadastroActivity.this, "Dr(a) " + username + " Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                    Log.d("banco", "Inserção realizada. ID: " + id);



                    Intent in = new Intent( TelaCadastroActivity.this, MenuActivity.class);
                    startActivity(in);
                    // Navigate to the next activity
                } else {
                    Toast.makeText(TelaCadastroActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                }
            }


        });




    }



    public void mainactivity(View view) {
        Intent in = new Intent( TelaCadastroActivity.this, MainActivity.class);
        startActivity(in);
    }


    public void menuacti(View view) {

    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}