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
import static com.Np2.bwcombiroutes.R.mipmap.tlokweng;

public class MainActivity extends AppCompatActivity {

    private Spinner routesSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SearchView routesSearchView = findViewById(R.id.routesSearchView);
        routesSpinner = findViewById(R.id.routesSpinner);


        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.routes, android.R.layout.simple_spinner_dropdown_item);

        routesSpinner.setAdapter(adapter);

        routesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                switch (item) {
                    case "Tlokweng Route 1":
                        ((ImageView) findViewById(R.id.routesImageView)).setImageResource(
                                (tlokweng));
                        break;

                    case "Tlokweng Route 2":
                        ((ImageView) findViewById(R.id.routesImageView)).setImageResource(
                                (R.mipmap.ic_launcher));
                        break;

                    case "Block 8 Route 4":
                        ((ImageView) findViewById(R.id.routesImageView)).setImageResource(
                                (ic_launcher_round));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        routesSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                routesSpinner.performClick();

                adapter.getFilter().filter(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });

    }}
