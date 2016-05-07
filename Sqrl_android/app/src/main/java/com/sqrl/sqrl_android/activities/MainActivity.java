package com.sqrl.sqrl_android.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sqrl.sqrl_android.LogInActivity;
import com.sqrl.sqrl_android.OpeningScreenActivity;
import com.sqrl.sqrl_android.R;
import com.sqrl.sqrl_android.RegisterActivity;
import com.sqrl.sqrl_android.data.ClientInfoParam;
import com.sqrl.sqrl_android.helpers.AuthenticationPostBody;
import com.sqrl.sqrl_android.helpers.BytesToHex;
import com.sqrl.sqrl_android.interfaces.NameValueBase64;

import org.abstractj.kalium.NaCl;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button SignInButton = (Button) findViewById(R.id.sign_in);
        Button RegisterButton = (Button) findViewById(R.id.register_button);
        Button TestButton = (Button) findViewById(R.id.test_button);

        RegisterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(myintent);
            }
        });
        SignInButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), LogInActivity.class);
                startActivity(myintent);
            }
        });

        TestButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                testFunc();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean testFunc() {

        ClientInfoParam client = new ClientInfoParam("ver", "cmd", "idk", "pidk", "suk", "vuk");
        AuthenticationPostBody postData = new AuthenticationPostBody(client, "server", "ids", "pids", "urs");

        // Needed data
        byte[] imk = new byte[32]; NaCl.sodium().randombytes(imk, 32); Log.d("Test", "imk:" + new BytesToHex().bytesToHex(imk) );
        byte[] salt = new byte[8]; NaCl.sodium().randombytes(salt, 8); Log.d("Test", "salt:" + new BytesToHex().bytesToHex(salt));
        int opsLimit = 100000;
        long memsLimit = 512000;
        String userPassword = "password";

        byte[] mixKey = new byte[32];

        // mixKey
        Log.d("Test", "Crypto start hash");
        NaCl.sodium().crypto_pwhash_scryptsalsa208sha256(mixKey, 32, userPassword.getBytes(), userPassword.length(), salt, opsLimit, memsLimit);
        Log.d("Test", "Crypto end hash");
        Log.d("Test", "mixKey:" + new BytesToHex().bytesToHex(mixKey) );

        // create the derived IMK
        byte[] dImk = new byte[32];
        int i = 0;
        for(byte b : mixKey)
            dImk[i] = (byte) (imk[i] ^ mixKey[i++]);

        Log.d("Test", "dimk:" + new BytesToHex().bytesToHex(dImk) );

        // create the password verifier
        byte[] pwHash = new byte[32];
        byte[] pwVerifier = new byte[16];
        NaCl.sodium().crypto_hash_sha256(pwHash, mixKey, 32);
        i = 0;
        for(byte b: pwVerifier)
            pwVerifier[i] = pwHash[i++];
        Log.d("Test", "Verifier:" + new BytesToHex().bytesToHex(pwVerifier) );


        // WIC-1
        String website = "www.example.com";

        // WIC-2, WIC-4 create the pk and sk
        byte[] sk = new byte[32];
        byte[] pk = new byte[32];
        NaCl.sodium().crypto_sign_ed25519_seed_keypair(pk, sk, imk);
        Log.d("Test", "SK:" + new BytesToHex().bytesToHex(sk));
        Log.d("Test", "PK:" + new BytesToHex().bytesToHex(pk) );

        // TUL-5
        String msgTosign = client.getValueBase64url() + postData.server.getNameValueBase64url();
        NaCl.sodium().crypto_sign_ed25519();

        return true;
    }


}
