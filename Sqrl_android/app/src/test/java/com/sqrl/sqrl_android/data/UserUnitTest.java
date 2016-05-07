package com.sqrl.sqrl_android.data;

import org.junit.matchers.*;
import static org.junit.Assert.*;
import static org.hamcrest.core.*;
import static org.hamcrest.text.*;
import java.util.regex.Pattern;
import org.junit.Test;
import com.sqrl.sqrl_android.data.User;

public class UserUnitTest  {
    @Test
    public void userTest(){
        assertNotNull(User.getFirstName());
        assertNotNull(User.getLastName());
        assertNotNull(User.getPassword());
    }

}