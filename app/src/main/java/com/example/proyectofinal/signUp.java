package com.example.proyectofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofinal.ViewModel.ViewModel;

import java.util.regex.Pattern;

public class signUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Button termino = findViewById(R.id.button2);
        CheckBox check = findViewById(R.id.terminos2_check);
        Button cuenta = findViewById(R.id.volver_boton);
        EditText email_reg = findViewById(R.id.email_reg);
        EditText password = findViewById(R.id.confcon_reg2);
        EditText confirm_password = findViewById(R.id.confcon_reg);
        EditText phone = findViewById(R.id.editTextPhone2);
        EditText name = findViewById(R.id.email_reg2);
        ViewModel vm = ViewModel.getInstance(this);
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
        cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo = email_reg.getText().toString();
                String contraseña = password.getText().toString();
                if(!correcctemail(correo)){
                    email_reg.setError("Correo Incorrecto.");
                }
                else if(!contraseña.equals(confirm_password.getText().toString())){
                        confirm_password.setError(("Contraseñas no coinciden"));
                    }
                else{
                    vm.signUpUser(correo, contraseña);
                    Intent i = new Intent(signUp.this, sobreNosotros.class);
                    startActivity(i);
                }

                }

        });
    }
    private boolean correcctemail(String correo){
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(correo).matches();
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
