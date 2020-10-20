package jit.xyyk.edusystem.repository.admin;

import jit.xyyk.edusystem.bean.Course;
import jit.xyyk.edusystem.bean.CourseType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseRepository {
    public List<CourseType> selectCourseType();
    public int addCourse(Course course);
    public int updateCourse(Course course);
    public List<Course> showCourse();
    public int delCourse(int course_id);
}
