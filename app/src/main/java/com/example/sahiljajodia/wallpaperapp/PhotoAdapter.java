package com.example.sahiljajodia.wallpaperapp;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sahiljajodia on 02/01/18.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.MyViewHolder> {
    private static Context context;
    private static List<Uri> imagePath;

    public PhotoAdapter(Context context, List<Uri> imagePath) {
        this.context = context;
        this.imagePath = imagePath;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        MyViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.gallery_photos);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(context).load(imagePath.get(position)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        Log.i("Size: ", String.valueOf(imagePath.size()));
        return imagePath.size();
    }
}
