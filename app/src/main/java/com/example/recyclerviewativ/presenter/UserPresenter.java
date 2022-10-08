package com.example.recyclerviewativ.presenter;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.recyclerviewativ.model.User;

import org.json.JSONObject;

import java.util.List;

public class UserPresenter{

  User user = new User();

  public UserPresenter() {
  }

  public void makeRequest(Context context) {
    String url = "https://jsonplaceholder.typicode.com/users";
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
              user.addUser(new User(id, name));
            }catch (Exception e) {
              e.printStackTrace();
            }
          }

        },
        error -> {}
    );

    requestQueue.add(jsonArrayRequest);
  }

  public List<User> exportUser(){
    return user.getUsers();
  }
}
