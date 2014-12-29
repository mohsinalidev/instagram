//package com.ali.corp.viewpager;
//
//import android.content.ContentProvider;
//import android.content.ContentUris;
//import android.content.ContentValues;
//import android.content.UriMatcher;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.net.Uri;
//import android.util.Log;
//
//public class ContentProviderInstagram extends ContentProvider {
//
//    public static final String AUTHORITY = "com.ali.instagram1";
//    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + DB.TABLE_RESPONCE);
//
//    public static final int ITEM_QUERY = 1;
//    public static final int DIR_QUERY = 2;
//    public static final UriMatcher uriMatcher;
//    static {
//        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
//        uriMatcher.addURI(AUTHORITY, DB.TABLE_RESPONCE, DIR_QUERY);
//        uriMatcher.addURI(AUTHORITY, DB.TABLE_RESPONCE + "/#", ITEM_QUERY);
//    }
//
//    private DB mdb;
//    public ContentProviderInstagram() {
//    }
//
//    @Override
//    public int delete(Uri uri, String selection, String[] selectionArgs) {
//        // Implement this to handle requests to delete one or more rows.
//        SQLiteDatabase wdb=mdb.getWritableDatabase();
//       int deleted=wdb.delete(DB.TABLE_RESPONCE,null,null);
//
//       return deleted;
//    }
//
//    @Override
//    public String getType(Uri uri) {
//        switch (uriMatcher.match(uri)) {
//            case (ITEM_QUERY):
//                return ("vnd.android.cursor.item/vnd.ali.Image");
//            case (DIR_QUERY):
//                return ("vnd.android.cursor.dir/vnd.ali.Images");
//            default:
//                throw new UnsupportedOperationException("Not yet implemented");
//        }
//    }
//
//    @Override
//    public Uri insert(Uri uri, ContentValues values) {
//
//        SQLiteDatabase wdb = mdb.getWritableDatabase();
//        Log.i("aaaa", values.toString());
//        Long result = wdb.insertWithOnConflict(DB.TABLE_RESPONCE, null, values, SQLiteDatabase.CONFLICT_IGNORE);
//        if (result > 0) {
//            Uri uri_result = ContentUris.withAppendedId(CONTENT_URI, result);
//            getContext().getContentResolver().notifyChange(uri_result, null);
//            return uri_result;
//        }
////        else {
////            throw new UnsupportedOperationException("Not yet implemented");        }
//        return null;
//    }
//
//    @Override
//    public boolean onCreate() {
//        mdb = new DB(getContext());
//        return true;
//    }
//
//    @Override
//    public Cursor query(Uri uri, String[] projection, String selection,
//            String[] selectionArgs, String sortOrder) {
//        SQLiteDatabase rdb = mdb.getReadableDatabase();
//        switch (uriMatcher.match(uri)) {
//            case DIR_QUERY:
//                Cursor dir_result = rdb.query(DB.TABLE_RESPONCE, projection, selection, selectionArgs, null, null, "_id DESC");
//                return dir_result;
//            case ITEM_QUERY:
//                long id = ContentUris.parseId(uri);
//                String where = " _id=" + id;
//                Cursor item_result = rdb.query(DB.TABLE_RESPONCE, projection, where, selectionArgs, null, null, sortOrder);
//                return item_result;
//            default:
//                throw new UnsupportedOperationException("Not yet implemented");
//        }
//    }
//
//    @Override
//    public int update(Uri uri, ContentValues values, String selection,
//            String[] selectionArgs) {
//        // TODO: Implement this to handle requests to update one or more rows.
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
//}
