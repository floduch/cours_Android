package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText identifiant = findViewById(R.id.editId);
        EditText password = findViewById(R.id.editPass);

        Button connect = findViewById(R.id.buttonConnect);

        Intent mainActivity = new Intent(this, MainActivity.class);

        connect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (verif(identifiant.getText().toString(), password.getText().toString())){

                    if (Locale.getDefault().getDisplayLanguage().equals("en")){

                        Toast myToast = Toast.makeText(LoginActivity.this,  "Identifiant ou mot de passe incorrect", Toast.LENGTH_SHORT);
                        myToast.show();

                    } else {

                        Toast myToast = Toast.makeText(LoginActivity.this,  "Bonjour "+ identifiant.getText().toString(), Toast.LENGTH_SHORT);
                        myToast.show();

                        mainActivity.putExtra("id", identifiant.getText().toString());
                        mainActivity.putExtra("pass", password.getText().toString());
                        startActivity(mainActivity);
                    }

                } else {

                    if (Locale.getDefault().getDisplayLanguage().equals("en")){
                        Toast myToast = Toast.makeText(LoginActivity.this,  "Hello "+ identifiant.getText().toString(), Toast.LENGTH_SHORT);
                        myToast.show();

                        mainActivity.putExtra("id", identifiant.getText().toString());
                        mainActivity.putExtra("pass", password.getText().toString());
                        startActivity(mainActivity);

                    } else {
                        Toast myToast = Toast.makeText(LoginActivity.this,  "Username or password is incorrect", Toast.LENGTH_SHORT);
                        myToast.show();
                    }
                }
            }
        });
    }

    public Boolean verif(String id, String pass){
        if (id.equals("florian") && pass.equals("duchaine")){
            return true;
        }else {
            return false;
        }
    }
}