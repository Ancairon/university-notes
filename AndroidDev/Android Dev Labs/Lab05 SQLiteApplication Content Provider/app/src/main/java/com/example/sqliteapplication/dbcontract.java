package com.example.sqliteapplication;

public class dbcontract {

    static public String DB_NAME="CONTACTS_DB";
    static public int DB_VERSION=1;
    static public String TABLE_NAME="CONTACTS";
    static public String FIELD_1="NAME";
    static public String FIELD_2="PHONE_NUMBER";
    static public String CREATE_TABLE=("CREATE TABLE " + TABLE_NAME + " ('" + FIELD_1 + "' TEXT, '" + FIELD_2 + "' TEXT);");
    public static String AUTHORITY="com.example.sqliteapplication";
    public static String PATH=dbcontract.TABLE_NAME;
}
