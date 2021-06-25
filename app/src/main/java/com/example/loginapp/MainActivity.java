package com.example.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
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
        String id, pass, score1, score2;
        if (extras != null) {
            id = extras.getString("id");
            pass = extras.getString("pass");
            score1 = extras.getString("score1");
            score2 = extras.getString("score2");

        }else {
            id ="0";
            pass="0";
            score1 = "0";
            score2 = "0";
        }

        if (score1 == null){
            score1 = "0";
        }
        if (score2 == null){
            score2 = "0";
        }

        TextView text = findViewById(R.id.text);

        Button next = findViewById(R.id.buttonNext);
        Button quiz = findViewById(R.id.buttonQuiz);

        RadioButton j1 = findViewById(R.id.radioJ1);
        RadioButton j2 = findViewById(R.id.radioJ2);

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

        String finalScore = score1;
        String finalScore1 = score2;
        quiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, DistrictActivity.class);

                if (j1.isChecked()){
                    intent.putExtra("joueur", "1");
                    intent.putExtra("score1", finalScore);
                    intent.putExtra("score2", finalScore1);
                } else {
                    intent.putExtra("joueur", "2");
                    intent.putExtra("score2", finalScore1);
                    intent.putExtra("score1", finalScore);
                }
                startActivity(intent);
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
