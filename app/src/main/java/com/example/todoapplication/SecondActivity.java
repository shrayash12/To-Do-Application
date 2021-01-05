package com.example.todoapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    ToDoListViewModel toDoListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        toDoListViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ToDoListViewModel.class);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final ToDoListAdapter toDoListAdapter = new ToDoListAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(SecondActivity.this));
        recyclerView.setAdapter(toDoListAdapter);

        toDoListViewModel.allToDoList.observe(this, new Observer<List<ToDoList>>() {
            @Override
            public void onChanged(List<ToDoList> toDoLists) {
                toDoListAdapter.setItem(toDoLists);
            }
        });
    }
}
