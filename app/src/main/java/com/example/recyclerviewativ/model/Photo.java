package com.example.recyclerviewativ.model;

import java.util.ArrayList;
import java.util.List;

public class Photo {
  private String id;
  private String title;

  private List<Photo> photos;

  public Photo() {
    photos = new ArrayList<>();
  }

  public Photo(String id, String title) {
    this.id = id;
    this.title = title;
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public List<Photo> getPhotos() {
    return photos;
  }

  public void addPhoto(Photo photo){
    photos.add(photo);
  }
}
