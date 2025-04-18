package com.example.slip_10_30_q1;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    TextView txtRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RatingBar and TextView
        ratingBar = findViewById(R.id.ratingBar);
        txtRating = findViewById(R.id.txtRating);

        // Set listener for RatingBar
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            // Display the number of stars selected on TextView
            txtRating.setText("Rating: " + rating);

            // Display the number of stars selected in a Toast message
            Toast.makeText(MainActivity.this, "You rated: " + rating + " stars", Toast.LENGTH_SHORT).show();
        });
    }
}
