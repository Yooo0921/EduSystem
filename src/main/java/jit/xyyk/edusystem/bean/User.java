package jit.xyyk.edusystem.bean;

public class User {
    private int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    private String user_email;
    private String user_pwd;


    public User(int user_id, String user_email, String user_pwd) {
        this.user_id = user_id;
        this.user_email = user_email;
        this.user_pwd = user_pwd;
    }

    public User() {
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }
}
