package com.Np2.bwcombiroutes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class MainActivity extends AppCompatActivity {

    private Spinner routesSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SearchView routesSearchView = findViewById(R.id.routesSearchView);
        routesSpinner = findViewById(R.id.routesSpinner);
        final SubsamplingScaleImageView routesImageZoomView = findViewById(R.id.routesImageZoomView);


        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.routes, android.R.layout.simple_spinner_dropdown_item);

        routesSpinner.setAdapter(adapter);

        routesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                switch (item) {

                    case "Tlokweng Route 1":
                        routesImageZoomView.setImage(ImageSource.resource(R.drawable.tlk_r1));
                        break;

                    case "Tlokweng Route 2":
                        routesImageZoomView.setImage(ImageSource.resource(R.drawable.tlk_r2));
                        break;

                    case "Block 8 Route 4":
                        routesImageZoomView.setImage(ImageSource.resource(R.drawable.blk8_r4));
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
