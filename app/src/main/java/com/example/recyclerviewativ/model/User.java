package com.example.recyclerviewativ.model;

import java.util.ArrayList;
import java.util.List;

public class User {
  private String id;
  private String name;

  private List<User> users;

  public User() {
    users = new ArrayList<>();
  }

  public User(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<User> getUsers() {
    return users;
  }

  public void addUser(User user){
    users.add(user);
  }
}
