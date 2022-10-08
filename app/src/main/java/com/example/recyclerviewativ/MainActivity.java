package com.example.recyclerviewativ;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity{

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void onClickAlbum(View view) {
    Intent intent = new Intent(view.getContext(), AlbumActivity.class);
    startActivity(intent);
  }

  public void onClickUser(View view) {
    Intent intent = new Intent(view.getContext(), UserActivity.class);
    startActivity(intent);
  }

  public void onClickTodo(View view) {
    Intent intent = new Intent(view.getContext(), TodoActivity.class);
    startActivity(intent);
  }

  public void onClickPhoto(View view) {
    Intent intent = new Intent(view.getContext(), PhotoActivity.class);
    startActivity(intent);
  }

  public void onClickComment(View view) {
    Intent intent = new Intent(view.getContext(), CommentActivity.class);
    startActivity(intent);
  }

  public void onClickPost(View view) {
    Intent intent = new Intent(view.getContext(), PostActivity.class);
    startActivity(intent);
  }
}