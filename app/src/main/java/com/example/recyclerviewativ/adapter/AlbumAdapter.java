package com.example.recyclerviewativ.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewativ.R;
import com.example.recyclerviewativ.model.Album;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder>{

  List<Album> albumsList;

  public AlbumAdapter(List<Album> albumsList) {
    this.albumsList = albumsList;
  }

  @NonNull
  @Override
  public AlbumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull AlbumAdapter.ViewHolder holder, int position) {
    holder.id.setText(albumsList.get(position).getId());
    holder.prop.setText(albumsList.get(position).getTitle());
  }

  @Override
  public int getItemCount() {
    return albumsList.size();
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
