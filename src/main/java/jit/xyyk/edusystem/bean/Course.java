package jit.xyyk.edusystem.bean;


public class Course {
    private int course_id;
    private String course_name;
    private String course_detail;
    private String course_link;
    private String course_pic;
    private int coursetype_id;
    private String coursetype_name;
    private String course_status;

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_detail() {
        return course_detail;
    }

    public void setCourse_detail(String course_detail) {
        this.course_detail = course_detail;
    }

    public String getCourse_link() {
        return course_link;
    }

    public void setCourse_link(String course_link) {
        this.course_link = course_link;
    }

    public String getCourse_pic() {
        return course_pic;
    }

    public void setCourse_pic(String course_pic) {
        this.course_pic = course_pic;
    }

    public int getCoursetype_id() {
        return coursetype_id;
    }

    public void setCoursetype_id(int coursetype_id) {
        this.coursetype_id = coursetype_id;
    }

    public String getCoursetype_name() {
        return coursetype_name;
    }

    public void setCoursetype_name(String coursetype_name) {
        this.coursetype_name = coursetype_name;
    }

    public String getCourse_status() {
        return course_status;
    }

    public void setCourse_status(String course_status) {
        this.course_status = course_status;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", course_name='" + course_name + '\'' +
                ", course_detail='" + course_detail + '\'' +
                ", course_link='" + course_link + '\'' +
                ", course_pic='" + course_pic + '\'' +
                ", coursetype_id=" + coursetype_id +
                ", coursetype_name='" + coursetype_name + '\'' +
                ", course_status='" + course_status + '\'' +
                '}';
    }
}
