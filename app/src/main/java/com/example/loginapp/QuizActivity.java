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
        String noQ, joueur;

        final String[] score1 = new String[1];
        final String[] score2 = new String[1];

        if (extras != null) {
            noQ = extras.getString("noQ");
            joueur = extras.getString("joueur");
            score1[0] = extras.getString("score1");
            score2[0] = extras.getString("score2");

            // and get whatever type user account id is
        } else {
            noQ = "0";
            joueur = "1";
            score1[0] = "0";
            score2[0] = "0";
        }

        Intent intent = new Intent(QuizActivity.this, DistrictActivity.class);

        TextView J1 = findViewById(R.id.textJ1);
        TextView J2 = findViewById(R.id.textJ2);

        TextView scoreJ1 = findViewById(R.id.scoreJ1);
        TextView scoreJ2 = findViewById(R.id.scoreJ2);

        System.out.println(score1[0]);
        scoreJ1.setText(score1[0]);
        scoreJ2.setText(score2[0]);

        TextView question = findViewById(R.id.textQuestion);

        Button rep1 = findViewById(R.id.button1);
        Button rep2 = findViewById(R.id.button2);
        Button rep3 = findViewById(R.id.button3);
        Button rep4 = findViewById(R.id.button4);

        Button valider = findViewById(R.id.buttonVal);

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

        ArrayList<String> questions = new ArrayList<>();
        questions.add("Dans quelle ville se trouve le Louvres ?");
        questions.add("Quel est le pr??nom de Mr Eiffel");
        questions.add("En quelle ann??e l'H??tel de Ville a ??t?? construit ?");

        HashMap<String, ArrayList> listQuestRep = new HashMap<>();

        ArrayList<String> reponsesQ1 = new ArrayList<>();
        reponsesQ1.add("Marseille");
        reponsesQ1.add("Reims");
        reponsesQ1.add("Paris");
        reponsesQ1.add("La r??ponse D");

        ArrayList<String> reponsesQ2 = new ArrayList<>();
        reponsesQ2.add("G??rard");
        reponsesQ2.add("Griezmann");
        reponsesQ2.add("Jean");
        reponsesQ2.add("Gustave");

        ArrayList<String> reponsesQ3 = new ArrayList<>();
        reponsesQ3.add("1000");
        reponsesQ3.add("1357");
        reponsesQ3.add("1899");
        reponsesQ3.add("2000");

        ArrayList<String> bonneRep = new ArrayList<>();
        bonneRep.add("Paris");
        bonneRep.add("Gustave");
        bonneRep.add("1357");


        listQuestRep.put(questions.get(0), reponsesQ1);
        listQuestRep.put(questions.get(1), reponsesQ2);
        listQuestRep.put(questions.get(2), reponsesQ3);

        ArrayList<ArrayList> listes = new ArrayList<>();
        listes.add(listQuestRep.get(questions.get(0)));
        listes.add(listQuestRep.get(questions.get(1)));
        listes.add(listQuestRep.get(questions.get(2)));

        question.setText(questions.get(Integer.parseInt(noQ)));


        for (int i = 0; i < reponsesQ1.size(); i++) {
            System.out.println(listes.get(Integer.parseInt(noQ)).get(i));
            bout.get(bouton.get(i)).setText(String.valueOf(listes.get(Integer.parseInt(noQ)).get(i)));
        }

        for (int i = 0; i < bouton.size(); i++) {
            int finalI = i;
            bout.get(bouton.get(i)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    if (bout.get(bouton.get(finalI)).getText().toString().equals(bonneRep.get(Integer.parseInt(noQ)))) {
                        bout.get(bouton.get(finalI)).setBackgroundColor(getResources().getColor(R.color.green));

                        if (joueur.equals("1")){
                            score1[0] = String.valueOf(Integer.parseInt(score1[0]) + 1);
                            scoreJ1.setText(score1[0]);
                            intent.putExtra("score1", score1[0]);
                            intent.putExtra("joueur", "1");
                            intent.putExtra("score2", score2[0]);
                        }else {
                            score2[0] = String.valueOf(Integer.parseInt(score2[0]) + 1);
                            scoreJ2.setText(score2[0]);
                            intent.putExtra("score2", score2[0] );
                            intent.putExtra("joueur", "2");
                            intent.putExtra("score1", score1[0]);
                        }


                    } else {
                        bout.get(bouton.get(finalI)).setBackgroundColor(getResources().getColor(R.color.purple_500));

                        if (joueur.equals("1")){
                            scoreJ1.setText(score1[0]);
                            intent.putExtra("score1", score1[0]);
                            intent.putExtra("joueur", "1");
                            intent.putExtra("score2", score2[0]);
                        }else {
                            scoreJ2.setText(score2[0]);
                            intent.putExtra("score2", score2[0] );
                            intent.putExtra("joueur", "2");
                            intent.putExtra("score1", score1[0]);
                        }

                    }

                    for (int i = 0; i < bouton.size(); i++) {
                        bout.get(bouton.get(i)).setEnabled(false);
                    }
                }
            });
        }
        valider.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
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