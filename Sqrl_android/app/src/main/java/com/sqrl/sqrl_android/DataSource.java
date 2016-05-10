package com.sqrl.sqrl_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
        values.put(DatabaseHelper.COLUMN_LASTNAME,user.getLastName());
        values.put(DatabaseHelper.COLUMN_PASSWORD,user.getPassword());
        values.put(DatabaseHelper.COLUMN_IMK,user.getImk());
        values.put(DatabaseHelper.COLUMN_SALT,user.getSalt());
        values.put(DatabaseHelper.COLUMN_OPSLIMIT,user.getOpsLimit());
        values.put(DatabaseHelper.COLUMN_MEMLIMIT,user.getMemLimit());
        mDatabase.insert(DatabaseHelper.TABLE_USERS, null, values);

    }

    //select
    public Cursor getUserPassByFname(String fname) {
        String[] fnameArg = new String[1];
        fnameArg[0] = fname;

        return mDatabase.query(
            DatabaseHelper.TABLE_USERS,
            DatabaseHelper.projectionPassword,
            DatabaseHelper.COLUMN_FIRSTNAME + " = '" + fname +"'",
            null,
            null,
            null,
            null
        );

    }

    //update

    //delete
}
