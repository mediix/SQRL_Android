package com.sqrl.sqrl_android.data;

/**
 * This class will handle the "server" set of parameters needed for SQRL when the client
 * sends an authentication request
 *
 * Created by sb on 4/17/2016.
 */
public class ServerInfoParam {

    private String sqrlCode = "";

    ServerInfoParam(String sqrlCode) {
        this.sqrlCode = sqrlCode;
    }

    /**
     *
     * @param sqrlCode the scanned Sqrl QR Code
     */
    public void setSqrlCode(String sqrlCode) {
        this.sqrlCode = sqrlCode;
    }
    public String getSqrlCode() {
        return this.sqrlCode;
    }

}
