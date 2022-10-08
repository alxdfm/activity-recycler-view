package com.example.recyclerviewativ.model;

import java.util.ArrayList;
import java.util.List;

public class Album {

  private String id;
  private String title;

  private List<Album> albums;

  public Album() {
    albums = new ArrayList<>();
  }

  public Album(String id, String title) {
    this.id = id;
    this.title = title;
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public List<Album> getAlbums() {
    return albums;
  }

  public void addAlbum(Album album){
    albums.add(album);
  }
}
