package com.example.p5;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");
        String gen = intent.getStringExtra("gender");
        String student1 = intent.getStringExtra("student");

        // Retrieve the selected items list from the Intent
        ArrayList<String> selectedItems = getIntent().getStringArrayListExtra("selected_items");

        // Check if the list is not null
        if (selectedItems != null) {
            // Concatenate the selected hobby items
            StringBuilder hobbiesBuilder = new StringBuilder();
            for (String item : selectedItems) {
                hobbiesBuilder.append(item).append(", ");
            }

            // Remove the trailing ", " from the concatenated string
            String hobbies = hobbiesBuilder.toString();
            if (hobbies.endsWith(", ")) {
                hobbies = hobbies.substring(0, hobbies.length() - 2);
            }

            // Set the concatenated string in the TextView for hobbies
            TextView hobbyTextView = findViewById(R.id.hobby);
            hobbyTextView.setText(hobbies);
        }

        // Set username, password, and gender in their respective TextViews
        TextView user = findViewById(R.id.user);
        user.setText(username);

        TextView pass = findViewById(R.id.pass);
        pass.setText(password);

        TextView gender = findViewById(R.id.gender);
        gender.setText(gen);

        TextView student = findViewById(R.id.student);
        student.setText(student1);
    }
}
