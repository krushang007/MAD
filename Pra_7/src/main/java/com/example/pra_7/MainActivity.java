package com.example.pra_7;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pra_7.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        MenuItem tyItem = menu.findItem(R.id.ty_item);

        tyItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean
            onMenuItemClick(MenuItem item) {
                // Create an intent to launch the TyActivity
                Intent intent = new Intent(MainActivity.this, TyActivity.class);

                // Start the TyActivity
                startActivity(intent);

                // Return true to indicate that the event has been handled
                return true;
            }
        });
        return true;
    }
}
