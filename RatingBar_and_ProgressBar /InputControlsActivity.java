package com.example.mad1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class InputControlsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_controls);

        CheckBox cb1 = findViewById(R.id.cb1);
        CheckBox cb2 = findViewById(R.id.cb2);
        RadioGroup rg = findViewById(R.id.rg);
        RatingBar rb = findViewById(R.id.ratingBar);
        Button btn = findViewById(R.id.btn_submit_controls);

        btn.setOnClickListener(v -> {
            StringBuilder sb = new StringBuilder();
            if (cb1.isChecked()) sb.append("Android ");
            if (cb2.isChecked()) sb.append("Java ");
            int selectedId = rg.getCheckedRadioButtonId();
            if (selectedId == R.id.rb1) sb.append("Male ");
            else if (selectedId == R.id.rb2) sb.append("Female ");
            sb.append("Rating: ").append(rb.getRating());

            Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
        });
    }
}
