package com.example.tasklist.service;

import com.example.tasklist.domain.task.Task;
import com.example.tasklist.domain.task.TaskImage;

import java.util.List;

public interface TaskService {

    Task getById(Long id);

    List<Task> getAllByUserId(Long userId);

    Task update(Task task);

    Task create(Task task, Long id);

    void delete(Long id);

    void uploadImage(Long id, TaskImage taskImage);

}
