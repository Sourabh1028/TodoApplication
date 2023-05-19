package com.geekster.TodoApplication.Service;

import com.geekster.TodoApplication.Modles.Todo;
import com.geekster.TodoApplication.Repositary.TodoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Service
public class TodoService {
    @Autowired
    TodoDAO todoDAO;

    public List<Todo> getAllTodos(){
        return todoDAO.getTodosFromDataSource();
    }
    public String addMyTodo(Todo todo){
        boolean insertionStatus = todoDAO.save(todo);
        if(insertionStatus){
            return "Todo added Successfully !!!";
        }
        else{
            return "Failed... to add !!!";
        }
    }
    public List<Todo> getTodosByUserStatus(String status){
        List<Todo> todoListRightNow = todoDAO.getTodosFromDataSource();

        List<Todo> todoListStatusBased = new ArrayList<>();
        for(Todo todo : todoListRightNow){

            if(todo.isTodoStatus() == Boolean.parseBoolean(status)){

                todoListStatusBased.add(todo);
            }
        }
        return todoListStatusBased;
    }
    public Todo getTodoBasedOnId(String id){

        List<Todo> todoListRightNow = todoDAO.getTodosFromDataSource();

        for(Todo todo : todoListRightNow){

            if(todo.getId().equals(id)){

                return todo;
            }
        }
        return null;
    }

    public String removeTodoById(String id){

        boolean deleteReponse = false;
        String status;
        if(id !=null){
            List<Todo> todoListRightNow = todoDAO.getTodosFromDataSource();

            for(Todo todo : todoListRightNow){

                if(todo.getId().equals(id)){

                    deleteReponse=todoDAO.remove(todo);
                    if(deleteReponse){
                        status = "todo with "+id+" was deleted !!!";
                    }
                    else{
                        status = "todo with "+id+"deletion was not possible !!!";
                    }
                    return status;
                }
            }
            return "todo with "+id+" does not exist !!!";
        }
        else{
            return "Invalid id cannot accept null id !!!";
        }
    }
    public String updateTodoStatusById(String id, String status){

        boolean updateStatus = todoDAO.update(id,Boolean.parseBoolean(status));
        if(updateStatus){
            return "todo with "+id+" was updated !!!";
        }
        else{
            return "todo with "+id+" does not exist !!!";
        }
    }
}
