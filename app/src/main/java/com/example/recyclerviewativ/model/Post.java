package com.example.recyclerviewativ.model;

import java.util.ArrayList;
import java.util.List;

public class Post {
  private String id;
  private String title;

  private List<Post> posts;

  public Post() {
    posts = new ArrayList<>();
  }

  public Post(String id, String title) {
    this.id = id;
    this.title = title;
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public List<Post> getPosts() {
    return posts;
  }

  public void addPost(Post post){
    posts.add(post);
  }
}
