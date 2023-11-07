package com.example.pra_7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

public class TyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tyactivity); // Replace with your layout file for TyActivity

        Button coButton = findViewById(R.id.co);

        // Create a popup menu
        PopupMenu popupMenu = new PopupMenu(this, coButton);

        // Inflate the menu resource file
        popupMenu.getMenuInflater().inflate(R.menu.pop_menu, popupMenu.getMenu());

        // Set an on click listener for the button
        coButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the popup menu
                popupMenu.show();
            }
        });
    }
}
