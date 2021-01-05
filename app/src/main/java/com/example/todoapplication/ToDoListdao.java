package com.example.todoapplication;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public  interface ToDoListdao {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ToDoList toDoList);

    @Query("DELETE FROM ToDoList_Table")
    void deleteAll();

    @Query("SELECT * FROM ToDoList_Table ORDER BY toDoList ASC")
    LiveData<List<ToDoList>> getAlphabetizedWords();
}
