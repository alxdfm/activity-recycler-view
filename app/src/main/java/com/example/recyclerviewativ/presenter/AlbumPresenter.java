package com.example.recyclerviewativ.presenter;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.recyclerviewativ.model.Album;

import org.json.JSONObject;

import java.util.List;

public class AlbumPresenter {

  Album album = new Album();

  public AlbumPresenter() {
  }

  public void makeRequest(Context context) {
    String url = "https://jsonplaceholder.typicode.com/albums";
    RequestQueue requestQueue = Volley.newRequestQueue(context);

    JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
        Request.Method.GET,
        url,
        null,
        response -> {

          for (int i = 0; i < response.length() ; i++) {
            try {
              JSONObject json = response.getJSONObject(i);
              String id = json.getString("id");
              String title = json.getString("title");
              album.addAlbum(new Album(id, title));
            }catch (Exception e) {
              e.printStackTrace();
            }
          }

        },
        error -> {}
    );

    requestQueue.add(jsonArrayRequest);
  }

  public List<Album> exportAlbum(){
    return album.getAlbums();
  }
}
