package com.example.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_round_arrow_back_24);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        String noQ;
        if (extras != null) {
            noQ = extras.getString("noQ");

            // and get whatever type user account id is
        } else {
            noQ = "0";
        }


        TextView J1 = findViewById(R.id.textJ1);
        TextView J2 = findViewById(R.id.textJ2);

        TextView scoreJ1 = findViewById(R.id.scoreJ1);
        TextView scoreJ2 = findViewById(R.id.scoreJ2);

        TextView question = findViewById(R.id.textQuestion);

        Button rep1 = findViewById(R.id.button1);
        Button rep2 = findViewById(R.id.button2);
        Button rep3 = findViewById(R.id.button3);
        Button rep4 = findViewById(R.id.button4);

        ProgressBar progress = findViewById(R.id.progressBar);

//

        ArrayList<Button> bouton = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            bouton.add(new Button(getBaseContext()));
        }

        HashMap<Button, Button> bout = new HashMap<>();
        bout.put(bouton.get(0), rep1);
        bout.put(bouton.get(1), rep2);
        bout.put(bouton.get(2), rep3);
        bout.put(bouton.get(3), rep4);

        HashMap<Integer, String> questions = new HashMap<>();
        questions.put(0, "Qui est le président de la France ?");
        questions.put(1, "Quelle est la capitale de la Thaïlande ?");

        HashMap<String, HashMap> listQuestRep = new HashMap<>();
        HashMap<Integer, HashMap> listRep = new HashMap<>();

        HashMap<Integer, String> reponsesQ1 = new HashMap<>();
        reponsesQ1.put(0, "François Hollande");
        reponsesQ1.put(1, "Jacques Chirac");
        reponsesQ1.put(2, "Emmanuel Macron");
        reponsesQ1.put(3, "La réponse D");

        HashMap<Integer, String> reponsesQ2 = new HashMap<>();
        reponsesQ2.put(0, "Paris");
        reponsesQ2.put(1, "Bangkok");
        reponsesQ2.put(2, "Londres");
        reponsesQ2.put(3, "Vientiane");

        listQuestRep.put(questions.get(0), reponsesQ1);
        listQuestRep.put(questions.get(1), reponsesQ2);

        question.setText(questions.get(0));

        for (int i = 0; i < reponsesQ1.size(); i++) {
            bout.get(bouton.get(i)).setText(reponsesQ1.get(i));
        }

        for (int i = 0; i < bouton.size(); i++) {
            int finalI = i;
            bout.get(bouton.get(i)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    if (bout.get(bouton.get(finalI)).getText().toString().equals("Emmanuel Macron")) {
                        bout.get(bouton.get(finalI)).setBackgroundColor(getResources().getColor(R.color.green));
                        scoreJ1.setText("1");
                        progress.setProgress(20);


                    } else {
                        bout.get(bouton.get(finalI)).setBackgroundColor(getResources().getColor(R.color.purple_500));
                    }

                    for (int i = 0; i < bouton.size(); i++) {
                        bout.get(bouton.get(i)).setEnabled(false);
                    }
                }
            });
        }
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