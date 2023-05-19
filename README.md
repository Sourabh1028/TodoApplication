# TodoApplication

<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.0.6-brightgreen.svg" />
</a>

This is a simple TODO application developed using Spring Boot framework, which allows users to manage their tasks in a convenient manner. The application uses an ArrayList as the data structure to store the tasks.


---

## Framework Used
* Spring Boot

---

## Language Used
* Java

---

## Data Model

The user data model is defined in the User class, which has the following attributes:
```
todoName : String
todoStatus : Boolean

```

## Data Flow

1. The user sends a request to the application through the API endpoints.
2. The API receives the request and sends it to the appropriate controller method.
3. The controller method makes a call to the method in service class.
4. The method in service class builds logic and retrieves or modifies data from the database, which is in turn given to controller class
5. The controller method returns a response to the API.
6. The API sends the response back to the user.

---


## Functions used :-

### API Endpoints :-
</br>


* PostMapping: /addTodo
```
This endpoint makes a call to method in ToDoService class which is connected to database. In database we add a new todo given through API.
```

* GetMapping: /getAllTodos
```
This endpoint makes a call to method in ToDoService class which retrieves data of all Todos from database. This data is sent to controller which is then sent through the API to client.
```

* GetMapping: /getTodosByStatus
```
This endpoint makes a call to method in ToDoService class which retrieves data of all Todos basec on status from database. This data is sent to controller which is then sent through the API to client.
```

* RequestMapping: "/getTodoById/{id}"
```
This endpoint returns data of specific ToDo based on ToDoId through API
```

* PutMapping "/updateTodoById/{id}/{status}"
```
This endpoint makes a call to method in ToDoService class which is connected to database. In database we update a ToDo by ToDoid given through API.
```

* DeleteMapping "/deleteTodoById/{id}"
```
This endpoint makes a call to method in ToDoService class which is connected to database. In database we delete a ToDo by ToDoid given through API.
```

---

## Data structure Used
* ArrayList
```
We have used ArrayList data structure as a database to implement CRUD Operations 
```
---

## Project Summary
The Spring Boot TODO Application is a simple task management system that allows users to add, view, mark as complete, 
and delete tasks. It utilizes the Spring Boot framework, with an ArrayList serving as the underlying data structure to store the tasks.
