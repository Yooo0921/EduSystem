package jit.xyyk.edusystem.service.before;

import jit.xyyk.edusystem.bean.Course;

import java.util.List;

public interface UserCourseService {

    public List<Course> getAllCourses();

    public Course selCourse(int course_id);

    public List<Course> getOtherCourse(int course_id);
}