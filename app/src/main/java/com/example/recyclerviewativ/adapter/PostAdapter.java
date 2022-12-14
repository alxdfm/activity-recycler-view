package com.example.recyclerviewativ.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewativ.R;
import com.example.recyclerviewativ.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>{

  List<Post> postsList;

  public PostAdapter(List<Post> postsList) {
    this.postsList = postsList;
  }

  @NonNull
  @Override
  public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
    holder.id.setText(postsList.get(position).getId());
    holder.prop.setText(postsList.get(position).getTitle());
  }

  @Override
  public int getItemCount() {
    return postsList.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder{
    TextView id;
    TextView prop;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);

      id = itemView.findViewById(R.id.id);
      prop = itemView.findViewById(R.id.prop);
    }
  }
}
