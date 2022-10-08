package com.example.recyclerviewativ;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.recyclerviewativ.adapter.TodoAdapter;
import com.example.recyclerviewativ.presenter.TodoPresenter;

public class TodoActivity extends AppCompatActivity implements Response.ErrorListener {

  RecyclerView recyclerView;
  LinearLayoutManager layoutManager;
  TodoAdapter adapter;
  TodoPresenter TodoPresenter = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_todo);

    Context context = getApplicationContext();
    TodoPresenter = new TodoPresenter();
    TodoPresenter.makeRequest(context);


    recyclerView = findViewById(R.id.recyclerView);
    layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);
    adapter = new TodoAdapter(TodoPresenter.exportTodo());
    recyclerView.setAdapter(adapter);
  }

  @Override
  public void onErrorResponse(VolleyError error) {
    Log.e("TodoActivity", "onErrorResponse: " + error.getMessage());
  }
}