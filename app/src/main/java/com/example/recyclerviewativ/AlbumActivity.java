package com.example.recyclerviewativ;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.recyclerviewativ.adapter.AlbumAdapter;
import com.example.recyclerviewativ.presenter.AlbumPresenter;

public class AlbumActivity extends AppCompatActivity implements Response.ErrorListener {

  RecyclerView recyclerView;
  LinearLayoutManager layoutManager;
  AlbumAdapter adapter;
  AlbumPresenter albumPresenter = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_album);

    Context context = getApplicationContext();
    albumPresenter = new AlbumPresenter();
    albumPresenter.makeRequest(context);
    
    recyclerView = findViewById(R.id.recyclerView);
    layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);
  }

  public void onCLick(View view){
    adapter = new AlbumAdapter(albumPresenter.exportAlbum());
    recyclerView.setAdapter(adapter);
  }

  @Override
  public void onErrorResponse(VolleyError error) {
    Log.e("AlbumActivity", "onErrorResponse: " + error.getMessage());
  }
}