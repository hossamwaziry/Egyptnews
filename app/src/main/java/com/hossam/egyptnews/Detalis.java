package com.hossam.egyptnews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Detalis extends AppCompatActivity {

    TextView desc, tilte;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalis);

        desc = (TextView) findViewById(R.id.text_desc);
        tilte = (TextView) findViewById(R.id.text_title);
        imageView = (ImageView) findViewById(R.id.image_news);

        Intent intent = getIntent();

        desc.setText(intent.getStringExtra("desc"));
        tilte.setText(intent.getStringExtra("title"));
        Picasso.with(getApplicationContext()).load(intent.getStringExtra("image")).into(imageView);


    }
}
