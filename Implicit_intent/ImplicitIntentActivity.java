package com.example.appdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class ImplicitIntentActivity extends AppCompatActivity {

    private ImageView preview;

    private final ActivityResultLauncher<Intent> cameraLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getData() != null && result.getData().getExtras() != null) {
                    Bitmap photo = (Bitmap) result.getData().getExtras().get("data");
                    preview.setImageBitmap(photo);
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        Button btnWeb = findViewById(R.id.btnWeb);
        Button btnDial = findViewById(R.id.btnDial);
        Button btnMaps = findViewById(R.id.btnMap);
        Button btnCamera = findViewById(R.id.btnCamera);
        preview = findViewById(R.id.imgPreview);

        btnWeb.setOnClickListener(
                v -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com"))));
        btnDial.setOnClickListener(v -> startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9876543210"))));
        btnMaps.setOnClickListener(
                v -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:18.5204,73.8567?q=Pune"))));
        btnCamera.setOnClickListener(v -> cameraLauncher.launch(new Intent(MediaStore.ACTION_IMAGE_CAPTURE)));
    }
}
