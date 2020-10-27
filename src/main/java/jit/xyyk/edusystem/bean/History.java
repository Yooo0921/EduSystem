package jit.xyyk.edusystem.bean;

import java.sql.Timestamp;

public class History {
    private int history_id;
    private int course_id;
    private int user_id;
    private Timestamp historytime;
    private String course_name;
    private String course_pic;

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Timestamp getHistoryTime() {
        return historytime;
    }

    public void setHistoryTime(Timestamp historyTime) {
        this.historytime = historyTime;
    }

    public int getHistory_id() {
        return history_id;
    }

    public void setHistory_id(int history_id) {
        this.history_id = history_id;
    }

    public Timestamp getHistorytime() {
        return historytime;
    }

    public void setHistorytime(Timestamp historytime) {
        this.historytime = historytime;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_pic() {
        return course_pic;
    }

    public void setCourse_pic(String course_pic) {
        this.course_pic = course_pic;
    }
}
