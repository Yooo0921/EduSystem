package jit.xyyk.edusystem.repository.before;

import jit.xyyk.edusystem.bean.Course;
import jit.xyyk.edusystem.bean.CourseType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserCourseRepository {
    /**
     * 获取所有Course
     * @return
     */
    public List<Course> getAllCourses();

    /**
     * 根据课程ID 查找课程信息
     */
    public Course selCourse(int course_id);

    /**
     * 根据课程ID 查找除此之外的课程 并显示在相关列表中
     */
    public List<Course> selOtherCourse(int course_id);

    /**
     * 根据课程ID 查找除此之外的课程 并显示在相关列表中
     */
    public List<CourseType>  getAllCourseType();
}
