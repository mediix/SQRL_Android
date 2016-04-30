package com.sqrl.sqrl_android;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

//import com.google.zxing.Result;


/**
 * Created by ernes_000 on 4/19/2016.
 */
public class OpeningScreenActivity extends AppCompatActivity {

    private static final int ACTIVITY_RESULT_QR_DRDROID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_openingscreen);
        Button scannerButton = (Button) findViewById(R.id.scan_button);


        scannerButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent("la.droid.qr.scan");

                    Intent intent = new Intent(v.getContext(), BarcodeScanner.class);
                    startActivity(intent);
            }
        });
    }




}

