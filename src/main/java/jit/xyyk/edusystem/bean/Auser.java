package jit.xyyk.edusystem.bean;

import java.io.Serializable;

public class Auser implements Serializable {
    private String auser_name;
    private String auser_password;

    public Auser(String auser_name, String auser_password) {
        this.auser_name = auser_name;
        this.auser_password = auser_password;
    }

    public Auser() {

    }

    public String getAuser_name() {

        return auser_name;
    }

    public void setAuser_name(String auser_name) {
        this.auser_name = auser_name;
    }

    public String getAuser_password() {
        return auser_password;
    }

    public void setAuser_password(String auser_password) {
        this.auser_password = auser_password;
    }
}
