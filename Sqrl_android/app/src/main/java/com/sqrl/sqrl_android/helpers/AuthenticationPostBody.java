package com.sqrl.sqrl_android.helpers;

import com.sqrl.sqrl_android.interfaces.NameValueBase64;

/**
 * Create the post body for an authentication request to the server given the
 * client, server, and urs values. It will automatically create the ids and pids
 *
 * Created by sb on 4/17/2016.
 */
public class AuthenticationPostBody {

    private NameValueBase64 client;
    private NameValueBase64 server;
    private NameValueBase64 ids;
    private NameValueBase64 pids;
    private NameValueBase64 urs;

    AuthenticationPostBody( NameValueBase64 client,
                            NameValueBase64 server,
                            NameValueBase64 urs) {

        this.client = client;
        this.server = server;
        this.urs = urs;
        ids = new NameValueBase64("ids", "") {};
        pids = new NameValueBase64("pids", "") {};
    }
}
