package com.example.slip15_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button showDialogBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialogBtn = findViewById(R.id.btnShowDialog);

        showDialogBtn.setOnClickListener(view -> showCustomDialog());
    }

    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.custom_alert_dialog, null);
        builder.setView(dialogView);

        AlertDialog alertDialog = builder.create();

        Button btnFriend1 = dialogView.findViewById(R.id.btnFriend1);
        Button btnFriend2 = dialogView.findViewById(R.id.btnFriend2);
        Button btnFriend3 = dialogView.findViewById(R.id.btnFriend3);

        btnFriend1.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Hello, Alice! 😊", Toast.LENGTH_SHORT).show();
            alertDialog.dismiss();
        });

        btnFriend2.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Hey Bob! 👋", Toast.LENGTH_SHORT).show();
            alertDialog.dismiss();
        });

        btnFriend3.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Hi Charlie! ✨", Toast.LENGTH_SHORT).show();
            alertDialog.dismiss();
        });

        alertDialog.show();
    }
}
