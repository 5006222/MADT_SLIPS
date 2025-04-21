package com.example.slip_q2_21_listview;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] games = {"Cricket", "Football", "Badminton", "Hockey", "Chess"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // Create Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                games
        );

        listView.setAdapter(adapter);

        // Item Click Listener
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedGame = games[position];
            Toast.makeText(MainActivity.this, "Selected: " + selectedGame, Toast.LENGTH_SHORT).show();
        });
    }
}
