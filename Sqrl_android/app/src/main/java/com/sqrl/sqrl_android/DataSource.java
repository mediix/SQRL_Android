package com.sqrl.sqrl_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import com.sqrl.sqrl_android.helpers.DatabaseHelper;

import java.sql.SQLException;

/**
 * Created by ernes_000 on 4/10/2016.
 */
public class DataSource {

    private SQLiteDatabase mDatabase;
    private DatabaseHelper mDatabaseHelper;
    private Context mContext;


    public DataSource(Context context) {

        mContext = context;
        mDatabaseHelper = new DatabaseHelper(mContext);
    }

    //open
    public void open() throws SQLException {
        mDatabase = mDatabaseHelper.getWritableDatabase();
    }

    //close
    public void close(){
        mDatabase.close();
    }

    //insert
    public void insertUser(User user){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_FIRSTNAME,user.getFirstName());
        mDatabase.insert(DatabaseHelper.TABLE_USERS,null,values);
    }


    //select

    //update

    //delete
}
