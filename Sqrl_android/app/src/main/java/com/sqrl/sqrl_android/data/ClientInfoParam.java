package com.sqrl.sqrl_android.data;

import android.util.Base64;

import com.sqrl.sqrl_android.interfaces.NameValueBase64;

/**
 * This class will handle the "client" set of parameters needed for SQRL when the client
 * sends an authentication request
 *
 * The data is in the form of name=value pairs separated by a <CR,LF>
 *  ver=1<CR,LF>
 *  cmd=setkey|setlock|create|login<CR,LF>
 *  idk={base64url encoded identity key}<CR,LF>
 *  pidk={base64url encoded previous identity key}<CR,LF>
 *  suk={base64url encoded server unlock key}<CR,LF>
 *  vuk={base64url encoded verify unlock key}<CR,LF>
 *
 *  The entire data can then be returned as base64url encoded
 *
 * Created by sb on 4/17/2016.
 */
public class ClientInfoParam extends NameValueBase64{

    private NameValueBase64 ver;
    private NameValueBase64 cmd;
    private NameValueBase64 idk;
    private NameValueBase64 pidk;
    private NameValueBase64 suk;
    private NameValueBase64 vuk;

    ClientInfoParam( String ver, String cmd, String idk, String pidk, String suk, String vuk) {
        super("client", "");    // allow instantiation of the client class,
                                // then fill in the data after initializing data

        this.ver = new NameValueBase64("ver", ver){};
        this.cmd = new NameValueBase64("ver", cmd) {};
        this.idk = new NameValueBase64("idk", idk) {};
        this.pidk = new NameValueBase64("pidk", pidk) {};
        this.suk = new NameValueBase64("suk", suk) {};
        this.vuk = new NameValueBase64("vuk", vuk) {};

        // set the true value for ClientInfoParam
        this.setValue(  this.ver.getNameValueBase64url()    + "\r\n" +
                        this.cmd.getNameValueBase64url()    + "\r\n" +
                        this.idk.getNameValueBase64url()    + "\r\n" +
                        this.pidk.getValueBase64url()       + "\r\n" +
                        this.suk.getValueBase64url()        + "\r\n" +
                        this.vuk.getNameValueBase64url()    );
    }
}
