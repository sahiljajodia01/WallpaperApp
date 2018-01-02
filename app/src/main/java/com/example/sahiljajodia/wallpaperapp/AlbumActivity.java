package com.example.sahiljajodia.wallpaperapp;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.darsh.multipleimageselect.activities.AlbumSelectActivity;
import com.darsh.multipleimageselect.helpers.Constants;
import com.darsh.multipleimageselect.models.Album;
import com.squareup.picasso.Picasso;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.engine.impl.PicassoEngine;

import java.util.ArrayList;
import java.util.List;

public class AlbumActivity extends AppCompatActivity {
    private ArrayList<Uri> imagePaths;
    private String albumName;
    private Button mPhotoButton;
    private RecyclerView recyclerView;
    private PhotoAdapter photoAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_photo);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            albumName = bundle.getString("SelectedAlbum");
            this.setTitle(albumName);
        }

        context = AlbumActivity.this;
        recyclerView = (RecyclerView) findViewById(R.id.photo_recycler_view);
        photoAdapter = new PhotoAdapter(context, imagePaths);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(photoAdapter);
        photoAdapter.notifyDataSetChanged();

        mPhotoButton = (Button) findViewById(R.id.demo_button);

        mPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(getApplicationContext(), AlbumSelectActivity.class);
                intent.putExtra(Constants.INTENT_EXTRA_LIMIT, 5);
                startActivityForResult(intent, Constants.REQUEST_CODE);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == Constants.REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            imagePaths = data.getParcelableArrayListExtra(Constants.INTENT_EXTRA_IMAGES);
        }

        recyclerView.setAdapter(photoAdapter);
        recyclerView.getAdapter().notifyDataSetChanged();

    }
}
