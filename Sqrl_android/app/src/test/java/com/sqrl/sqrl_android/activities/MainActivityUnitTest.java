package com.sqrl.sqrl_android.activities;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;
import android.view.View;
import android.view.ViewStub;

import com.android.volley.RequestTest;
import com.android.volley.toolbox.Volley;
import com.sqrl.sqrl_android.R;
import com.sqrl.sqrl_android.data.ClientInfoParam;
import com.sqrl.sqrl_android.helpers.AuthenticationPostBody;

import org.junit.Test;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class MainActivityUnitTest {
    public MainActivityUnitTest() {
        MainActivity activity = new MainActivity();
        // test httpSend
        Context testContext;
        ClientInfoParam testClient = new ClientInfoParam("1", "cmd", "2468", "1357", " ", " ");
        AuthenticationPostBody testAuthData = new AuthenticationPostBody(testClient, "parserver", "parids", "parpids", "parurs");
        View testView = null;
        activity.httpSend(testView);

    }
}