package com.example.recyclerviewativ.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewativ.R;
import com.example.recyclerviewativ.model.Comment;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder>{

  List<Comment> CommentsList;

  public CommentAdapter(List<Comment> CommentsList) {
    this.CommentsList = CommentsList;
  }

  @NonNull
  @Override
  public CommentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull CommentAdapter.ViewHolder holder, int position) {
    holder.id.setText(CommentsList.get(position).getId());
    holder.prop.setText(CommentsList.get(position).getName());
  }

  @Override
  public int getItemCount() {
    return CommentsList.size();
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
