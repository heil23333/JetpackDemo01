package com.heil.roomdemo01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button buttonInsert, buttonUpdate, buttonDelete, buttonClear;
    TextView textView;
    LiveData<List<Word>> wordLiveData;
    ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(ViewModel.class);
        wordLiveData = viewModel.getLiveWords();
        buttonInsert = findViewById(R.id.button_insert);
        buttonUpdate = findViewById(R.id.button_update);
        buttonClear = findViewById(R.id.button_clear);
        buttonDelete = findViewById(R.id.button_delete);
        textView = findViewById(R.id.textView);
        wordLiveData.observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                StringBuilder text = new StringBuilder();
                for (Word word : words) {
                    text.append("id=").append(word.getId()).append("  English=").append(word.getEnglish()).append("  Chinese=").append(word.getChinese()).append("\n");
                }
                textView.setText(text.toString());
            }
        });
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word = new Word("Hello", "你好");
                Word word1 = new Word("World", "世界");
                viewModel.insertWord(word, word1);
            }
        });
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word = new Word("New World", "新世界");
                word.setId(60);
                viewModel.updateWord(word);
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word = new Word("", "");
                word.setId(60);
                viewModel.deleteWord(word);
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.clearWord();
            }
        });
    }
}
