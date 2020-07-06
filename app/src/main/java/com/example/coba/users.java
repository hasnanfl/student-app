package com.example.coba;

public class users {
    public String mEmail, mPassword;

    public users(){

    }
    public users(String mEmail, String mPassword){
        this.mEmail=mEmail;
        this.mPassword=mPassword;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}
