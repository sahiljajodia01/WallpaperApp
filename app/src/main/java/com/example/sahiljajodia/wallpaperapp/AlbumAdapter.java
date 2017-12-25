package com.example.sahiljajodia.wallpaperapp;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.net.URI;
import java.util.ArrayList;

/**
 * Created by sahiljajodia on 24/12/17.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<String> name;

    public AlbumAdapter(Context context, ArrayList<String> name) {
        this.context = context;
        this.name = name;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView albumPhoto;
        TextView albumName;

        MyViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.album_card_view);
            albumPhoto = (ImageView) itemView.findViewById(R.id.album_image);
            albumName = (TextView) itemView.findViewById(R.id.album_title);
        }

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.albums_card, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return  myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.albumName.setText(name.get(position));
        Glide.with(context).load(R.drawable.placeholder).into(holder.albumPhoto);
    }
}
