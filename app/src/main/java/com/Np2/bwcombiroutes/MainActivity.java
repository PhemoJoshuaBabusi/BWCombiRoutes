package com.Np2.bwcombiroutes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Spinner;

import static com.Np2.bwcombiroutes.R.mipmap.ic_launcher_round;

public class MainActivity extends AppCompatActivity {

    private SearchView routesSearchView;
    private ImageView routesImageView;
    private Spinner routesSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        routesSearchView = findViewById(R.id.routesSearchView);
        routesImageView = findViewById(R.id.routesImageView);
        routesSpinner = findViewById(R.id.routesSpinner);



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.routes, android.R.layout.simple_spinner_dropdown_item);

        routesSpinner.setAdapter(adapter);

        new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                switch (item) {
                    case "Tlokweng Route 1":
                        ((ImageView) findViewById(R.id.routesImageView)).setImageResource(
                                    (ic_launcher_round));

                    case "Tlokweng Route 2":
                        ((ImageView) findViewById(R.id.routesImageView)).setImageResource(
                                (R.mipmap.ic_launcher));
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        };


    }
}
