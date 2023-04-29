package com.example.proyectofinal.ViewModel;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.proyectofinal.Database.Database;
import com.example.proyectofinal.Model.Usuario;

public class ViewModel extends AndroidViewModel implements Database.vminterface {
    private Usuario user;
    private static ViewModel vm;

    private Database db ;

    public ViewModel(@NonNull Application application) {
        super(application);
        db = new Database(this);
    }

    public static ViewModel getInstance(AppCompatActivity a) {
        if(vm == null){
            vm = new ViewModelProvider(a).get(ViewModel.class);
        }
        return vm;
    }

    @Override
    public void setuser(Usuario user) {
        this.user = user;
    }

    public void signUpUser(String correo, String contraseña) {
        db.SignUpUser(correo, contraseña);
    }
    public void singInUser(String correo, String password){
        db.SignInUser(correo, password);

    }
}
