package com.example.recyclerviewativ.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewativ.R;
import com.example.recyclerviewativ.model.Photo;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder>{

  List<Photo> PhotosList;

  public PhotoAdapter(List<Photo> PhotosList) {
    this.PhotosList = PhotosList;
  }

  @NonNull
  @Override
  public PhotoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull PhotoAdapter.ViewHolder holder, int position) {
    holder.id.setText(PhotosList.get(position).getId());
    holder.prop.setText(PhotosList.get(position).getTitle());
  }

  @Override
  public int getItemCount() {
    return PhotosList.size();
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
