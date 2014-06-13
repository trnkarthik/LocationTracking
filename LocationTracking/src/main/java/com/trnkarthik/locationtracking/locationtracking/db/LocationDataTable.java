package com.trnkarthik.locationtracking.locationtracking.db;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by karthiktangirala on 6/11/14.
 */
public class LocationDataTable {

    static final String TABLE_NAME = "locationData";
    static final String LOCATION_ID = "id";
    static final String LOCATION_LAT = "location_lat";
    static final String LOCATION_LONG = "location_long";
    static final String LOCATION_GEO_ADDRESS = "geo_address";
    static final String LOCATION_ACCURACY = "accuracy";
    public static String LOCATION_DATE_TIME = "location_date_time";

    static public void onCreate(SQLiteDatabase db){
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE " + LocationDataTable.TABLE_NAME + " (");
        sb.append(LocationDataTable.LOCATION_ID + " integer primary key autoincrement, ");
        sb.append(LocationDataTable.LOCATION_LAT + " real not null, ");
        sb.append(LocationDataTable.LOCATION_LONG + " real not null");
        sb.append(LocationDataTable.LOCATION_GEO_ADDRESS + " text not null");
        sb.append(LocationDataTable.LOCATION_ACCURACY + " real not null");
        sb.append(LocationDataTable.LOCATION_DATE_TIME + " text not null");
        sb.append(");");
        try{
            db.execSQL(sb.toString());
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    static public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + LocationDataTable.TABLE_NAME);
        LocationDataTable.onCreate(db);
    }
}
