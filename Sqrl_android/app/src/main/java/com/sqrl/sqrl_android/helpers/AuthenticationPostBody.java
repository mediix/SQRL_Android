package com.sqrl.sqrl_android.helpers;

import com.sqrl.sqrl_android.interfaces.NameValueBase64;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Create the post body for an authentication request to the server given the
 * client, server, and urs values. It will automatically create the ids and pids
 *
 * Created by sb on 4/17/2016.
 */
public class AuthenticationPostBody {

    private NameValueBase64 client;
    public NameValueBase64 server;
    public NameValueBase64 ids;
    private NameValueBase64 pids;
    private NameValueBase64 urs;

    public AuthenticationPostBody( NameValueBase64 client,
                            String server,
                            String ids,
                            String pids,
                            String urs) {

        this.client = client;
        this.server = new NameValueBase64("server", server){};
        this.ids = new NameValueBase64("ids", ids){};
        this.pids = new NameValueBase64("pids", pids){};
        this.urs = new NameValueBase64("urs", urs){};

    }

    public JSONObject getJsonObject() {
        JSONObject jsData = new JSONObject();
        try {
            jsData.put(client.getName(), client.getValueBase64url());
            jsData.put(server.getName(), server.getValueBase64url());
            jsData.put(ids.getName(), ids.getValueBase64url());
            jsData.put(pids.getName(), pids.getValueBase64url());
            jsData.put(urs.getName(), urs.getValueBase64url());
        }catch (JSONException e) {
            e.printStackTrace();
        }

        return jsData;
    }
}
