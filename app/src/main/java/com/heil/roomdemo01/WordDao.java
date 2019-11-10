package com.heil.roomdemo01;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    void insert(Word ...words);
    @Update
    void update(Word ...words);
    @Delete
    void delete(Word ...words);
    @Query("DELETE FROM word_table")
    void deleteAll();
    @Query("SELECT * FROM word_table ORDER BY id DESC")
    List<Word> getAll();
    @Query("SELECT * FROM word_table ORDER BY id DESC")
    LiveData<List<Word>> getLiveAll();
}
