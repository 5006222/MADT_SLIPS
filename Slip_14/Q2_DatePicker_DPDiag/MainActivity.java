package com.example.slip14_2;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    TextView tvDate;
    Button btnShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.datePicker);
        tvDate = findViewById(R.id.tvDate);
        btnShowDialog = findViewById(R.id.btnShowDialog);

        // Show selected date from the DatePicker
        datePicker.setOnDateChangedListener((view, year, monthOfYear, dayOfMonth) -> {
            tvDate.setText("Selected Date : " + dayOfMonth + " / " + (monthOfYear + 1) + " / " + year);
        });

        // Show DatePickerDialog
        btnShowDialog.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        tvDate.setText("Selected Date (Dialog) : " + selectedDay + " / " + (selectedMonth + 1) + " / " + selectedYear);
                    }, year, month, day);

            dialog.show();
        });
    }
}
