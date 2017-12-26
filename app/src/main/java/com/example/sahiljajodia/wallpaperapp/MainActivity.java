package com.example.sahiljajodia.wallpaperapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private ArrayList<String> name = new ArrayList<String>();
    private RecyclerView recyclerView;
    private AlbumAdapter albumAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;
        recyclerView = (RecyclerView) findViewById(R.id.album_recycler_view);
        albumAdapter = new AlbumAdapter(context, name);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        final EditText input = new EditText(getApplicationContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(albumAdapter);
        albumAdapter.notifyDataSetChanged();


        switch (item.getItemId()) {

            case R.id.action_add_album:
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Add Album");
                builder.setView(input);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        String text = input.getText().toString();
                        name.add(text);
               

                    }
                });
                builder.setNegativeButton("Cancel", null);
                builder.show();


            }



//            case R.id.action_add_album:
//                final Dialog dialog = new Dialog(MainActivity.this);
//                dialog.setContentView(R.layout.dialog_album_name);
//                dialog.setTitle("Add Album");
//
//                Button button = (Button) findViewById(R.id.add_album_button);
//                button.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                        EditText edit = (EditText) dialog.findViewById(R.id.username);
//                        String text = edit.getText().toString();
//                        name.add(text);
//                    }
//                });
//
//                dialog.show();
//                ListView listView = (ListView) findViewById(R.id.album_list_view);
//                listView.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, name));


                return super.onOptionsItemSelected(item);


    }
}
