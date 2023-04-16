package com.benjaminwan.ocr.onnx.models;

import android.provider.BaseColumns;

/**
 * 历史记录 协定类
 */
public class HistoryContract {
    private HistoryContract() {
    }

    public static final class FeedHistory implements BaseColumns {

        public static final String TABLE_NAME = "history";
        public static final String COLUMN_NAME_CONTENT = "content";
        public static final String COLUMN_NAME_CREATE_TIME = "create_time";

    }
}
