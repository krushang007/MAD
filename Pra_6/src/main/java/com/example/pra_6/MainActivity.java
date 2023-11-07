package com.example.pra_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        recyclerView = findViewById(R.id.recycler_view);

        List<Student> studentList = new ArrayList<>();
        // Add student data to the list
        studentList.add(new Student("Shakti Patel", "210420107501", R.drawable.pra6_1));
        studentList.add(new Student("Laxmi Verma", "210420107502", R.drawable.pra6_2));
        studentList.add(new Student("Saraswati Sharma", "210420107501", R.drawable.pra6_3));

        studentAdapter = new StudentAdapter(studentList, this);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
