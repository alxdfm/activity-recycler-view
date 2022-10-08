package com.example.recyclerviewativ.presenter;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.recyclerviewativ.model.Photo;

import org.json.JSONObject;

import java.util.List;

public class PhotoPresenter {

  Photo photo = new Photo();

  public PhotoPresenter() {
  }

  public void makeRequest(Context context) {
    String url = "https://jsonplaceholder.typicode.com/photos";
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
              photo.addPhoto(new Photo(id, title));
            }catch (Exception e) {
              e.printStackTrace();
            }
          }

        },
        error -> {}
    );

    requestQueue.add(jsonArrayRequest);
  }

  public List<Photo> exportPhoto(){
    return photo.getPhotos();
  }
}
