package com.example.recyclerviewativ;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.recyclerviewativ.adapter.PhotoAdapter;
import com.example.recyclerviewativ.presenter.PhotoPresenter;

public class PhotoActivity extends AppCompatActivity implements Response.ErrorListener {

  RecyclerView recyclerView;
  LinearLayoutManager layoutManager;
  PhotoAdapter adapter;
  PhotoPresenter PhotoPresenter = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_photo);

    PhotoPresenter = new PhotoPresenter();

    Context context = getApplicationContext();
    PhotoPresenter.makeRequest(context);

    recyclerView = findViewById(R.id.recyclerView);
    layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);

    adapter = new PhotoAdapter(PhotoPresenter.exportPhoto());
    recyclerView.setAdapter(adapter);
  }

  @Override
  public void onErrorResponse(VolleyError error) {
    Log.e("PhotoActivity", "onErrorResponse: " + error.getMessage());
  }
}