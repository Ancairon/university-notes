package com.example.sqliteapplication;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ContactsProvider extends ContentProvider {

    private UriMatcher uriMatcher;
    private DbHelper dbHelper;
    @Override
    public boolean onCreate() {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(dbcontract.AUTHORITY,dbcontract.PATH,1);
        uriMatcher.addURI(dbcontract.AUTHORITY,dbcontract.PATH+"/#",2);
        dbHelper=new DbHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        Cursor cursor=null;
        switch (uriMatcher.match(uri)){
            case 1:
                cursor = db.query(dbcontract.TABLE_NAME,null,null,null,null,null,null);
                break;

            case 2:
                String id=uri.getLastPathSegment();
                cursor=db.query(dbcontract.TABLE_NAME,null,"ROWID=?",new String[]{id},null,null,null);
                //SELECT * FROM CONTACTS WHERE ROW_ID=?
        }
        return cursor;

    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
