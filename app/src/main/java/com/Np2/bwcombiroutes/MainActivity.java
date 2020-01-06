package com.Np2.bwcombiroutes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Spinner;

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
                                (R.drawable.tlk_r1));
                        break;

                    case "Tlokweng Route 2":
                        ((ImageView) findViewById(R.id.routesImageView)).setImageResource(
                                (R.drawable.tlk_r2));
                        break;

                    case "Block 8 Route 4":
                        ((ImageView) findViewById(R.id.routesImageView)).setImageResource(
                                (R.drawable.blk8_r4));
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
