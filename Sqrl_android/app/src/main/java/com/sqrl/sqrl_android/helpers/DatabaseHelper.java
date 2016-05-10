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

        public static final String TABLE_USERS = "USERS";
        public static final String COLUMN_ID = "_ID";
        public static final String COLUMN_FIRSTNAME = "FIRST_NAME";
        public static final String COLUMN_LASTNAME = "LAST_NAME";
        public static final String COLUMN_PASSWORD = "PASSWORD";
        public static final String COLUMN_SALT = "SALT";
        public static final String COLUMN_OPSLIMIT = "OPSLIMIT";
        public static final String COLUMN_MEMLIMIT = "MEMLIMIT";
        public static final String COLUMN_IMK = "IMK";

        private static final String DB_NAME = "Database.db";
        private static final int DB_VERSION = 4;
        private static final String DB_CREATE =
               // "CREATE TABLE " + TABLE_USERS + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                //COLUMN_FIRSTNAME + " TEXT)";
                "CREATE TABLE " + TABLE_USERS + "(" +
                                COLUMN_ID + " INTEGER PRIMARY KEY, " +
                                COLUMN_FIRSTNAME + " TEXT, " +
                                COLUMN_LASTNAME + " TEXT," +
                                COLUMN_PASSWORD + " TEXT)";
//                                COLUMN_PASSWORD + " TEXT, " +
//                                COLUMN_SALT + " TEXT, " +
//                                COLUMN_OPSLIMIT + " TEXT, " +
//                                COLUMN_MEMLIMIT + " TEXT)";
        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_USERS;

        public static String[] projectionPassword = {
                COLUMN_PASSWORD
                //COLUMN_SALT,
                //COLUMN_OPSLIMIT,
                //COLUMN_MEMLIMIT
        };



        public DatabaseHelper(Context context) {

            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
             db.execSQL(DB_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
        }
    }











/*private static final int DATABASE_VERSION = 1;
private static final String DATABASE_NAME = "Users.db";
public static final String TABLE_NAME = "users";
public static final String COL_1 = "id";
public static final String COL_2 = "firstName";
public static final String COL_3 = "lastName";
public static final String COL_4 = "password";


    /*public DatabaseHelper(View.OnClickListener context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super((Context) context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        db = this.getWritableDatabase();
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
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
    }*/