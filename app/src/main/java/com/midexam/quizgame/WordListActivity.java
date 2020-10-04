package com.midexam.quizgame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.midexam.quizgame.model.WordItem;

public class WordListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

        //Create Adapter object
        MyAdapter adapter = new MyAdapter();
        //Create layout manager
        LinearLayoutManager lm = new LinearLayoutManager(WordListActivity.this);
        RecyclerView rv = findViewById(R.id.word_list_recycler_view);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
    }


}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    WordItem[] items = {
            new WordItem(R.drawable.cat,"CAT"),
            new WordItem(R.drawable.dog,"DOG"),
            new WordItem(R.drawable.dolphin,"DOLPHIN"),
            new WordItem(R.drawable.tiger,"TIGER"),
            new WordItem(R.drawable.koala,"KOALA"),
            new WordItem(R.drawable.lion,"LION"),
            new WordItem(R.drawable.rabbit,"RABBIT"),
            new WordItem(R.drawable.owl,"OWL"),
            new WordItem(R.drawable.penguin,"PENGUIN"),
            new WordItem(R.drawable.pig,"PIG")
    };
    public MyAdapter() {

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_word, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(items[position].imageResId);
        holder.wordTextView.setText(items[position].word);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView wordTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            wordTextView = itemView.findViewById(R.id.word_text_view);
        }
    }
}