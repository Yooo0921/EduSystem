package jit.xyyk.edusystem.repository.before;

import jit.xyyk.edusystem.bean.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserCourseRepository {
    /**
     * 获取所有Course
     * @return
     */
    public List<Course> getAllCourses();
}
