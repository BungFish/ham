package com.skn.ham;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;

/**
 * Created by Young-Jin on 2016-03-14.
 */
public class StationContentProvider extends ContentProvider {

    private GasStationDBHelper dbHelper;

    private static final int ALL_STATION = 1;
    private static final int SINGLE_STATION = 2;

    // authority is the symbolic name of your provider
    // To avoid conflicts with other providers, you should use
    // Internet domain ownership (in reverse) as the basis of your provider authority.
    private static final String AUTHORITY = "com.skn.ham";

    // create content URIs from the authority by appending path to database table
    public static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY + "/countries");

    // a content URI pattern matches content URIs using wildcard characters:
    // *: Matches a string of any valid characters of any length.
    // #: Matches a string of numeric characters of any length.
        private static final UriMatcher uriMatcher;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, "countries", ALL_STATION);
        uriMatcher.addURI(AUTHORITY, "countries/#", SINGLE_STATION);
    }

    // system calls onCreate() when it starts up the provider.
    @Override
    public boolean onCreate() {
        // get access to the database helper
        dbHelper = new GasStationDBHelper(getContext());
        return false;
    }

    //Return the MIME type corresponding to a content URI
    @Override
    public String getType(Uri uri) {

//        switch (uriMatcher.match(uri)) {
//            case ALL_STATION:
//                return "vnd.android.cursor.dir/vnd.com.as400samplecode.contentprovider.countries";
//            case SINGLE_COUNTRY:
//                return "vnd.android.cursor.item/vnd.com.as400samplecode.contentprovider.countries";
//            default:
//                throw new IllegalArgumentException("Unsupported URI: " + uri);
//        }


        throw new IllegalArgumentException("Unsupported URI: " + uri);
    }

    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int insertCount = 0;

        switch (uriMatcher.match(uri)) {

            case ALL_STATION: {

                db.beginTransaction();
                try {

                    for (ContentValues value : values) {

                        //데이터를 추가할 때 이미 있는 데이터라도 새로운 값을 넣어줌 (추가 또는 수정)
                        long id = db.insertWithOnConflict(GasStationContract.TABLE_NAME, null, value, SQLiteDatabase.CONFLICT_REPLACE);

                        if (id != -1) insertCount++;
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }

                getContext().getContentResolver().notifyChange(uri, null);
                break;
            }
            default:
                return super.bulkInsert(uri, values);
        }

        return insertCount;
    }

    // The insert() method adds a new row to the appropriate table, using the values
    // in the ContentValues argument. If a column name is not in the ContentValues argument,
    // you may want to provide a default value for it either in your provider code or in
    // your database schema.
    @Override
    public Uri insert(Uri uri, ContentValues values) {
//
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        switch (uriMatcher.match(uri)) {
//            case ALL_STATION:
//                //do nothing
//                break;
//            default:
//                throw new IllegalArgumentException("Unsupported URI: " + uri);
//        }
//        long id = db.insert(CountriesDb.SQLITE_TABLE, null, values);
//        getContext().getContentResolver().notifyChange(uri, null);
//        return Uri.parse(CONTENT_URI + "/" + id);


        throw new IllegalArgumentException("Unsupported URI: " + uri);
    }

    // The query() method must return a Cursor object, or if it fails,
    // throw an Exception. If you are using an SQLite database as your data storage,
    // you can simply return the Cursor returned by one of the query() methods of the
    // SQLiteDatabase class. If the query does not match any rows, you should return a
    // Cursor instance whose getCount() method returns 0. You should return null only
    // if an internal error occurred during the query process.
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(GasStationContract.TABLE_NAME);

        switch (uriMatcher.match(uri)) {
            case ALL_STATION:
                //do nothing
                break;
            case SINGLE_STATION:
//                String id = uri.getPathSegments().get(1);
//                queryBuilder.appendWhere(CountriesDb.KEY_ROWID + "=" + id);
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }

        Cursor cursor = queryBuilder.query(db, projection, selection,
                selectionArgs, null, null, sortOrder);
        return cursor;

    }

    // The delete() method deletes rows based on the seletion or if an id is
    // provided then it deleted a single row. The methods returns the numbers
    // of records delete from the database. If you choose not to delete the data
    // physically then just update a flag here.
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        switch (uriMatcher.match(uri)) {
            case ALL_STATION:
                //do nothing
                break;
            case SINGLE_STATION:
//                String id = uri.getPathSegments().get(1);
//                selection = CountriesDb.KEY_ROWID + "=" + id
//                        + (!TextUtils.isEmpty(selection) ?
//                        " AND (" + selection + ')' : "");
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }

        int deleteCount = db.delete(GasStationContract.TABLE_NAME, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return deleteCount;
    }

    // The update method() is same as delete() which updates multiple rows
    // based on the selection or a single row if the row id is provided. The
    // update method returns the number of updated rows.
    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        switch (uriMatcher.match(uri)) {
//            case ALL_STATION:
//                //do nothing
//                break;
//            case SINGLE_COUNTRY:
//                String id = uri.getPathSegments().get(1);
//                selection = CountriesDb.KEY_ROWID + "=" + id
//                        + (!TextUtils.isEmpty(selection) ?
//                        " AND (" + selection + ')' : "");
//                break;
//            default:
//                throw new IllegalArgumentException("Unsupported URI: " + uri);
//        }
//        int updateCount = db.update(CountriesDb.SQLITE_TABLE, values, selection, selectionArgs);
//        getContext().getContentResolver().notifyChange(uri, null);
//        return updateCount;

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int rowUpdated = 0;

        switch (uriMatcher.match(uri)) {

            case ALL_STATION: {

                rowUpdated = db.update(GasStationContract.TABLE_NAME, values, selection, selectionArgs);
                getContext().getContentResolver().notifyChange(uri, null);
                return rowUpdated;

            }
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }

    }

}
