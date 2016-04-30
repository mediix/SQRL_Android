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
                Intent myintent = new Intent(getApplicationContext(), OpeningScreenActivity.class);
                startActivity(myintent);
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

    public void httpSend(View vew) {
        //Test the Volley HTTP library to send data
        Log.d("http test", "http test button pressed");

        //Example preparing and sending client login request
        ClientInfoParam client = new ClientInfoParam("parver", "parcmd", "paridk", "parpidk", "parsuk", "parvuk");
        AuthenticationPostBody authData = new AuthenticationPostBody(client, "parserver", "parids", "parpids", "parurs");

        Log.d("main: ", "Client: "+ client.getValueBase64url());

        JSONObject authDataJson = authData.getJsonObject();

//        JSONObject authData = new JSONObject();

        RequestQueue queue = Volley.newRequestQueue(this);
//        String url ="https://2oc3yo4sj9.execute-api.us-west-2.amazonaws.com/dev/api/auth";
        String url = "http://putsreq.com/z6KTTHEz6bDCe0St4ZIF";

        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, url, authDataJson,
                new Response.Listener<JSONObject>() {
                    public void onResponse(JSONObject response) {
                        Log.d("Volley", "Response is: " + response);
                    }
                }, new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        Log.d("response err", "that didn't work!");
                    }
            }
        );

        queue.add(stringRequest);
    }
}
