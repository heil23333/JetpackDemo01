package com.heil.roomdemo01;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    private Repository repository;

    public LiveData<List<Word>> getLiveWords() {
        return repository.getLiveWords();
    }

    public ViewModel(@NonNull Application application) {
        super(application);
        repository = Repository.getRepository(application);
    }

    public void insertWord(Word ...words){
        repository.insertWord(words);
    }

    public void updateWord(Word ...words) {
        repository.updateWord(words);
    }

    public void deleteWord(Word ...words) {
        repository.deleteWord(words);
    }

    public void clearWord() {
        repository.clearWord();
    }
}
