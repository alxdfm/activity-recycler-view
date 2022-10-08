package com.example.recyclerviewativ.model;

import java.util.ArrayList;
import java.util.List;

public class Comment {
  private String id;
  private String name;

  private List<Comment> comments;

  public Comment() {
    comments = new ArrayList<>();
  }

  public Comment(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void addComment(Comment comment){
    comments.add(comment);
  }
}
