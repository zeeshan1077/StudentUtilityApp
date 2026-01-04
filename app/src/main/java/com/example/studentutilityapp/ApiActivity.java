package com.example.studentutilityapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import org.json.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class ApiActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        listView = findViewById(R.id.listView);

        new Thread(() -> {
            try {
                URL url = new URL("https://jsonplaceholder.typicode.com/posts");
                HttpURLConnection con =
                        (HttpURLConnection) url.openConnection();

                BufferedReader br =
                        new BufferedReader(new InputStreamReader(con.getInputStream()));

                StringBuilder sb = new StringBuilder();
                String line;
                while((line = br.readLine()) != null){
                    sb.append(line);
                }

                JSONArray arr = new JSONArray(sb.toString());
                for(int i=0;i<10;i++){
                    list.add(arr.getJSONObject(i).getString("title"));
                }

                runOnUiThread(() -> {
                    ArrayAdapter<String> adapter =
                            new ArrayAdapter<>(this,
                                    android.R.layout.simple_list_item_1, list);
                    listView.setAdapter(adapter);
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
