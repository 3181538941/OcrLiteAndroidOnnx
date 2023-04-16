package com.benjaminwan.ocr.onnx.utils;

import com.benjaminwan.ocr.onnx.models.HistoryContract;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class SQLiteDBHelper extends SQLiteOpenHelper {
    public static final int DATA_VERSION = 1;
    public static final String DATABASE_NAME = "info.db";

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + HistoryContract.FeedHistory.TABLE_NAME +
            "(" +
            HistoryContract.FeedHistory._ID + " INTEGER PRIMARY KEY," +
            HistoryContract.FeedHistory.COLUMN_NAME_CONTENT + " TEXT," +
            HistoryContract.FeedHistory.COLUMN_NAME_CREATE_TIME + " DATETIME" +
            ")";

    public SQLiteDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

