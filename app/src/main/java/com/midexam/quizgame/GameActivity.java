package com.midexam.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.midexam.quizgame.model.WordItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private ImageView mQuestionImageView;
    private Button[] mChoiceButtons = new Button[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        List<WordItem> itemList = new ArrayList<>(Arrays.asList(WordListActivity.items));

        mQuestionImageView = findViewById(R.id.question_image_view);
        mChoiceButtons[0] = findViewById(R.id.choice_1_button);
        mChoiceButtons[1] = findViewById(R.id.choice_2_button);
        mChoiceButtons[2] = findViewById(R.id.choice_3_button);
        mChoiceButtons[3] = findViewById(R.id.choice_4_button);

        Random r = new Random();
        // random word for game
        int answerIndex = r.nextInt(itemList.size());

        WordItem item = itemList.get(answerIndex);
        // set image for test
        mQuestionImageView.setImageResource(item.imageResId);

        // random choice button answer
        int randomButton = r.nextInt(4);
        mChoiceButtons[randomButton].setText(itemList.get(answerIndex).word);
        // pull answer item out form list
        itemList.remove(item);
        // shuffle data
        Collections.shuffle(itemList);

        for (int i = 0; i < 4 ; i++){
            if(i == randomButton){
                continue;
            }
            mChoiceButtons[i].setText(itemList.get(i).word);
        }


    }
}