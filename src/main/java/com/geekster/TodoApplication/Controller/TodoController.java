package com.geekster.TodoApplication.Controller;

import com.geekster.TodoApplication.Modles.Todo;
import com.geekster.TodoApplication.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping(value = "/getAllTodos")
    public List<Todo> getAllTodos(){

        return todoService.getAllTodos();
    }
    //Extra work based on status
    @GetMapping(value = "/getTodosByStatus")
    public List<Todo> getTodosByStatus(@RequestParam String status){
        return todoService.getTodosByUserStatus(status);
    }

    @PostMapping(value = "/addTodo")
    public String addTodo(@RequestBody Todo todo){

        return todoService.addMyTodo(todo);
    }

    @RequestMapping(value = "/getTodoById/{id}", method = RequestMethod.GET)
    public Todo getTodoBtId(@PathVariable String id){

        return todoService.getTodoBasedOnId(id);
    }

    @DeleteMapping(value = "/deleteTodoById/{id}")
    public String deleteTodoById(@PathVariable String id){
        return todoService.removeTodoById(id);
    }
    //put=update
    @PutMapping(value = "/updateTodoById/{id}/{status}")
    public String updateTodoStatusById(@PathVariable String id, @PathVariable String status){
        return todoService.updateTodoStatusById(id, status);
    }


}
