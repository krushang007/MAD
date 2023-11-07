package com.example.pra_6_2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class StudentListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        recyclerView = findViewById(R.id.recycler_view);

        List<Student> studentList = new ArrayList<>();

        // Add student data
        studentList.add(new Student("Shakti Patel", "2021001", R.drawable.pra6_1));
        studentList.add(new Student("Laxmi Verma", "2021002", R.drawable.pra6_2));
        studentList.add(new Student("Sarawati Sharma", "2021003", R.drawable.pra6_3));
        // Add more students as needed

        studentAdapter = new StudentAdapter(studentList, this);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
