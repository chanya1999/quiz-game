package com.midexam.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.midexam.quizgame.model.WordItem;

public class WordDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_details);

        Intent intent = getIntent();
        String itemJson = intent.getStringExtra("item");
        WordItem item = new Gson().fromJson(itemJson, WordItem.class);

//        String word = intent.getStringExtra("word");
//        int image = intent.getIntExtra("image",0);

        TextView textView = findViewById(R.id.word_text_view);
        ImageView imageView = findViewById(R.id.image_view);

        textView.setText(item.word);
        imageView.setImageResource(item.imageResId);

    }
}