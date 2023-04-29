package com.example.proyectofinal.Database;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.proyectofinal.Model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class Database extends Activity {
    private FirebaseAuth firebaseauth = FirebaseAuth.getInstance();
    private FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    public static final String tag = "Database";
    public static Database db;

    public static vminterface listener;
    public interface vminterface{
        void setuser(Usuario user);

    }

    public Database(vminterface listener) {
        db = this;
        this.listener = listener;
    }

    public void SignUpUser(String email, String password){
        firebaseauth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //PopUp, "USUARIO REGISTRADO"
                    Log.w(tag, "autentificado correctamente!");
                }
                else{
                    Log.w(tag, "autentificación incorrecta.!");
                }
            }
        });

    }
    public void SignInUser(String email, String password){
        firebaseauth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //PopUp, "USUARIO REGISTRADO"
                    Log.w(tag, "Conectado correctamente!");
                }
                else{
                    Log.w(tag, "Información incorrecta.!");
                }
            }
        });
    }

}
