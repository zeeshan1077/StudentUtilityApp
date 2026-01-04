package com.example.studentutilityapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = etUsername.getText().toString();
                String pass = etPassword.getText().toString();

                if(user.equals("admin") && pass.equals("1234")){
                    Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this,
                            "Invalid Login",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
