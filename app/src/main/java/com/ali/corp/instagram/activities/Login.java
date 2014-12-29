package com.ali.corp.instagram.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ali.corp.viewpager.R;
import com.ali.corp.instagram.data.Constants;


public class Login extends Activity {
    private SharedPreferences mToken;
    private WebView mWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mToken = getApplicationContext().getSharedPreferences(Constants.TOKEN, Context.MODE_PRIVATE);
        mWebView = (WebView) findViewById(R.id.webView);

        if (mToken.getString(Constants.TOKEN, "").equals("")) {
            mWebView.setWebViewClient(new WebViewController());
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
            mWebView.loadUrl(Constants.AUTHORIZATION_URL);

        } else {

            mWebView.setVisibility(WebView.GONE);
            newActivity();
            finish();
        }

    }

    private void newActivity(){
        //destroy old web view

        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();

        // create new activity
        Intent intent = new Intent(this,MyActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public class WebViewController extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.contains(Constants.ACCESS_TOKEN_REGIX)) {
                String[] Code = url.split("=");
                String token = Code[1];
                SharedPreferences.Editor editor = mToken.edit();
                editor.putString(Constants.TOKEN, token);
                editor.commit();
                newActivity();
            }
            view.loadUrl(url);
            return true;
        }
    }
}
