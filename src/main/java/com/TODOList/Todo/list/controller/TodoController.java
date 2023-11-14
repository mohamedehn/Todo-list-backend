package com.TODOList.Todo.list.controller;

import com.TODOList.Todo.list.entity.Todo;
import com.TODOList.Todo.list.repository.TodoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

    //injection du repository par dépendance
    public final TodoRepository repository;
    public TodoController(TodoRepository injectedRepository){
        this.repository = injectedRepository;
    }

    //route pour récupérer les todolist
    @GetMapping("/todos")
    public List<Todo> getAllTodo(){
        List<Todo> todo = repository.findAll();
        if(!todo.isEmpty()){
            return todo;
        } else {
            throw new RuntimeException("There is no todo");
        }
    }

    //route pour récupérer un todo en fonction de son id
    @GetMapping("/todo/{id}")
    public Todo getTodo(@PathVariable int id){
        Optional<Todo> todo = repository.findById(id);
        if (todo.isPresent()){
            return todo.get();
        }else {
            throw new RuntimeException("This todo number " +id+  " doesn't exist");
        }
    }

    //route pour ajouter un todo
    @PostMapping("/todo/add")
    public void createTodo(@RequestBody Todo todo){
        repository.save(todo);
    }

    //route pour supprimer un todo
    @DeleteMapping("/todo/{id}")
    public void deleteTodo(@PathVariable int id){
        Optional<Todo> todo = repository.findById(id);
        if (todo.isPresent()){
            repository.deleteById(id);
        }else {
            throw new RuntimeException("This todo number " +id+  " wasn't found");
        }
    }

    //route pour modifier un todo
    @PutMapping("todo/update/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody Todo todo){
        Optional<Todo> todoToUpdate = repository.findById(id);
        if (todoToUpdate.isPresent()){
            Todo todoUpdated = todoToUpdate.get();
            todoUpdated.setName(todo.getName());
            todoUpdated.setDescription(todo.getDescription());
            return repository.save(todoUpdated);
        }else {
            throw new RuntimeException("This todo number " +id+  " wasn't found");
        }
    }
}
