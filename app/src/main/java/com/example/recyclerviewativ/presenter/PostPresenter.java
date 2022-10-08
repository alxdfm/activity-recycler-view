package com.example.recyclerviewativ.presenter;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.recyclerviewativ.model.Post;

import org.json.JSONObject;

import java.util.List;

public class PostPresenter {

  Post Post = new Post();

  public PostPresenter() {
  }

  public void makeRequest(Context context) {
    String url = "https://jsonplaceholder.typicode.com/Posts";
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
              Post.addPost(new Post(id, title));
            }catch (Exception e) {
              e.printStackTrace();
            }
          }

        },
        error -> {}
    );

    requestQueue.add(jsonArrayRequest);
  }

  public List<Post> exportPost(){
    return Post.getPosts();
  }
}
