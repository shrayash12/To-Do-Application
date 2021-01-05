package com.example.todoapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText nameOf_Task;
    EditText addDiscription;
    CalendarView selectDate;
    ToDoListViewModel toDoListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toDoListViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ToDoListViewModel.class);

        nameOf_Task = findViewById(R.id.nameOf_Task);
        addDiscription = findViewById(R.id.add_Discription);
        selectDate = findViewById(R.id.select_Date);
        Button save_btn = findViewById(R.id.save_btn);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToDoList toDoList = new ToDoList();
                toDoList.setName(nameOf_Task.getText().toString());
                toDoList.setDiscription(addDiscription.getText().toString());
                toDoList.setDate_created(""+selectDate.getDate());
                toDoListViewModel.insert(toDoList);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }
}
