package com.example.coba;

public class UserHelper {

    String npm, tpmt_lhr, tgl_lhr,  f_nm, pass, passC, email, no_hp;

    public UserHelper() {
    }

    public UserHelper(String npm, String tpmt_lhr, String tgl_lhr, String f_nm, String pass, String passC, String email, String no_hp) {
        this.npm = npm;
        this.tpmt_lhr = tpmt_lhr;
        this.tgl_lhr = tgl_lhr;
        this.f_nm = f_nm;
        this.pass = pass;
        this.passC = passC;
        this.email = email;
        this.no_hp = no_hp;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getTpmt_lhr() {
        return tpmt_lhr;
    }

    public void setTpmt_lhr(String tpmt_lhr) {
        this.tpmt_lhr = tpmt_lhr;
    }

    public String getTgl_lhr() {
        return tgl_lhr;
    }

    public void setTgl_lhr(String tgl_lhr) {
        this.tgl_lhr = tgl_lhr;
    }

    public String getF_nm() {
        return f_nm;
    }

    public void setF_nm(String f_nm) {
        this.f_nm = f_nm;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPassC() {
        return passC;
    }

    public void setPassC(String pass) {
        this.passC = passC;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }
}
