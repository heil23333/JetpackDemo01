package com.heil.roomdemo01;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Word {
    public Word(String english, String chinese) {
        this.english = english;
        this.chinese = chinese;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "english")
    private String english;
    @ColumnInfo(name = "chinese")
    private String chinese;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }
}
