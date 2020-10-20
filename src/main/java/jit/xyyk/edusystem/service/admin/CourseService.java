package jit.xyyk.edusystem.service.admin;

import jit.xyyk.edusystem.bean.Course;
import jit.xyyk.edusystem.bean.CourseType;

import java.util.List;

public interface CourseService {
    public List<CourseType> selectCourseType();
    public int addCourse(Course course);

    public String showCourse();
    public int updateCourse(Course course);
    public int delCourse(int course_id);
}
