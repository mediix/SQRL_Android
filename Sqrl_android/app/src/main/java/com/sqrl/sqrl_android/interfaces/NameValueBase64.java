package com.sqrl.sqrl_android.interfaces;

import android.util.Base64;
import android.util.Log;

import java.util.jar.Attributes;

/**
 * Created by sb on 4/17/2016.
 */
public abstract class NameValueBase64 {
    private String name = "";
    private String value = "";

    public NameValueBase64(String name, String value) {this.name=name; this.value=value;}

    public String getName() {return name;}

    public String setValue(String value) {return this.value = value;}

    public String getValue() {return value;}

    public String getValueBase64url() {
            String output = Base64.encodeToString(value.getBytes(), Base64.URL_SAFE | Base64.NO_WRAP | Base64.NO_PADDING);
            return output;
    }

    /**
     *
     * @return return name={base64url(value)}
     */
    public String getNameValueBase64url() {
        return name+"={"+getValueBase64url()+"}";
    }

}
