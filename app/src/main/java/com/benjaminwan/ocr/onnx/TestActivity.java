package com.benjaminwan.ocr.onnx;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.benjaminwan.ocr.onnx.utils.SQLiteDBHelper;
import com.benjaminwan.ocr.onnx.models.HistoryContract;

import java.time.LocalDateTime;


public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        SQLiteDBHelper helper = new SQLiteDBHelper(TestActivity.this);

        final SQLiteDatabase db = helper.getWritableDatabase();

        Button button_add = findViewById(R.id.button_add); //add
        button_add.setOnClickListener(v -> {
            //创建存放数据的ContentValues对象
            ContentValues values = new ContentValues();
            values.put(HistoryContract.FeedHistory.COLUMN_NAME_CONTENT, "test");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                values.put(HistoryContract.FeedHistory.COLUMN_NAME_CREATE_TIME, LocalDateTime.now().toString());
            }
            //数据库执行插入命令
            db.insert(HistoryContract.FeedHistory.TABLE_NAME, null, values);
            Log.d("TestActivity", "insert done");
        });
        Button button_del = findViewById(R.id.button_del); //删
        button_del.setOnClickListener(v -> {
            db.delete(
                    HistoryContract.FeedHistory.TABLE_NAME,
                    HistoryContract.FeedHistory.COLUMN_NAME_CONTENT + "=?",
                    new String[]{"test"}
            );
            Log.d("TestActivity", "delete done");
        });
        Button button_update = findViewById(R.id.button_update); //改
        button_update.setOnClickListener(v -> {
            ContentValues values = new ContentValues();
            values.put(HistoryContract.FeedHistory.COLUMN_NAME_CONTENT, "update");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                values.put(HistoryContract.FeedHistory.COLUMN_NAME_CREATE_TIME, LocalDateTime.now().toString());
            }
            int count = db.update(
                    HistoryContract.FeedHistory.TABLE_NAME,
                    values,
                    HistoryContract.FeedHistory.COLUMN_NAME_CONTENT + "= ?",
                    new String[]{"test"}
            );
            Log.d("TestActivity", "update done, count:" + count);
        });

        Button button_select = findViewById(R.id.button_select); //查
        button_select.setOnClickListener(v -> {
            //创建游标对象
            Cursor cursor = db.query(
                    HistoryContract.FeedHistory.TABLE_NAME,
                    new String[]{
                            HistoryContract.FeedHistory._ID,
                            HistoryContract.FeedHistory.COLUMN_NAME_CONTENT,
                            HistoryContract.FeedHistory.COLUMN_NAME_CREATE_TIME
                    },
                    null,
                    null,
                    null,
                    null,
                    null
            );
            //利用游标遍历所有数据对象
            while (cursor.moveToNext()) {
                @SuppressLint("Range")
                int id = cursor.getInt(cursor.getColumnIndex(HistoryContract.FeedHistory._ID));
                @SuppressLint("Range")
                String content = cursor.getString(cursor.getColumnIndex(HistoryContract.FeedHistory.COLUMN_NAME_CONTENT));
                @SuppressLint("Range")
                String createTime = cursor.getString(cursor.getColumnIndex(HistoryContract.FeedHistory.COLUMN_NAME_CREATE_TIME));
                Log.d("SQLiteTest", "id:" + id + " content:" + content + " createTime:" + createTime);
            }
            // 关闭游标，释放资源
            cursor.close();
            Log.d("TestActivity", "select done");
        });
    }
}

