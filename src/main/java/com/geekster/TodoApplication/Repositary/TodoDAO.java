package com.geekster.TodoApplication.Repositary;

import com.geekster.TodoApplication.Modles.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoDAO {

    private List<Todo> todoList;

    public TodoDAO(){
        todoList = new ArrayList<>();
        todoList.add(new Todo("0", "Dummy todo for testing", true));
    }
    public List<Todo> getTodosFromDataSource(){

        return todoList;
    }

    public boolean save(Todo todo){
        todoList.add(todo);
        return true;
    }
    public boolean remove(Todo todo){
        todoList.remove(todo);
        return true;
    }
    public boolean update(String id, boolean status){
        boolean updateStatus=false;
        for(Todo todo : todoList){
            if(todo.getId().equals(id)){
                //UPDATE LOGIC-
                remove(todo);        //remove original

                todo.setTodoStatus(status);   //change this todo with new

                save(todo);     //add this new todo

                return true;
            }
        }
        return false;
    }
}
