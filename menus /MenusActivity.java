package com.example.appdemo;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MenusActivity extends AppCompatActivity {

    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);

        status = findViewById(R.id.txtMenuStatus);
        Button popupButton = findViewById(R.id.btnPopup);
        TextView contextTarget = findViewById(R.id.txtContextTarget);

        registerForContextMenu(contextTarget);

        popupButton.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(this, v);
            popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(item -> handleMenuAction("Popup", item.getTitle().toString()));
            popupMenu.show();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return handleMenuAction("Options", item.getTitle().toString()) || super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return handleMenuAction("Context", item.getTitle().toString()) || super.onContextItemSelected(item);
    }

    private boolean handleMenuAction(String source, String title) {
        String message = source + " Menu -> " + title;
        status.setText(message);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        return true;
    }
}
