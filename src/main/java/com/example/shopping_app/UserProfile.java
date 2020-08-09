package com.example.shopping_app;

public class UserProfile {
    public String username;
    public String userphone;
    public String useremail;
    public String userpassword;


    public UserProfile(){


    }

    public UserProfile(String username, String userphone, String useremail,String userpassword) {
        this.username = username;
        this.userphone = userphone;
        this.useremail = useremail;
        this.userpassword=userpassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
}
