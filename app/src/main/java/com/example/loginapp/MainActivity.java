package com.example.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
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

        if (Locale.getDefault().getDisplayLanguage().equals("en")){

            text.setText("Welcome " + id + ", your password is " + pass);

        } else {
            text.setText("Bienvenue " + id + ", votre mot de passe est " + pass);
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
