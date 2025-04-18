package com.example.slip25_28_q1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnMergeArrays;
    TextView txtMergedArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMergeArrays = findViewById(R.id.btnMergeArrays);
        txtMergedArray = findViewById(R.id.txtMergedArray);

        btnMergeArrays.setOnClickListener(v -> {
            // Define the two arrays
            int[] array1 = {1, 2, 3, 4};
            int[] array2 = {5, 6, 7, 8};

            // Merge arrays
            int[] mergedArray = mergeArrays(array1, array2);

            // Convert to string and display
            StringBuilder result = new StringBuilder("Merged Array: ");
            for (int num : mergedArray) {
                result.append(num).append(" ");
            }

            txtMergedArray.setText(result.toString());
        });
    }

    // Function to merge two arrays
    private int[] mergeArrays(int[] array1, int[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;
        int[] result = new int[length1 + length2];

        // Copy first array
        System.arraycopy(array1, 0, result, 0, length1);
        // Copy second array
        System.arraycopy(array2, 0, result, length1, length2);

        return result;
    }
}
