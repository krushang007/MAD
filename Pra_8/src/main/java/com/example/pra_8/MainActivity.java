package com.example.pra_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.pra_8.Data.MyDbHandler;
import com.example.pra_8.Model.Student;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> students;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDbHandler db = new MyDbHandler(MainActivity.this);

        recyclerView = findViewById(R.id.RecyclerView);
        students = new ArrayList<>();

        // Set the layout manager for the RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Get all student records from the database
        List<Student> getAllStudents = db.getAllStudents();

        for (Student student : getAllStudents) {
            Log.d("DBMITESH", "ID : " + student.getId() + "\n" +
                    "Name : " + student.getName() + "\n" +
                    "SPI : " + student.getSpi() + "\n" +
                    "CPI : " + student.getCpi());

            students.add(student.getName() + " (SPI: " + student.getSpi() + ") (CPI: " + student.getCpi() + ")");
        }

        // Replace the previous ArrayAdapter with the custom adapter
        StudentAdapter studentAdapter = new StudentAdapter(this, students);
        recyclerView.setAdapter(studentAdapter);


        // Other database operations can be added here, such as adding, updating, or deleting students
    }
}
