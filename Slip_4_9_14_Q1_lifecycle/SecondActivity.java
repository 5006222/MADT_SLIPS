package com.example.slip_4_9;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secind);
        showToast("onCreate");
    }

    @Override protected void onStart() {
        super.onStart(); showToast("onStart");
    }
    @Override protected void onResume() {
        super.onResume();
        showToast("onResume");
    }
    @Override protected void onPause() {
        super.onPause(); showToast("onPause");
    }
    @Override protected void onStop() {
        super.onStop(); showToast("onStop"); }
    @Override protected void onRestart() {
        super.onRestart(); showToast("onRestart");
    }
    @Override protected void onDestroy() {
        super.onDestroy(); showToast("onDestroy");
    }

    private void showToast(String methodName) {
        Toast.makeText(this, TAG + " - " + methodName, Toast.LENGTH_SHORT).show();
        Log.d(TAG, methodName + " called");
    }
}
