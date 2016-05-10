package com.sqrl.sqrl_android;


import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sqrl.sqrl_android.activities.MainActivity;
import com.sqrl.sqrl_android.helpers.BytesToHex;

import org.abstractj.kalium.NaCl;

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
                Intent myintent = new Intent(getApplicationContext(),MainActivity.class);

                User newUser = new User();

                // User first name and last name
                newUser.setFirstName(fname.getText().toString());
                newUser.setLastName(lname.getText().toString());

                // Ops limit and Mem Limit
                Integer opsLimit = 100000;
                Integer memLimit = 512000;
                newUser.setOpsLimit(opsLimit);
                newUser.setMemLimit(memLimit);

                // Salt
                byte[] salt = new byte[8];
                NaCl.sodium().randombytes(salt, 8);
                newUser.setSalt(salt);
                Log.d("DBG-Reg", "Salt:" + new BytesToHex().bytesToHex(salt));

                // Password hashing and verifier
                byte[] mixKey = new byte[32];
                String pword2 = pword.getText().toString();

                NaCl.sodium().crypto_pwhash_scryptsalsa208sha256(mixKey, 32, pword2.getBytes(), pword2.length(), salt, opsLimit, memLimit);
                Log.d("DBG-Reg", "mixKey:" + new BytesToHex().bytesToHex(mixKey));

                byte[] pwHash = new byte[32];
                byte[] pwVerifier = new byte[16];
                NaCl.sodium().crypto_hash_sha256(pwHash, mixKey, 32);
                int j = 0;
                for(byte b: pwVerifier)
                    pwVerifier[j] = pwHash[j++];
                newUser.setPassword(pwVerifier);
                Log.d("DBG-Reg", "PW Verifies:" + new BytesToHex().bytesToHex(pwVerifier));

                //Imk
                byte[] imk = new byte[32];
                byte[] dImk = new byte[32];
                NaCl.sodium().randombytes(imk, 32);
                int i = 0;
                for(byte b: mixKey)
                    dImk[i] = (byte) (imk[i] ^ mixKey[i++]);
                newUser.setImk(dImk);

                mDataSource.insertUser(newUser);
                startActivity((myintent));
            }


        });




    }

}






