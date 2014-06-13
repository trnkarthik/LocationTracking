package com.trnkarthik.locationtracking.locationtracking.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by karthiktangirala on 6/11/14.
 */
public class LocationDBHelper extends SQLiteOpenHelper{
    static final String DATABASE_NAME = "locationData.db";
    static final int DATABASE_VERSION = 1;
    static final String TAG = "LocationDBHelperUpgrade";

    LocationDBHelper(Context mContext){
        super(mContext, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        LocationDataTable.onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG, "Upgrading db from version " + oldVersion + " to " + newVersion + ", this will destroy all old data");
        LocationDataTable.onUpgrade(db, oldVersion, newVersion);
    }
}