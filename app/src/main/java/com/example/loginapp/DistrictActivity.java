package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DistrictActivity extends AppCompatActivity {
    private GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);

        Bundle extras = getIntent().getExtras();
        String joueur, score1, score2;
        if (extras != null) {
            joueur = extras.getString("joueur");
            score1 = extras.getString("score1");
            score2 = extras.getString("score2");

        }else {
            joueur="1";
            score1 = "0";
            score2 = "0";
        }

        Intent intent = new Intent(DistrictActivity.this, MainActivity.class);
        intent.putExtra("score1", score1);
        intent.putExtra("joueur", joueur);
        intent.putExtra("score2", score2);

        Button accueil = findViewById(R.id.buttonAccueil);

        accueil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        List<District> image_details = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new CustomGridAdapter(this, image_details));

        // When the user clicks on the GridItem
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                System.out.println(position);
                Intent intent = new Intent(DistrictActivity.this, QuizActivity.class);
                intent.putExtra("noQ", String.valueOf(position));
                intent.putExtra("joueur", String.valueOf(joueur));
                intent.putExtra("score1", String.valueOf(score1));
                intent.putExtra("score2", String.valueOf(score2));

                startActivity(intent);
            }
        });
    }

    private  List<District> getListData() {
        List<District> list = new ArrayList<District>();
        District district1 = new District(0, R.drawable.img_district1, "Le Louvre", "Le Louvre", 1, 1);
        District district2 = new District(1, R.drawable.img_district16, "Tour Eiffel", "Tour Eiffel", 1, 1);
        District district3 = new District(2, R.drawable.img_district4, "Hôtel de ville", "Hôtel de ville", 1, 1);

        list.add(district1);
        list.add(district2);
        list.add(district3);

        return list;
    }
}