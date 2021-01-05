package com.example.todoapplication;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ToDoListRepository {
    public   ToDoListdao toDoListdao;

    ToDoListRepository(Application application) {
        ToDoListRoomDataBase db = ToDoListRoomDataBase.getDatabase(application);
        toDoListdao = db.toDoListdao();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<ToDoList>> getAllHistories() {
        return toDoListdao.getAlphabetizedWords();
    }

    void insert(final ToDoList toDoList) {
        ToDoListRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                toDoListdao.insert(toDoList);
            }
        });
    }

    public void delete() {
        ToDoListRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                toDoListdao.deleteAll();
            }
        });
    }
}