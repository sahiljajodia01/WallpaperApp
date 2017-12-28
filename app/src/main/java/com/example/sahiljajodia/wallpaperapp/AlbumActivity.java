package com.example.sahiljajodia.wallpaperapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AlbumActivity extends AppCompatActivity {
    private String albumName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_photo);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            albumName = bundle.getString("SelectedAlbum");
            this.setTitle(albumName);
        }

    }
}
