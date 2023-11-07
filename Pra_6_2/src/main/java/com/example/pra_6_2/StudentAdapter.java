package com.example.pra_6_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private List<Student> studentList;
    private Context context;

    public StudentAdapter(List<Student> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.studentName.setText(student.getName());
        holder.studentRoll.setText(student.getRollNumber());
        holder.studentPhoto.setImageResource(student.getPhoto());

        holder.cardView.setOnClickListener(v -> {
            Toast.makeText(context, student.getName(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView studentPhoto;
        TextView studentName;
        TextView studentRoll;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            studentPhoto = itemView.findViewById(R.id.student_photo);
            studentName = itemView.findViewById(R.id.student_name);
            studentRoll = itemView.findViewById(R.id.student_roll);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}
