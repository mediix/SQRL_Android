package com.sqrl.sqrl_android.helpers;

import org.json.JSONException;
import org.json.JSONObject;

import android.support.test.runner.AndroidJUnit4;
import com.sqrl.sqrl_android.data.ClientInfoParam;
import com.sqrl.sqrl_android.interfaces.NameValueBase64;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)

public class AuthenticationPostBodyTest {

    @Test
    public void testClientInfoParamInit() {

        ClientInfoParam clientData = new ClientInfoParam("ver", "cmd", "idk", "pidk", "suk", "vuk");
        AuthenticationPostBody testee = new AuthenticationPostBody(clientData, "server", "ids", "pids", "urs");

        JSONObject jsData = new JSONObject();
        try {
            jsData.put("client", "dmVyPXtkbVZ5fQ0KY21kPXtZMjFrfQ0KaWRrPXthV1JyfQ0KcGlkaz17Y0dsa2F3fQ0Kc3VrPXtjM1ZyfQ0KdnVrPXtkblZyfQ");
            jsData.put("server", "c2VydmVy");
            jsData.put("ids", "aWRz");
            jsData.put("pids", "cGlkcw");
            jsData.put("urs", "dXJz");
        }catch (JSONException e) {
            e.printStackTrace();
        }

        // TODO: do better comparison since objects are not gauranteed to come out in the same order
        assertEquals(jsData.toString(), testee.getJsonObject().toString());
    }
}