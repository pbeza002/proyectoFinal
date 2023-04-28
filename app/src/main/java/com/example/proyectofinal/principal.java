package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectofinal.login;

public class principal extends AppCompatActivity {

    Button inicio;
    Button registro;
    Button protectora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        inicio= findViewById(R.id.p_inicio);
        registro = findViewById(R.id.p_regis);
        protectora = findViewById(R.id.p_protec);

        inicio.setOnClickListener(view -> {
            Intent i = new Intent( principal.this, login.class);
            startActivity(i);
        });
        registro.setOnClickListener(view -> {
            Intent i = new Intent( principal.this, signUp.class);
            startActivity(i);
        });
        protectora.setOnClickListener(view -> {
            Intent i = new Intent( principal.this, protectora.class);
            startActivity(i);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}