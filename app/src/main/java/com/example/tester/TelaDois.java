package com.example.tester;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Spinner;
import android.widget.Toast;


public class TelaDois extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner spinner =findViewById(R.id.menuEstad);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.estados, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }




    public void menuact(View view) {
        EditText usernameEditText = findViewById(R.id.editTextUsername1);
        EditText passwordEditText = findViewById(R.id.editTextPassword1);
        EditText croEditText = findViewById(R.id.editTextCROC);
        Spinner menuEstado = findViewById(R.id.menuEstad);
        EditText emailEditText = findViewById(R.id.editTextEmail);
        EditText phoneEditText = findViewById(R.id.editTextPhone);
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String estado = menuEstado.getSelectedItem().toString();;
        String croS = croEditText.getText().toString();

        Dentista dentista = new Dentista();
        dentista.nomeDentista = username;
        dentista.senhaDentista = String.valueOf(password);
        dentista.CRO = croS;
        dentista.emailDentista = String.valueOf(emailEditText);
        dentista.TelefoneDentista = String.valueOf(phoneEditText);
        dentista.Estado=  estado;




        BancodeDados dbHelper = BancodeDados.ShareInstance(this);
        boolean credenciaisCorretas = dbHelper.verificarCredenciais(username, password);
        if (credenciaisCorretas) {
            // Credenciais corretas, faça o que for necessário (por exemplo, inicie a próxima atividade)
            Toast.makeText(TelaDois.this, "Login bem-sucedido", Toast.LENGTH_SHORT).show();
            Intent in = new Intent(TelaDois.this, MenuActivity.class);
            startActivity(in);
        } else {
            // Credenciais incorretas
            Toast.makeText(TelaDois.this, "Login falhou", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

