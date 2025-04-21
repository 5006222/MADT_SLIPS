package com.example.slip_20_q2db_game;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    EditText etGname, etType, etNoOfPlayers;
    Button btnUpdate, btnDisplay, btnInsert;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);

        etGname = findViewById(R.id.etGname);
        etType = findViewById(R.id.etType);
        etNoOfPlayers = findViewById(R.id.etNoOfPlayers);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDisplay = findViewById(R.id.btnDisplay);
        btnInsert = findViewById(R.id.btnInsert);
        tvDisplay = findViewById(R.id.tvDisplay);

        // Insert new record
        btnInsert.setOnClickListener(v -> {
            String gname = etGname.getText().toString();
            String type = etType.getText().toString();
            int noOfPlayers = Integer.parseInt(etNoOfPlayers.getText().toString());

            dbHelper.insertGame(gname, type, noOfPlayers);
            Toast.makeText(MainActivity.this, "Game inserted!", Toast.LENGTH_SHORT).show();
            etGname.setText("");
            etType.setText("");
            etNoOfPlayers.setText("");
        });

        // Update players for "Badminton" to 4
        btnUpdate.setOnClickListener(v -> {
            dbHelper.updatePlayersForBadminton();
            Toast.makeText(MainActivity.this, "Updated no_of_players to 4 for Badminton", Toast.LENGTH_SHORT).show();
        });

        // Display all records
        btnDisplay.setOnClickListener(v -> {
            Cursor cursor = dbHelper.getAllGames();
            StringBuilder sb = new StringBuilder();
            while (cursor.moveToNext()) {
                int gno = cursor.getInt(cursor.getColumnIndex(DBHelper.COL_GNO));
                String gname = cursor.getString(cursor.getColumnIndex(DBHelper.COL_GNAME));
                String type = cursor.getString(cursor.getColumnIndex(DBHelper.COL_TYPE));
                int noOfPlayers = cursor.getInt(cursor.getColumnIndex(DBHelper.COL_NO_OF_PLAYERS));

                sb.append("Game No: ").append(gno).append("\n")
                        .append("Game Name: ").append(gname).append("\n")
                        .append("Type: ").append(type).append("\n")
                        .append("No of Players: ").append(noOfPlayers).append("\n\n");
            }
            tvDisplay.setText(sb.toString());
            cursor.close();
        });
    }
}
