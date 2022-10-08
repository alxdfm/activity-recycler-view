package com.example.recyclerviewativ.presenter;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.recyclerviewativ.model.Comment;

import org.json.JSONObject;

import java.util.List;

public class CommentPresenter{

  Comment comment = new Comment();

  public CommentPresenter() {
  }

  public void makeRequest(Context context) {
    String url = "https://jsonplaceholder.typicode.com/comments";
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
              String name = json.getString("name");
              comment.addComment(new Comment(id, name));
            }catch (Exception e) {
              e.printStackTrace();
            }
          }

        },
        error -> {}
    );

    requestQueue.add(jsonArrayRequest);
  }

  public List<Comment> exportComment(){
    return comment.getComments();
  }
}
