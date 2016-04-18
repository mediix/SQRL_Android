package com.sqrl.sqrl_android.data;


public class User {

    static String firstName;
    static String lastName;
    static String password;



    public  void setFirstName(String fname){
        this.firstName = fname;
    }
    public  void setLastName(String lname){
        this.lastName = lname;
    }
    public void setPassword(String pword){
        this.password = pword;
    }
    public static String getFirstName(){
        return firstName;
    }
    public static String getLastName(){
        return  lastName;
    }
    public static String getPassword(){return password;}

}


