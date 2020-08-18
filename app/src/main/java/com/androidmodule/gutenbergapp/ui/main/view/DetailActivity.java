package com.androidmodule.gutenbergapp.ui.main.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidmodule.gutenbergapp.R;
import com.androidmodule.gutenbergapp.data.model.Image;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageViewAlbum;
    private TextView textViewArtistName,textViewAlbumName;
    private Button buttonPlay;
    private String albumName,artistName, songUrl, albumImage;
    private ArrayList<Image> imageList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        initView();
        getData();
        setData();
        playSong();
    }

    private void setData() {
        textViewAlbumName.setText("Album:" +" "+ albumName);
        textViewArtistName.setText("Artist:" + " " +artistName);
        Glide.with(this).load(imageList.get(1).getText()).into(imageViewAlbum);
    }

    private void getData() {
        Intent intent = getIntent();
        albumName = intent.getStringExtra("name");
        artistName = intent.getStringExtra("artist_name");
        songUrl = intent.getStringExtra("url");
        imageList = intent.getParcelableArrayListExtra("image");
    }

    private void playSong() {
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(songUrl));
                startActivity(intent);
            }
        });
    }

    private void initView() {
        imageViewAlbum = (ImageView)findViewById(R.id.album_image_detail);
        textViewAlbumName = (TextView) findViewById(R.id.name);
        textViewArtistName = (TextView) findViewById(R.id.name_artist);
        buttonPlay = (Button) findViewById(R.id.play);
    }
}
