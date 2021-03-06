package com.sqrl.sqrl_android;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import  java.sql.SQLException;


public class RegisterActivity extends AppCompatActivity {

    protected  DataSource mDataSource;


    @Override
    protected void onPause() {
        super.onPause();
        mDataSource.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
         Button register = (Button) findViewById(R.id.commitRegisterButton);
         final EditText fname = (EditText) findViewById(R.id.firstNameTextBox);
         final EditText lname = (EditText) findViewById(R.id.lastNameTextBox);
         final EditText pword = (EditText) findViewById(R.id.passwordTextBox);



        mDataSource = new DataSource(RegisterActivity.this);
        try {
            mDataSource.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        register.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Intent myintent = new Intent(getApplicationContext(),MainActivity.class);
                Intent myintent = new Intent(getApplicationContext(),com.sqrl.sqrl_android.activities.MainActivity.class);
                startActivity((myintent));

                User newUser = new User();
                newUser.setFirstName(fname.toString());
                newUser.setLastName(lname.toString());
                newUser.setPassword(pword.toString());

                mDataSource.insertUser(newUser);
            }


        });




    }

}






