package com.example.proyectofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectofinal.ViewModel.ViewModel;

import java.util.regex.Pattern;

public class login extends AppCompatActivity {
    private ViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        vm = ViewModel.getInstance(this);

        Button registre = findViewById(R.id.login_boton);
        EditText email_log = findViewById(R.id.email);
        EditText password = findViewById(R.id.contrasena);

        registre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo = email_log.getText().toString();
                String contraseña = password.getText().toString();
                if(correo.equals("") || contraseña.equals("")){
                    if(correo.equals(""))
                        password.setError("El campo está vacío");
                    if(contraseña.equals(""))
                        email_log.setError("El campo está vacío");
                }
                else{
                    vm.singInUser(correo, contraseña);
                    Intent i = new Intent(login.this, sobreNosotros.class);
                    startActivity(i);
                }


            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        if(menu != null){
            menu.findItem(R.id.item1).setVisible(false);
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =  item.getItemId();

        if(id==R.id.item1){
            Toast.makeText(this,"boton 1",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.item2){
            Toast.makeText(this,"boton2",Toast.LENGTH_SHORT).show();

        }else if(id==R.id.item3){
            Toast.makeText(this,"boton3",Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }
}
