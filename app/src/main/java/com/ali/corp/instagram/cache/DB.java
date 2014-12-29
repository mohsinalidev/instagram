//package com.ali.corp.viewpager;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
///**
//* Created by ali on 9/9/2014.
//*/
//public class DB extends SQLiteOpenHelper {
//    public static final String DBNAME="instagram";
//    public static final String TABLE_RESPONCE="endpoint_response";
//    public static final int VERSION=4;
//    public static final String ID="_id";
//    public static final String IMAGE_SMALL_URL="imageSamllUrl";
//    public static final String IMAGE_MED_URL="imageMedUrl";
//    public static final String IMAGE_STD_URL="imageStdUrl";
//
//    public DB(Context context) {
//        super(context, DBNAME, null, VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String sqlcreat= "CREATE TABLE IF NOT EXISTS "+
//                TABLE_RESPONCE+"("+
//                ID+ " INTEGER PRIMARY KEY,"+
//                IMAGE_SMALL_URL+" TEXT,"+
//                IMAGE_MED_URL+" TEXT,"+
//                IMAGE_STD_URL+" TEXT,"+
//                "UNIQUE("+IMAGE_SMALL_URL+")"+");";
//        db.execSQL(sqlcreat);
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
//        db.execSQL("DROP TABLE IF EXISTS "+TABLE_RESPONCE);
//        this.onCreate(db);
//
//    }

//}
//
//

///*    @Override
//    public void onCreate(SQLiteDatabase sqLiteDatabase, com.j256.ormlite.support.ConnectionSource connectionSource) {
//        String sqlcreat= "CREATE TABLE IF NOT EXISTS "+
//                TABLE_RESPONCE+"("+
//                ID+ " INTEGER PRIMARY KEY,"+
//                IMAGE_SMALL_URL+" TEXT,"+
//                IMAGE_MED_URL+" TEXT,"+
//                IMAGE_STD_URL+" TEXT);";
//        sqLiteDatabase.execSQL(sqlcreat);
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase sqLiteDatabase, com.j256.ormlite.support.ConnectionSource connectionSource, int i, int i2) {
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_RESPONCE);
//        this.onCreate(sqLiteDatabase);
//    }*/