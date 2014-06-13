package com.trnkarthik.locationtracking.locationtracking.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Created by karthiktangirala on 6/11/14.
 */
public class LocationDataManager {
    Context mContext;
    LocationDBHelper dbOpenHelper;
    SQLiteDatabase db;
    LocationDAO locationDAO;

    public LocationDataManager(Context mContext){
        this.mContext = mContext;
        dbOpenHelper = new LocationDBHelper(mContext);
        db = dbOpenHelper.getWritableDatabase();
        locationDAO = new LocationDAO(db);
    }

    public void close(){
        db.close();
    }

    public long saveLocationObject(LocationObject locationObject){
        return locationDAO.save(locationObject);
    }

    public boolean updateLocationObject(LocationObject locationObject){
        return locationDAO.update(locationObject);
    }

    public boolean deleteLocationObject(LocationObject locationObject){
        return locationDAO.delete(locationObject);
    }

    public LocationObject getLocationObject(long id){
        return locationDAO.get(id);
    }

    public List<LocationObject> getAllLocationObjects(){
        return locationDAO.getAll();
    }
}