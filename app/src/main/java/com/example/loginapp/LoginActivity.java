package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

                Toast myToast = Toast.makeText(LoginActivity.this,  "Bonjour "+ identifiant.getText().toString(), Toast.LENGTH_SHORT);
                myToast.show();

                mainActivity.putExtra("id", identifiant.getText().toString());
                mainActivity.putExtra("pass", password.getText().toString());
                startActivity(mainActivity);

            }
        });
    }
}