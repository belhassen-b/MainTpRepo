package com.example.tp_android;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.tp_android.model.Task;

import java.util.ArrayList;

public class TodoActivity2 extends AppCompatActivity {
    private Button btnSave;
    private EditText editTextTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo2);

        btnSave = findViewById(R.id.btnSave);
        editTextTask = findViewById(R.id.editTextTask);
        ArrayList<Task> tasks = (ArrayList<Task>) getIntent().getSerializableExtra("tasks");

        btnSave.setOnClickListener(v -> {
            if (editTextTask.getText().toString().isEmpty()) {
                Toast.makeText(this, "Merci de saisir une tâche", Toast.LENGTH_SHORT).show();
            } else {
                Task task = new Task(editTextTask.getText().toString());
                tasks.add(task);
                Intent intent = new Intent(TodoActivity2.this, TodoActivity.class);
                intent.putExtra("tasks", tasks);
                startActivity(intent);
            }
        });
    }
}



