package com.example.p5;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import java.util.ArrayList; // Import ArrayList

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username = findViewById(R.id.user);
        EditText password = findViewById(R.id.pass);
        Button submit = findViewById(R.id.button);
        CheckBox checkBox1 = findViewById(R.id.checkBox);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        CheckBox checkBox3 = findViewById(R.id.checkBox3);
        Switch student = findViewById(R.id.switch1);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup radioGroup = findViewById(R.id.radio_group);
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String gender = selectedRadioButton.getText().toString();

                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("username", username.getText().toString());
                    intent.putExtra("password", password.getText().toString());
                    intent.putExtra("gender", gender);
                    intent.putExtra("student", student.getText().toString());

                    // Create an ArrayList to store selected checkbox items
                    ArrayList<String> selectedItems = new ArrayList<>();

                    // Check each checkbox and add its label to the list if it's selected
                    if (checkBox1.isChecked()) {
                        selectedItems.add(checkBox1.getText().toString());
                    }

                    if (checkBox2.isChecked()) {
                        selectedItems.add(checkBox2.getText().toString());
                    }

                    if (checkBox3.isChecked()) {
                        selectedItems.add(checkBox3.getText().toString());
                    }

                    // Put the selected items list as an extra intent
                    intent.putStringArrayListExtra("selected_items", selectedItems);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Please select your gender!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
