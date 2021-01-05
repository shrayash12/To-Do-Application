package com.example.todoapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ToDoListViewHolder> {

    List<ToDoList> list = new ArrayList<>();

    @NonNull
    @Override
    public ToDoListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.todolist_layout_data,parent,false);
        return new ToDoListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoListViewHolder holder, int position) {
        holder.nameOfTask.setText(list.get(position).name);
        holder.discriptionOfTask.setText(list.get(position).discription);
        holder.dt.setText(list.get(position).getDate_created());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ToDoListViewHolder extends RecyclerView.ViewHolder {
        TextView nameOfTask;
        TextView discriptionOfTask;
        TextView dt;
        public ToDoListViewHolder(@NonNull View itemView) {
            super(itemView);
            nameOfTask = itemView.findViewById(R.id.nameOfTask);
            discriptionOfTask = itemView.findViewById(R.id.discriptionOfTask);
            dt = itemView.findViewById(R.id.dt);
        }
    }

    public  void setItem(List<ToDoList> lists) {
        list.addAll(lists);
        notifyDataSetChanged();
    }
}
