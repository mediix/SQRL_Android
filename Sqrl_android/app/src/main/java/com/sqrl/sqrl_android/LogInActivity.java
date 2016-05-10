package com.sqrl.sqrl_android;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sqrl.sqrl_android.helpers.DatabaseHelper;

import java.sql.SQLException;

/**
 * Created by ernes_000 on 4/14/2016.
 */
public class LogInActivity extends AppCompatActivity {

    protected  DataSource mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        Button logInButton = (Button) findViewById(R.id.commitLogInButton);

        final EditText fname = (EditText) findViewById(R.id.loginUsernameText);
        final EditText password = (EditText) findViewById(R.id.loginPasswordText);

//        logInButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myintent = new Intent(getApplicationContext(),OpeningScreenActivity.class);
//                startActivity(myintent);
//            }
//        });

        mDataSource = new DataSource(LogInActivity.this);
        try {
            mDataSource.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = fname.getText().toString();
                String pass = password.getText().toString();

                Log.d("DBG-Login", "Username: " + name);
                Log.d("DBG-Login", "Password: " + pass);

                verifyUser(name, pass);
            }
        });
    }

    public void verifyUser(String name, String pass) {

        mDataSource.getUserPassByFname(name);
        Cursor c = mDataSource.getUserPassByFname(name);


        c.moveToFirst();

        // make sure user exists
        if(c.getCount() == 0) {
            Log.d("DBG-Login", "not found");
            showAlertDialog("Incorrect username or password");
            return;
        }

        String dbPassword = c.getString(c.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PASSWORD));
        Log.d("DBG-Login", "Queried Password is: " + dbPassword);

        if(dbPassword.equals(pass) ) {
            // user and password passed
            Intent myintent = new Intent(getApplicationContext(),OpeningScreenActivity.class);
            startActivity(myintent);
        } else {
            Log.d("DBG-Login", "bad password");
            showAlertDialog("Incorrect username or password");
        }

    }

    private void showAlertDialog(String message) {

        new AlertDialog.Builder(this)
                .setTitle(getResources().getString(R.string.app_name))
                .setCancelable(false)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })

                .show();
    }
}
