package com.example.studentutilityapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button btnApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnApi = findViewById(R.id.btnApi);

        btnApi.setOnClickListener(v ->
                startActivity(new Intent(this, ApiActivity.class))
        );
    }
}
