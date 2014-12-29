package com.ali.corp.instagram.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ali.corp.instagram.adaptors.CustomFragmentAdaptor;
import com.ali.corp.instagram.animations.ZoomOutPageTransformer;
import com.ali.corp.instagram.data.Constants;
import com.ali.corp.instagram.data.Model;
import com.ali.corp.instagram.data.RetrofitApi;
import com.ali.corp.viewpager.R;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MyActivity extends FragmentActivity {

    CustomFragmentAdaptor mCustomFragmentAdaptor;
    ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mPager.setBackgroundColor(Color.TRANSPARENT);

        initialization();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        SharedPreferences.Editor editor = getSharedPreferences(Constants.TOKEN, Context.MODE_PRIVATE).edit();
        editor.remove(Constants.TOKEN).commit();
        Intent intent = new Intent(this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        getContentResolver().delete(ContentProviderInstagram.CONTENT_URI,null,null);
    }

    void initialization() {

        String token = getSharedPreferences(Constants.TOKEN, Context.MODE_PRIVATE).getString(Constants.TOKEN, Constants.ERROR);
        String searchTag = Constants.SEARCH_TEXT;

        RestAdapter adaptor = new RestAdapter.Builder().
                setEndpoint(Constants.INSTAGARAM_END_POINT).build();
        RetrofitApi retrofitApi = adaptor.create(RetrofitApi.class);

       /*
        * retrofit Async magic call
        */
        retrofitApi.getdata(searchTag, token, new Callback<Model>() {
            @Override
            public void success(final Model model, Response response) {
                mCustomFragmentAdaptor = new CustomFragmentAdaptor
                        (getSupportFragmentManager(), model);
                mPager.setAdapter(mCustomFragmentAdaptor);
                mCustomFragmentAdaptor.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.i("Network", retrofitError.toString());
                Toast.makeText(getBaseContext(), retrofitError.toString(), Toast.LENGTH_LONG).show();

            }
        });
    }


}
