package com.example.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_round_arrow_back_24);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        String id, pass;
        if (extras != null) {
            id = extras.getString("id");
            pass = extras.getString("pass");
            // and get whatever type user account id is
        }else {
            id ="0";
            pass="0";
        }

        TextView text = findViewById(R.id.text);

        Button next = findViewById(R.id.buttonNext);
        Button quiz = findViewById(R.id.buttonQuiz);

        if (Locale.getDefault().getDisplayLanguage().equals("en")){

            text.setText("Welcome " + id + ", your password is " + pass);

        } else {
            text.setText("Bienvenue " + id + ", votre mot de passe est " + pass);
        }

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ComplexActivity.class));
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, QuizActivity.class));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
