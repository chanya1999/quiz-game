package com.midexam.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class WordDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_details);

        Intent intent = getIntent();
        String word = intent.getStringExtra("word");
        int image = intent.getIntExtra("image",0);

        TextView textView = findViewById(R.id.word_text_view);
        ImageView imageView = findViewById(R.id.image_view);
        textView.setText(word);
        imageView.setImageResource(image);

    }
}