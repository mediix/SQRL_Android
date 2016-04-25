package com.sqrl.sqrl_android.activities;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sqrl.sqrl_android.R;
import com.sqrl.sqrl_android.helpers.DatabaseHelper;


public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button register = (Button) findViewById(R.id.commitRegisterButton);

        final EditText fname = (EditText) findViewById(R.id.firstNameTextBox);
        final EditText lname = (EditText) findViewById(R.id.lastNameTextBox);
        final EditText pword = (EditText) findViewById(R.id.passwordTextBox);
        EditText cpword = (EditText) findViewById(R.id.confirmPasswordTextBox);

        final String fnameTask = fname.getText().toString();
        final String lnameTask = lname.getText().toString();
        final String pwordTask = pword.getText().toString();


        register.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                fname.setText(fnameTask);
                lname.setText(lnameTask);
                pword.setText(pwordTask);
                myDb.addUserFirstName(fname,lname,pword);
                //myDb.addUserLastName(lname);
                //myDb.addUserPassword(pword);
                myDb = new DatabaseHelper(this, null, null, 1);
                // context:this, dbName: Users.db, Cursorfactory:factory, version:1
                //printDatabase();
            }
        });



    }




}