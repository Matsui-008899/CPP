package com.example.calendarapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * https://qiita.com/kengo_kuwahara/items/a8ef858a9810cad42ca6
 */
public class DataBase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 3;

    private  static final String DATABASE_NAME = "TASK.db";
    private  static final String TABLE_NAME = "taskdb";
    private  static final String _ID = "_id";
    private  static final String STARTDAY = "startDay";
    private  static final String STARTTIME = "startTime";
    private  static final String ENDDAY = "endDay";
    private  static final String ENDTIME = "endTime";
    private  static final String TASK = "task";
    private  static final String LEVELCHECK = "level";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    STARTDAY + " TEXT," +
                    STARTTIME + " TEXT," +
                    ENDDAY + " TEXT," +
                    ENDTIME + " TEXT," +
                    TASK + " TEXT," +
                    LEVELCHECK + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;


    DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                SQL_CREATE_ENTRIES
        );

        saveData(db, "2022年01月12日", "12時30分", "2022年01月12日", "13時40分", "肉まん1","0");
        saveData(db, "2022年01月12日", "12時30分", "2022年01月12日", "13時40分", "肉まん12","0");
        saveData(db, "2022年01月12日", "12時30分", "2022年01月12日", "13時40分", "肉まん1","0");
        saveData(db, "2022年01月12日", "12時30分", "2022年01月12日", "13時40分", "肉まん12","0");
        saveData(db, "2022年01月12日", "12時30分", "2022年01月12日", "13時40分", "肉まん1","0");
        saveData(db, "2022年01月12日", "12時30分", "2022年01月12日", "13時40分", "肉まん12","0");
        saveData(db, "2022年02月12日", "12時30分", "2022年02月12日", "13時40分", "肉まん123","0");
        saveData(db, "2022年02月12日", "12時30分", "2022年02月12日", "13時40分", "肉まん1234","0");
        saveData(db, "2022年02月12日", "12時30分", "2022年02月12日", "13時40分", "肉まん123","0");
        saveData(db, "2022年02月12日", "12時30分", "2022年02月12日", "13時40分", "肉まん1234","0");
        saveData(db, "2022年02月12日", "12時30分", "2022年02月12日", "13時40分", "肉まん123","0");
        saveData(db, "2022年02月12日", "12時30分", "2022年02月12日", "13時40分", "肉まん1234","0");
        saveData(db, "2022年03月12日", "12時30分", "2022年03月12日", "13時40分", "肉まん1234","0");
        saveData(db, "2022年03月12日", "12時30分", "2022年03月12日", "13時40分", "肉まん1234","0");
        saveData(db, "2022年04月12日", "12時30分", "2022年04月12日", "13時40分", "肉まん1234","0");
        saveData(db, "2022年04月12日", "12時30分", "2022年04月12日", "13時40分", "肉まん1234","0");
        saveData(db, "2022年05月12日", "12時30分", "2022年05月12日", "13時40分", "肉まん1234","0");
        saveData(db, "2022年05月12日", "12時30分", "2022年05月12日", "13時40分", "肉まん1234","0");
    }


    public void saveData(SQLiteDatabase db, String startD,String startT, String endD,String endT,String task,String level) {
        ContentValues values = new ContentValues();
        values.put("startDay",startD);
        values.put("startTime",startT);
        values.put("endDay",endD);
        values.put("endTime",endT);
        values.put("task",task);
        values.put("level",level);

        db.insert("taskdb",null,values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
            db.execSQL(
                    SQL_DELETE_ENTRIES
            );
            onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
