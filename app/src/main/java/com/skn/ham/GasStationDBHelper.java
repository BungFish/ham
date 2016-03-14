package com.skn.ham;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by slogup on 2016. 3. 14..
 */
public class GasStationDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "station.db";

    public GasStationDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql =  "CREATE TABLE " + GasStationContract.TABLE_NAME + " (" +
                GasStationContract.COLUMN_SEQ + " INTEGER PRIMARY KEY," +
                GasStationContract.COLUMN_ADDR + " TEXT NOT NULL," +
                GasStationContract.COLUMN_LOC_LAT + " REAL NOT NULL," +
                GasStationContract.COLUMN_LOC_LONG + " REAL NOT NULL," +
                GasStationContract.COLUMN_NAME + " TEXT NOT NULL," +
                GasStationContract.COLUMN_TEL + " TEXT NOT NULL," +
                GasStationContract.COLUMN_PRICE_GAS + " INTEGER," +
                GasStationContract.COLUMN_DISC_GAS + " INTEGER," +
                GasStationContract.COLUMN_PRICE_DIESEL + " INTEGER," +
                GasStationContract.COLUMN_DISC_DIESEL + " INTEGER," +
                GasStationContract.COLUMN_PRICE_HGAS + " INTEGER," +
                GasStationContract.COLUMN_DISC_HGAS + " INTEGER," +
                GasStationContract.COLUMN_FULL_TEXT + " TEXT NOT NULL," +
                GasStationContract.COLUMN_FAVORITE_YN + " TEXT NOT NULL," +
                GasStationContract.COLUMN_OPT_CONVSTORE_YN + " TEXT," +
                GasStationContract.COLUMN_OPT_DIRECT_YN + " TEXT," +
                GasStationContract.COLUMN_OPT_HGAS_YN + " TEXT," +
                GasStationContract.COLUMN_OPT_REPAIR_YN + " TEXT," +
                GasStationContract.COLUMN_OPT_SELF_YN + " TEXT," +
                GasStationContract.COLUMN_OPT_WASH_YN + " TEXT);";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists " + GasStationContract.TABLE_NAME;
        db.execSQL(sql);

        onCreate(db);
    }
}
