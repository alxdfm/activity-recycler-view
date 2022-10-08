package com.example.recyclerviewativ.model;

import java.util.ArrayList;
import java.util.List;

public class Todo {
  private String id;
  private String title;

  private List<Todo> todos;

  public Todo() {
    todos = new ArrayList<>();
  }

  public Todo(String id, String title) {
    this.id = id;
    this.title = title;
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public List<Todo> getTodos() {
    return todos;
  }

  public void addTodo(Todo todo){
    todos.add(todo);
  }
}
