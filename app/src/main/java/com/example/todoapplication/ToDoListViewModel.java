package com.example.todoapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ToDoListViewModel extends AndroidViewModel {

    public ToDoListRepository toDoListRepository;
    LiveData<List<ToDoList>> allToDoList;

    public ToDoListViewModel(@NonNull Application application) {
        super(application);
        toDoListRepository = new ToDoListRepository(application);
        allToDoList = toDoListRepository.getAllHistories();
    }

    LiveData<List<ToDoList>> getAllWords() {
        return allToDoList;
    }

    public void insert(ToDoList toDoList) {
        toDoListRepository.insert(toDoList);
    }

    public void delete() {
        toDoListRepository.delete();
    }
}

