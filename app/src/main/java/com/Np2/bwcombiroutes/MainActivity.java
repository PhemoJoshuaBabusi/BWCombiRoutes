package com.Np2.bwcombiroutes;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Spinner;

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
        routesSpinner  = findViewById(R.id.routesSpinner);

        routesSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        routesImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
