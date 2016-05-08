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

    @Test
    public void testNameValueBase64setters() {
        NameValueBase64 testee = new NameValueBase64("name", "value") {};

        testee.setValue("newvalue");
        assertEquals("newvalue", testee.getValue());
    }

    @Test
    public void testPaddingGetValueBase64Url() {
        //needs several cases so that padding characters are removed

        NameValueBase64 testee = new NameValueBase64("name", "value") {};

        //Test for padding 0, 1, or 2
        testee.setValue("nopadding");
        assertEquals("bm9wYWRkaW5n", testee.getValueBase64url());

        testee.setValue("1padding");
        assertEquals("MXBhZGRpbmc", testee.getValueBase64url());

        testee.setValue("twopadding");
        assertEquals("dHdvcGFkZGluZw", testee.getValueBase64url());

    }

    @Test
    public void testUrlSafeNameValueBase64() {
        //test substitutions of characters 62 and 63 substitutions
        //62 + -> -
        //63 / -> _
        NameValueBase64 testee = new NameValueBase64("name", "value") {};

        testee.setValue(">>>");
        assertEquals("Pj4-", testee.getValueBase64url());

        testee.setValue("???");
        assertEquals("Pz8_", testee.getValueBase64url());
    }

    @Test
    public void testNameValueBase64Output() {
        NameValueBase64 testee = new NameValueBase64("name", "value") {};

        assertEquals("name={dmFsdWU}", testee.getNameValueBase64url());

        testee.setValue("");
        assertEquals("name={}", testee.getNameValueBase64url());
    }

}