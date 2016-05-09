package com.sqrl.sqrl_android;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.SQLException;

/**
 * Created by ernes_000 on 4/14/2016.
 */
public class LogInActivity extends AppCompatActivity {

    protected  DataSource mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final EditText fname = (EditText) findViewById(R.id.loginUsernameText);
        final EditText password = (EditText) findViewById(R.id.loginPasswordText);

        setContentView(R.layout.activity_login);
        Button logInButton = (Button) findViewById(R.id.commitLogInButton);

//        logInButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myintent = new Intent(getApplicationContext(),OpeningScreenActivity.class);
//                startActivity(myintent);
//            }
//        });

//        mDataSource = new DataSource(LogInActivity.this);
//        try {
//            mDataSource.open();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = fname.getText().toString();
                String pass = password.getText().toString();
                verifyUser(name, pass);
            }
        });
    }

    public void verifyUser(String name, String pass) {
        Cursor c = mDataSource.getUserPassByFname(name);
        c.moveToFirst();

        


    }
}
