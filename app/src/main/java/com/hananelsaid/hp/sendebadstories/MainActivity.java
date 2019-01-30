package com.hananelsaid.hp.sendebadstories;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView img_email, img_share, img_apps, img_close;
    EditText search_et;
    ArrayList searchingArray;
    private String[] storiesArray;
    private ListView listStories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listStories = findViewById(R.id.list_dynamic);
        TextView names_txt = findViewById(R.id.textView);
        img_email = findViewById(R.id.img_email);
        img_share = findViewById(R.id.img_share);
        img_apps = findViewById(R.id.img_apps);
        img_close = findViewById(R.id.img_close);
        search_et = findViewById(R.id.editText);
        searchingArray = new ArrayList();
        storiesArray = getResources().getStringArray(R.array.stories);

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.row_item, R.id.names_ids, storiesArray);
        listStories.setAdapter(arrayAdapter);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font.ttf");
        names_txt.setTypeface(typeface);

        listStories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, WebHtml.class);
                intent.putExtra("position", i);
                startActivity(intent);
            }
        });

    }

    public void search(View view) {
        searchingArray.clear();
        String itemsearch = search_et.getText().toString();
        for (int i = 0; i < storiesArray.length; i++) {
            String item = storiesArray[i];
            if (item.contains(itemsearch)) {
                searchingArray.add(item);
            }
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.row_item, R.id.names_ids, searchingArray);
        listStories.setAdapter(arrayAdapter);


    }

    public void share(View view) {
    }

    public void sendEmail(View view) {
        String text = "السلام عليكم ورحمه الله وبركاته اقتراحى عن التطبيق  هو";
        Intent sendmail = new Intent(Intent.ACTION_SEND);
        sendmail.setData(Uri.parse("mailto:"));
        sendmail.setType("message/rfc822");
        sendmail.putExtra(Intent.EXTRA_EMAIL, "helsaid13@gmail.com");
        sendmail.putExtra(Intent.EXTRA_SUBJECT, "تطبيق حكايات السندباد");
        sendmail.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(sendmail);
    }

    public void showMoreApp(View view) {
    }

    public void close(View view) {
        finish();
    }


}
