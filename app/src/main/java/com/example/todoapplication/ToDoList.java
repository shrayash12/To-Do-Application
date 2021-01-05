package com.example.todoapplication;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ToDoList_Table")

public class ToDoList {


    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "ToDoList")
    public String name;
    public String discription;
    public String date_created;

    public ToDoList(@NonNull String name, String discription, String date_created) {
        this.name = name;
        this.discription = discription;
        this.date_created = date_created;
    }

    public ToDoList(){

    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }
}


