package com.example.assignmenthub;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class BasicCalculatorActivity extends AppCompatActivity {

    private EditText inputA;
    private EditText inputB;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calculator);

        inputA = findViewById(R.id.editFirst);
        inputB = findViewById(R.id.editSecond);
        resultView = findViewById(R.id.txtResult);

        Button add = findViewById(R.id.btnAdd);
        Button sub = findViewById(R.id.btnSub);
        Button mul = findViewById(R.id.btnMul);
        Button div = findViewById(R.id.btnDiv);

        add.setOnClickListener(v -> calculate('+'));
        sub.setOnClickListener(v -> calculate('-'));
        mul.setOnClickListener(v -> calculate('*'));
        div.setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char operator) {
        String aText = inputA.getText().toString().trim();
        String bText = inputB.getText().toString().trim();

        if (aText.isEmpty() || bText.isEmpty()) {
            resultView.setText("Enter both values");
            return;
        }

        double a = Double.parseDouble(aText);
        double b = Double.parseDouble(bText);
        double answer;

        if (operator == '+') {
            answer = a + b;
        } else if (operator == '-') {
            answer = a - b;
        } else if (operator == '*') {
            answer = a * b;
        } else {
            if (b == 0) {
                resultView.setText("Division by zero is not allowed");
                return;
            }
            answer = a / b;
        }

        String formatted = String.format(Locale.US, "Result: %.2f", answer);
        resultView.setText(formatted);
    }
}
