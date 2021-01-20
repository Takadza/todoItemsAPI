package com.greencoder.TodoItemAPI.repository;

import com.greencoder.TodoItemAPI.domain.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository  extends JpaRepository<TodoItem ,Integer> {

    TodoItem findByTask(String task);

}
