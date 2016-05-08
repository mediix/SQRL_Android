package com.sqrl.sqrl_android.data;

import android.support.test.runner.AndroidJUnit4;
import com.sqrl.sqrl_android.interfaces.NameValueBase64;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)

public class ClientInfoParamTest {

    @Test
    public void testClientInfoParamInit() {
        ClientInfoParam testee = new ClientInfoParam("ver", "cmd", "idk", "pidk", "suk", "vuk");

        assertEquals("client={dmVyPXtkbVZ5fQ0KY21kPXtZMjFrfQ0KaWRrPXthV1JyfQ0KcGlkaz17Y0dsa2F3fQ0Kc3VrPXtjM1ZyfQ0KdnVrPXtkblZyfQ}", testee.getNameValueBase64url());
    }
}
