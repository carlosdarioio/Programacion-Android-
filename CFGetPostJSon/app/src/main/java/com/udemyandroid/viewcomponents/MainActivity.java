package com.udemyandroid.viewcomponents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin;
    EditText editTextEmail, editTextPassword,editTextClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.buttonLogin);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextClave = findViewById(R.id.clave);

        // Asignación del evento click
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // CheckBox checkBox = (CheckBox)v;
        // boolean seleccionado = checkBox.isChecked();
        Log.i("APP", "Click en login");

        String email = editTextEmail.getText().toString();
        String pass = editTextPassword.getText().toString();
        String clave = editTextClave.getText().toString();

        if(!email.isEmpty() && !pass.isEmpty()) {
            Intent intentLogin = new Intent(this, HomeActivity.class);
            intentLogin.putExtra("cl", clave);
            startActivity(intentLogin);
        } else {
            editTextEmail.setError("Completar usuario y contraseña");
        }
    }
}
//idea aqui en el load deberia de get todos lo usuarios y psd