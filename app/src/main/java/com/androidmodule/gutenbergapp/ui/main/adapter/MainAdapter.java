package com.androidmodule.gutenbergapp.ui.main.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidmodule.gutenbergapp.R;
import com.androidmodule.gutenbergapp.data.model.Album;
import com.androidmodule.gutenbergapp.ui.main.view.DetailActivity;
import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> implements View.OnClickListener {

    private Context context;
    private List<Album> albumList;

    public MainAdapter(Context context, List<Album> albumList) {
        this.context = context;
        this.albumList = albumList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.MainViewHolder holder, int position) {
        holder.textViewAlbumName.setText(albumList.get(position).getName());
        holder.textViewArtistName.setText(albumList.get(position).getArtist());
        Glide.with(context).load(albumList.get(position).getImage().get(0).getText()).into(holder.imageViewAlbumView);
        holder.constraintLayout.setTag(holder);
        holder.constraintLayout.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    @Override
    public void onClick(View view) {
        MainViewHolder mainViewHolder = (MainViewHolder) view.getTag();
        int position = mainViewHolder.getAdapterPosition();
        switch (view.getId()) {
            case R.id.container: {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("name", albumList.get(position).getName());
                intent.putExtra("artist_name", albumList.get(position).getArtist());
                intent.putExtra("url", albumList.get(position).getUrl());
                intent.putParcelableArrayListExtra("image", albumList.get(position).getImage());
                context.startActivity(intent);
            }
            break;
        }
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewAlbumView;
        private TextView textViewAlbumName, textViewArtistName;
        private ConstraintLayout constraintLayout;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout = (ConstraintLayout) itemView.findViewById(R.id.container);
            imageViewAlbumView = (ImageView) itemView.findViewById(R.id.album_image);
            textViewAlbumName = (TextView) itemView.findViewById(R.id.album_name);
            textViewArtistName = (TextView) itemView.findViewById(R.id.artist_name);
        }
    }
}
