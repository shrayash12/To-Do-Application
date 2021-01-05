package com.example.todoapplication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Database(entities  = {ToDoList.class}, version = 1, exportSchema = false)
public abstract class ToDoListRoomDataBase extends RoomDatabase {
    private static ToDoListRoomDataBase toDoListRoomDataBase;
    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    static ToDoListRoomDataBase getDatabase(final Context context) {
        if (toDoListRoomDataBase == null) {
            synchronized (ToDoListRoomDataBase.class) {
                if (toDoListRoomDataBase == null) {
                    toDoListRoomDataBase = Room.databaseBuilder(context.getApplicationContext(),
                            ToDoListRoomDataBase.class, "todo_database")
                            .build();
                }
            }
        }
        return toDoListRoomDataBase;
    }

    public abstract ToDoListdao toDoListdao();
}

