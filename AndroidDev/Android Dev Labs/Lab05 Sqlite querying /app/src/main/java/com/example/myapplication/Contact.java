package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;


public class Contact {

    private String user;
    private String phone_number;
    static DbHelper helper;

    public Contact(String user, String phone_number, Context context) {
        this.user = user;
        this.phone_number = phone_number;
        helper=new DbHelper(context);
    }

    public Contact(){

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public long persist() throws Exception{
        ContentValues values=new ContentValues();
        values.put(dbcontract.FIELD_1,this.user);
        values.put(dbcontract.FIELD_2,this.phone_number);
        SQLiteDatabase db=helper.getWritableDatabase();
        long result=db.insert(dbcontract.TABLE_NAME,null,values);
        db.close();
        if(result == -1){
            throw new Exception("Insert Failed!");
        }
        return result;
    }

    static public ArrayList<Contact> getAllContacts(Context context){
        DbHelper helper=new DbHelper(context);
        ArrayList<Contact> contacts=new ArrayList<>();
        SQLiteDatabase db= helper.getReadableDatabase();
        Cursor results = db.query(dbcontract.TABLE_NAME,null,null,null,null,null,null);
        if(results.moveToFirst()){
            do{
                contacts.add(new Contact(results.getString(0),results.getString(1),null));
            }while (results.moveToNext());
        }
        return contacts;
    }
}