package com.example.recyclerviewativ;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.recyclerviewativ.adapter.CommentAdapter;
import com.example.recyclerviewativ.presenter.CommentPresenter;

public class CommentActivity extends AppCompatActivity implements Response.ErrorListener {

  RecyclerView recyclerView;
  LinearLayoutManager layoutManager;
  CommentAdapter adapter;
  CommentPresenter CommentPresenter = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_comment);

    Context context = getApplicationContext();
    CommentPresenter = new CommentPresenter();
    CommentPresenter.makeRequest(context);


    recyclerView = findViewById(R.id.recyclerView);
    layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);
    adapter = new CommentAdapter(CommentPresenter.exportComment());
    recyclerView.setAdapter(adapter);
  }

  @Override
  public void onErrorResponse(VolleyError error) {
    Log.e("CommentActivity", "onErrorResponse: " + error.getMessage());
  }
}