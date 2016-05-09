package com.sqrl.sqrl_android.data;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class UserUnitTest  {
    @Test
    public void userTest(){
        User testUser = new User();
        String var = testUser.getFirstName();
        assertNotNull(testUser.firstName);
        assertNotNull(testUser.lastName);
        assertNotNull(testUser.password);
    }



}