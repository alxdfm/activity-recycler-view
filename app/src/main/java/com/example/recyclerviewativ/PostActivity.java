package com.example.recyclerviewativ;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.recyclerviewativ.adapter.PostAdapter;
import com.example.recyclerviewativ.presenter.PostPresenter;

public class PostActivity extends AppCompatActivity implements Response.ErrorListener {

  RecyclerView recyclerView;
  LinearLayoutManager layoutManager;
  PostAdapter adapter;
  PostPresenter PostPresenter = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_post);

    Context context = getApplicationContext();
    PostPresenter = new PostPresenter();
    PostPresenter.makeRequest(context);


    recyclerView = findViewById(R.id.recyclerView);
    layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);
    adapter = new PostAdapter(PostPresenter.exportPost());
    recyclerView.setAdapter(adapter);
  }

  @Override
  public void onErrorResponse(VolleyError error) {
    Log.e("PostActivity", "onErrorResponse: " + error.getMessage());
  }
}