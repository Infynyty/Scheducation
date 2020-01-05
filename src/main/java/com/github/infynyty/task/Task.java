package com.github.infynyty.task;

import com.github.infynyty.Importance;
import com.github.infynyty.Subject;

import java.util.ArrayList;
import java.util.HashMap;

public class Task {

    private Subject subject;
    private Importance importance;
    private String name;

    private static ArrayList<Task> allTasks = new ArrayList<>();
    private static HashMap<String, Task> taskByName = new HashMap<>();

    public Task(Subject subject, Importance importance, String name) {
        this.subject = subject;
        this.importance = importance;
        this.name = name;
        allTasks.add(this);
        taskByName.put(this.name, this);
    }

    public static ArrayList<Task> getAllTasks() {
        return allTasks;
    }

    public static HashMap<String, Task> getTaskByName() {
        return taskByName;
    }
}
