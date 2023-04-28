package com.example.proyectofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class signUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Button termino = findViewById(R.id.button2);
        CheckBox check = findViewById(R.id.terminos2_check);
        Button cuenta = findViewById(R.id.volver_boton);
        termino.setOnClickListener(view -> {
            Intent i = new Intent( signUp.this, condiciones.class);
            startActivity(i);
        });

        cuenta.setEnabled(false);
        cuenta.setTextColor(Color.WHITE);

        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cuenta.setEnabled(check.isChecked());
                if(cuenta.isEnabled())
                    cuenta.setTextColor(Color.BLACK);
                else cuenta.setTextColor(Color.WHITE);
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
