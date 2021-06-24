package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

        List<District> image_details = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new CustomGridAdapter(this, image_details));

        // When the user clicks on the GridItem
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = gridView.getItemAtPosition(position);
                District district = (District) o;
                Toast.makeText(DistrictActivity.this, "Selected :"
                        + " " + district, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private  List<District> getListData() {
        List<District> list = new ArrayList<District>();
        District district1 = new District(0, R.drawable.img_district1, "Louvre", "Le Louvre", 1, 1);
        District district2 = new District(1, R.drawable.img_district2, "Bourse", "Bourse", 1, 1);
        District district3 = new District(2, R.drawable.img_district3, "Temple", "Temple", 1, 1);

        list.add(district1);
        list.add(district2);
        list.add(district3);

        return list;
    }
}