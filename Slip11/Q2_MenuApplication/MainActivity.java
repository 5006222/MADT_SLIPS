package com.example.slip_11_q2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button popupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        popupButton = findViewById(R.id.popupButton);

        // Register context menu for the TextView
        registerForContextMenu(textView);

        // Set popup menu on button
        popupButton.setOnClickListener(view -> {
            PopupMenu popup = new PopupMenu(MainActivity.this, popupButton);
            popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

            popup.setOnMenuItemClickListener(item -> {
                int id = item.getItemId();
                if (id == R.id.popup_option1) {
                    Toast.makeText(MainActivity.this, "Popup Option 1 selected", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (id == R.id.popup_option2) {
                    Toast.makeText(MainActivity.this, "Popup Option 2 selected", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            });

            popup.show();
        });
    }

    // Options Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.option1) {
            Toast.makeText(this, "Option 1 selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.option2) {
            Toast.makeText(this, "Option 2 selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.textView) {
            getMenuInflater().inflate(R.menu.context_menu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.context_option1) {
            Toast.makeText(this, "Context Option 1 selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.context_option2) {
            Toast.makeText(this, "Context Option 2 selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onContextItemSelected(item);
    }
}
