package com.heil.roomdemo01;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

public class Repository {
    private WordDao wordDao;
    private static Repository repository;
    private LiveData<List<Word>> liveWords;

    private Repository(Context context) {
        wordDao = WordDatabase.getInstance(context).getWordDao();
        liveWords = wordDao.getLiveAll();
    }

    public LiveData<List<Word>> getLiveWords() {
        return liveWords;
    }

    public static synchronized Repository getRepository(Context context) {
        if (repository == null) {
            repository = new Repository(context);
        }
        return repository;
    }

    public void insertWord(Word ...words) {
        new InsertAsyncTask(wordDao).execute(words);
    }

    public void updateWord(Word ...words) {
        new UpdateAsyncTask(wordDao).execute(words);
    }

    public void deleteWord(Word ...words) {
        new DeleteAsyncTask(wordDao).execute(words);
    }

    public void clearWord() {
        new ClearAsyncTask(wordDao).execute();
    }

    public static class InsertAsyncTask extends AsyncTask<Word, Void , Void> {
        WordDao wordDao;

        public InsertAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.insert(words);
            return null;
        }
    }

    public static class UpdateAsyncTask extends AsyncTask<Word, Void , Void> {
        WordDao wordDao;

        public UpdateAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.update(words);
            return null;
        }
    }

    public static class DeleteAsyncTask extends AsyncTask<Word, Void , Void> {
        WordDao wordDao;

        public DeleteAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.delete(words);
            return null;
        }
    }

    public static class ClearAsyncTask extends AsyncTask<Void, Void , Void> {
        WordDao wordDao;

        public ClearAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            wordDao.deleteAll();
            return null;
        }
    }
}
