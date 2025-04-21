package com.example.slip_q2_26_27_context_menu;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // Create an ArrayAdapter to populate ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        // Register ListView for ContextMenu
        registerForContextMenu(listView);
    }

    // Create the ContextMenu when an item is long pressed
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // Add menu items
        menu.setHeaderTitle("Select an action");
        menu.add(0, 1, 0, "Edit Item");
        menu.add(0, 2, 1, "Delete Item");
    }

    // Handle menu item clicks
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String selectedItem = items[info.position]; // Get the item that was long pressed

        switch (item.getItemId()) {
            case 1:
                Toast.makeText(this, "Edit: " + selectedItem, Toast.LENGTH_SHORT).show();
                return true;
            case 2:
                Toast.makeText(this, "Delete: " + selectedItem, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
