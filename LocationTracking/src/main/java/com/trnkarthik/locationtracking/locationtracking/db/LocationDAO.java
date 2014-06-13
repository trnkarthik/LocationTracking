package com.trnkarthik.locationtracking.locationtracking.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karthiktangirala on 6/11/14.
 */
public class LocationDAO {
    private SQLiteDatabase db;


    public LocationDAO(SQLiteDatabase db){
        this.db = db;
    }

    public long save(LocationObject locationObject){
        ContentValues values = new ContentValues();
        values.put(LocationDataTable.LOCATION_LAT, locationObject.getLocation_lat());
        values.put(LocationDataTable.LOCATION_LONG, locationObject.getLocation_long());
        values.put(LocationDataTable.LOCATION_GEO_ADDRESS, locationObject.getGeo_address());
        values.put(LocationDataTable.LOCATION_ACCURACY, locationObject.getAccuracy());
        values.put(LocationDataTable.LOCATION_DATE_TIME, locationObject.getLocation_date_time());
        return db.insert(LocationDataTable.TABLE_NAME, null, values);
    }

    public boolean update(LocationObject locationObject){
        ContentValues values = new ContentValues();
        values.put(LocationDataTable.LOCATION_LAT, locationObject.getLocation_lat());
        values.put(LocationDataTable.LOCATION_LONG, locationObject.getLocation_long());
        values.put(LocationDataTable.LOCATION_GEO_ADDRESS, locationObject.getGeo_address());
        values.put(LocationDataTable.LOCATION_ACCURACY, locationObject.getAccuracy());
        values.put(LocationDataTable.LOCATION_DATE_TIME, locationObject.getLocation_date_time());
        return db.update(LocationDataTable.TABLE_NAME, values, LocationDataTable.LOCATION_ID+"="+ locationObject.getId(), null) > 0;
    }


    public boolean delete(LocationObject locationObject){
        return db.delete(LocationDataTable.TABLE_NAME, LocationDataTable.LOCATION_ID+"="+locationObject.getId(), null)>0;
    }

    public LocationObject get(long id){
        LocationObject locationObject = null;
        Cursor c = db.query(true, LocationDataTable.TABLE_NAME,
                new String[]{LocationDataTable.LOCATION_ID, LocationDataTable.LOCATION_LAT,
                        LocationDataTable.LOCATION_LONG, LocationDataTable.LOCATION_GEO_ADDRESS,
                        LocationDataTable.LOCATION_ACCURACY, LocationDataTable.LOCATION_DATE_TIME},
                LocationDataTable.LOCATION_ID+"="+ id, null, null, null,LocationDataTable.LOCATION_DATE_TIME , null);
        if(c != null){
            c.moveToFirst();
            locationObject = this.buildLocationObjectFromCursor(c);
        }

        if(!c.isClosed()){
            c.close();
        }
        return locationObject;
    }

    public List<LocationObject> getAll(){
        List<LocationObject> list = new ArrayList<LocationObject>();
        Cursor c = db.query(LocationDataTable.TABLE_NAME,
                new String[]{LocationDataTable.LOCATION_ID, LocationDataTable.LOCATION_LAT,
                        LocationDataTable.LOCATION_LONG, LocationDataTable.LOCATION_GEO_ADDRESS,
                        LocationDataTable.LOCATION_ACCURACY, LocationDataTable.LOCATION_DATE_TIME},
                null, null, null, null, null);
        if(c != null){
            c.moveToFirst();
            do{
                LocationObject locationObject = this.buildLocationObjectFromCursor(c);
                if(locationObject != null){
                    list.add(locationObject);
                }
            } while(c.moveToNext());

            if(!c.isClosed()){
                c.close();
            }
        }
        return list;
    }

    private LocationObject buildLocationObjectFromCursor(Cursor c){
        LocationObject locationObject = null;
        if(c != null){
            locationObject = new LocationObject();
            locationObject.setId(c.getLong(0));
            locationObject.setLocation_lat(c.getDouble(1));
            locationObject.setLocation_long(c.getDouble(2));
            locationObject.setGeo_address(c.getString(3));
            locationObject.setAccuracy(c.getDouble(4));
            locationObject.setLocation_date_time(c.getString(5));
        }
        return locationObject;
    }
}
