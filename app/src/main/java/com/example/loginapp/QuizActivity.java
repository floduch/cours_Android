package com.example.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_round_arrow_back_24);
        actionBar.setDisplayHomeAsUpEnabled(true);

        TextView J1 = findViewById(R.id.textJ1);
        TextView J2 = findViewById(R.id.textJ2);

        TextView scoreJ1 = findViewById(R.id.scoreJ1);
        TextView scoreJ2 = findViewById(R.id.scoreJ2);

        TextView question = findViewById(R.id.textQuestion);

        Button rep1 = findViewById(R.id.button1);
        Button rep2 = findViewById(R.id.button2);
        Button rep3 = findViewById(R.id.button3);
        Button rep4 = findViewById(R.id.button4);

        ArrayList<String> quest= new ArrayList<>();

        String[][] questions = new String[2][4];





        question.setText("Qui est le président de la France");
        rep1.setText("François HOLLANDE");
        rep2.setText("Jacque CHIRAC");
        rep3.setText("Emmanuel MACRON");
        rep4.setText("La réponse D");
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