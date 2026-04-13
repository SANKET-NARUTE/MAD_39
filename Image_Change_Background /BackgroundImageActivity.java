package com.example.mad1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class BackgroundImageActivity extends AppCompatActivity {
    private boolean isFirstImage = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_image);

        final LinearLayout layout = findViewById(R.id.layout_image_bg);
        Button btn = findViewById(R.id.btn_change_image);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFirstImage) {
                    layout.setBackgroundResource(R.drawable.bg_image_2);
                } else {
                    layout.setBackgroundResource(R.drawable.bg_image_1);
                }
                isFirstImage = !isFirstImage;
            }
        });
    }
}
