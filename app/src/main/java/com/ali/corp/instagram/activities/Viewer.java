package com.ali.corp.instagram.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.ali.corp.viewpager.R;
import com.squareup.picasso.Picasso;

public class Viewer extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getActionBar().setDisplayShowHomeEnabled(false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer);
        ImageView imageView = (ImageView) findViewById(R.id.viewer);
        Picasso.with(this).load(getIntent().getData()).into(imageView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.viewer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
