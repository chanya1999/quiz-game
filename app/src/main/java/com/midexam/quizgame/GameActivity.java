package com.midexam.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.midexam.quizgame.model.WordItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mQuestionImageView;
    private Button[] mButtons = new Button[4];

    private String mAnswerWord;
    private Random mRandom;
    private List<WordItem> mItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionImageView = findViewById(R.id.question_image_view);
        mButtons[0] = findViewById(R.id.choice_1_button);
        mButtons[1] = findViewById(R.id.choice_2_button);
        mButtons[2] = findViewById(R.id.choice_3_button);
        mButtons[3] = findViewById(R.id.choice_4_button);

        mButtons[0].setOnClickListener(this);
        mButtons[1].setOnClickListener(this);
        mButtons[2].setOnClickListener(this);
        mButtons[3].setOnClickListener(this);


        mRandom = new Random();
        newQuiz();
    }

    private void newQuiz() {
        mItemList = new ArrayList<>(Arrays.asList(WordListActivity.items));
        // random word for game
        int answerIndex = mRandom.nextInt(mItemList.size());

        WordItem item = mItemList.get(answerIndex);
        // set image for test
        mQuestionImageView.setImageResource(item.imageResId);

        mAnswerWord = item.word;

        // random choice button answer
        int randomButton = mRandom.nextInt(4);
        mButtons[randomButton].setText(item.word);
        // pull answer item out form list
        mItemList.remove(item);
        // shuffle data
        Collections.shuffle(mItemList);

        for (int i = 0; i < 4 ; i++){
            if(i == randomButton){
                continue;
            }
            mButtons[i].setText(mItemList.get(i).word);
        }
    }


    @Override
    public void onClick(View view) {
        Button b = findViewById(view.getId());
        String buttonText = b.getText().toString();

        if(mAnswerWord.equals(buttonText)){
            Toast.makeText(GameActivity.this,"✔ CORRECT",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(GameActivity.this,"✖ INCORRECT!",Toast.LENGTH_SHORT).show();
        }
        newQuiz();

    }
}