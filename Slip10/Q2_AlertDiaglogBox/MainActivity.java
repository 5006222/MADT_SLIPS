package com.example.slip10_2;


import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button showDialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialogButton = findViewById(R.id.button);

        showDialogButton.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Alert");
            builder.setMessage("Do you want to close this app?");
            builder.setCancelable(false);

            builder.setPositiveButton("OK", (dialog, which) -> {

                finish();
            });

              builder.setNegativeButton("Cancel", (dialog, which) -> {
                dialog.dismiss(); // dismisses dialog
            });


            builder.show();
        });
    }
}
