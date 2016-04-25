package com.sqrl.sqrl_android.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import  android.support.v7.app.AppCompatActivity;

import java.sql.Struct;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Users.db";
    public static final String TABLE_NAME = "users";
    public static final String COL_1 = "id";
    public static final String COL_2 = "firstName";
    public static final String COL_3 = "lastName";
    public static final String COL_4 = "password";


    public DatabaseHelper(View.OnClickListener context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super((Context) context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                COL_1 + " INTEGER PRIMARY KEY AUTO_INCREMENT " +
                COL_2 + " TEXT " +
                COL_3 + " TEXT " +
                COL_4 + " TEXT " +
                ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }

    //ADD A NEW ROW TO THE DATABASE
    public void addUserFirstName(EditText user, EditText last, EditText pass) {
        ContentValues values = new ContentValues();
        values.put(COL_2, String.valueOf(user));
        values.put(COL_3, String.valueOf(last));
        values.put(COL_4, String.valueOf(pass));

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    /*public void addUserLastName(EditText user){
        ContentValues values = new ContentValues();
        values.put(COL_3,String.valueOf(user));
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public void addUserPassword(EditText user){
        ContentValues values = new ContentValues();
        values.put(COL_4 ,String.valueOf(user));
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    //DELETE USER FROM DATABASE
    public  void deleteUser(String userName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COL_2 + "=\"" + userName + "\";");
    }

    //PRINT OUT DATABASE AS A STRING
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE 1";

        //cursor point to a location in your results
        Cursor c = db.rawQuery(query, null);
        //move to first row in your results
        c.moveToFirst();

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("firstname")) != null){
                dbString += c.getString(c.getColumnIndex("firstname"));
                dbString += "\n";
            }
        }
        db.close();
        return dbString;
    }

}*/
}
