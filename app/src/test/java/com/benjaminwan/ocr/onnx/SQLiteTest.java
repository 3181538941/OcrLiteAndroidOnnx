package com.benjaminwan.ocr.onnx;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.benjaminwan.ocr.onnx.utils.SQLiteDBHelper;
import com.benjaminwan.ocr.onnx.models.HistoryContract;

import org.junit.Test;

import java.time.LocalDateTime;

public class SQLiteTest extends Activity {

    @Test
    public void writeTest() {

//        SQLiteDBHelper helper = new SQLiteDBHelper(SQLiteTest.this);
//        final SQLiteDatabase db = helper.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(HistoryContract.FeedHistory.COLUMN_NAME_CONTENT, "test content 01");
//        values.put(HistoryContract.FeedHistory.COLUMN_NAME_CREATE_TIME, String.valueOf(LocalDateTime.now()));
//
//        long newRowId = db.insert(HistoryContract.FeedHistory.TABLE_NAME, null, values);
//        System.out.println(newRowId);
        System.out.println("writeTest() done");
    }
}
