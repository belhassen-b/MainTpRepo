package com.example.tp_android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.tp_android.model.Task;

import java.util.ArrayList;

public class TodoActivity extends AppCompatActivity {
    private Button btnAdd;
    private TextView textViewTask;
    private TextView editTextTask;
    private ArrayList<Task> tasks;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        btnAdd = findViewById(R.id.btnAdd);
        textViewTask = findViewById(R.id.textViewTask);
        editTextTask = findViewById(R.id.editTextTask);
        textViewTask.setPaintFlags(textViewTask.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        tasks = (ArrayList<Task>) getIntent().getSerializableExtra("tasks");
        if (tasks == null) {
            tasks = new ArrayList<>();
        }

        updateTaskListTextView();

        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(TodoActivity.this, TodoActivity2.class);
            intent.putExtra("tasks", tasks);
            startActivity(intent);
        });

        textViewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TodoActivity.this, TodoActivity.class);
                tasks.remove(tasks.size() - 1);
                intent.putExtra("tasks", tasks);
                startActivity(intent);
            }
        });
    }

    private void updateTaskListTextView() {
        textViewTask.setText("");

        for (Task task : tasks) {
            textViewTask.append(task.getTitle() + "\n");
        }
    }
}
