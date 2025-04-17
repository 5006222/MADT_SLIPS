package com.example.slip2_2;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText nameField;
    private EditText emailField;
    private EditText passwordField;
    private Button  registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.editTextName);
        emailField = findViewById(R.id.editTextEmail);
        passwordField = findViewById(R.id.editTextPassword);
        registerButton = findViewById(R.id.buttonRegister);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRegistration();
            }
        });
    }
    private void handleRegistration()
    {
        String name=nameField.getText().toString().trim();
        String email= emailField.getText().toString().trim();
        String password=passwordField.getText().toString().trim();

        if(TextUtils.isEmpty(name)){
            Toast.makeText(this, "please enter the name", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "please enter the email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "please enter the password", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Toast.makeText(this,"plese enter the valid email", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "REGISTRAYION SUCESSFUl", Toast.LENGTH_SHORT).show();


    }

   }
