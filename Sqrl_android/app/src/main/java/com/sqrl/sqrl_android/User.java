package com.sqrl.sqrl_android;


public class User {

    static String firstName;
    static String lastName;
    static byte[] imk;
    static byte[] password;
    static byte[] salt;
    static Integer opsLimit;
    static Integer memLimit;




    public  void setFirstName(String fname){
        this.firstName = fname;
    }
    public  void setLastName(String lname){
        this.lastName = lname;
    }
    public void setPassword(byte[] pword){
        this.password = pword;
    }
    public void setImk(byte[] imk) {this.imk = imk;}
    public void setSalt(byte[] salt) {this.salt = salt;}
    public void setOpsLimit(Integer limit){this.opsLimit = limit;}
    public void setMemLimit(Integer limit){this.memLimit = limit;}

    public static String getFirstName(){
        return firstName;
    }
    public static String getLastName(){
        return  lastName;
    }
    public static byte[] getPassword(){return password;}
    public static byte[] getImk() {return imk;}
    public static byte[] getSalt() {return salt;}
    public static Integer getOpsLimit(){return opsLimit;}
    public static Integer getMemLimit() {return memLimit;}

}


