package com.greencoder.TodoItemAPI.controller;

import com.greencoder.TodoItemAPI.domain.TodoItem;
import com.greencoder.TodoItemAPI.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/api/todoItems")
    public ResponseEntity<?> getItems(){
        List<TodoItem> items = todoService.findAllItems();
        return ResponseEntity.ok(items);
    }


    @PostMapping("/api/todoItems")
    public  ResponseEntity<?> createItem(@RequestBody TodoItem todoItem){
       TodoItem createdItem =todoService.createItem(todoItem);
       return ResponseEntity.ok(createdItem);
    }

    @PutMapping("/api/todoItems{id}")
    public ResponseEntity<?> updateItems(@PathVariable Integer id, @RequestBody TodoItem todoItem){
        TodoItem updatedItem = todoService.updateItems(id, todoItem);

        return ResponseEntity.ok(updatedItem);

    }

    @DeleteMapping("/api/todoItems{id}")
    public ResponseEntity<?> deleteItems(@PathVariable Integer id){
        todoService.deleteItem(id);
        return ResponseEntity.ok("Task deleted");
    }


}
