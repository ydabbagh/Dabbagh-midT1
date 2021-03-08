package com.example.dabbagh_midt1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity3 extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout);
        String [] animals = {" Elephant", " Horse", "Lamb", "Giraffe"};
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, R.id.list, animals));
    }
    protected void onListItemClick(ListView l, View v, int position, long id){
        switch(position){
            case 0:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://alfaisal.edu")));
                break;
            case 1:
                startActivity(new Intent(MainActivity3.this, MainActivity4.class));
                break;
        }
    }
}