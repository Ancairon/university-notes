package com.example.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    DbHelper dbHelper= new DbHelper(MainActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText nameBox= findViewById(R.id.NameBox);
        EditText phoneNoBox=findViewById(R.id.PhoneNoBox);

        Button button = findViewById(R.id.button);


        Button contentButton=findViewById(R.id.button3);

        contentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentResolver resolver=getContentResolver();
                Uri uri=Uri.parse("content://"+dbcontract.AUTHORITY+"/"+dbcontract.PATH);
                Cursor cursor = resolver.query(uri,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do {
                        Log.d("Cursor", cursor.getString(0));
                    }while (cursor.moveToNext());
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact contact = new Contact(nameBox.getText().toString(),phoneNoBox.getText().toString(),MainActivity.this);
                long rowid= 0;
                try {
                    rowid = contact.persist();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(rowid==-1){
                    Log.e("SQL", "onClick: INSERTION ERROR");
                }
                else {
                    Log.d("SQL","Row added, rowid: "+rowid);
                }
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                Toast.makeText(MainActivity.this, " " + Contact.getAllContacts(MainActivity.this).get(0).getUser(), Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelper.close();
    }
}