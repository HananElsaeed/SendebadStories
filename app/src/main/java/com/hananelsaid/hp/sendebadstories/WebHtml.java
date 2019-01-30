package com.hananelsaid.hp.sendebadstories;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebHtml extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_html);
        WebView webView = findViewById(R.id.webView_id);
        Intent data = getIntent();
        int position = data.getExtras().getInt("position");
        position = position + 1;
        webView.loadUrl("file:///android_asset/" + position + ".html");

    }
}
