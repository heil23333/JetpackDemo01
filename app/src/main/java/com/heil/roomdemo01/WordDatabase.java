package com.heil.roomdemo01;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {
    public abstract WordDao getWordDao();
    private static WordDatabase wordDatabase;
    public static synchronized WordDatabase getInstance(Context context){
        if (wordDatabase == null) {
            wordDatabase = Room.databaseBuilder(context, WordDatabase.class, "word_database").build();
        }
        return wordDatabase;
    }
}
