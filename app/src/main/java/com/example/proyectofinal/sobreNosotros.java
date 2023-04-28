package com.example.proyectofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class sobreNosotros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre_nosotros);
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