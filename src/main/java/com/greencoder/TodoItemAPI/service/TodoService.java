package com.greencoder.TodoItemAPI.service;

import com.greencoder.TodoItemAPI.domain.TodoItem;
import com.greencoder.TodoItemAPI.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;
    private Integer id;
    private TodoItem todoItem;
    private Predicate<TodoItem> todoItemPredicate;

    public List<TodoItem> findAllItems(){
        return todoRepository.findAll();

    }

    public TodoItem createItem(TodoItem todoItem) {
      return  todoRepository.save(todoItem);
    }

    public List<TodoItem> findByTask(String task) {
       return (List<TodoItem>) todoRepository.findByTask(task);
    }


    public TodoItem updateItems(Integer id, TodoItem todoItem) {
        Optional<TodoItem> todoItemOptional = todoRepository.findAll()
                .stream()
                .filter(todoItemPredicate)
                .findAny();
        if (todoItemOptional.isPresent()){
            TodoItem item = todoItemOptional.get();
            item.setDone(todoItem.getDone());
            item.setTask(todoItem.getTask());
            return item;
        }
        return null;

    }

    public void deleteItem(Integer id) {
        todoRepository.deleteById(id);
    }
}
