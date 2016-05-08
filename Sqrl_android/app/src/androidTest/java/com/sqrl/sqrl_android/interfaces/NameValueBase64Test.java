package com.sqrl.sqrl_android.interfaces;

import android.support.test.runner.AndroidJUnit4;

import android.support.test.runner.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)

public class NameValueBase64Test {

    @Test
    public void testNameValueBase64getters() {
        NameValueBase64 testee = new NameValueBase64("name", "value") {};
        assertEquals("name", testee.getName());
        assertEquals("value", testee.getValue());
    }
}