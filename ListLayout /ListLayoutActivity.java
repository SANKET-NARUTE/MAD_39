package com.example.mad1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ListLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_layout);

        ListView listView = findViewById(R.id.listView);
        String[] items = {"Android", "Java", "Kotlin", "Python", "C++", "C#", "JavaScript", "Swift", "PHP"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, "Clicked: " + items[position], Toast.LENGTH_SHORT).show();
        });
    }
}
