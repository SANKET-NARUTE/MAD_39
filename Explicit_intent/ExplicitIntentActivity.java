package com.example.assignmenthub;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExplicitIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);

        EditText username = findViewById(R.id.editUser);
        EditText password = findViewById(R.id.editPass);
        TextView status = findViewById(R.id.txtStatus);
        Button login = findViewById(R.id.btnLogin);

        login.setOnClickListener(v -> {
            String userValue = username.getText().toString().trim();
            String passValue = password.getText().toString().trim();

            if ("student".equalsIgnoreCase(userValue) && "mad123".equals(passValue)) {
                status.setText("Login successful. Opening profile screen.");
                startActivity(new Intent(this, OnePageProfileActivity.class));
            } else {
                status.setText("Invalid credentials. Try student / mad123");
            }
        });
    }
}
