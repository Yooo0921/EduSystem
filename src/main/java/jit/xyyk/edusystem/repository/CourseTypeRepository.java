package jit.xyyk.edusystem.repository;

import jit.xyyk.edusystem.bean.Course;
import jit.xyyk.edusystem.bean.CourseType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseTypeRepository {
    public int addCourseType(CourseType courseType);

    public CourseType getCourseTypeByName(String course_name);

    public List<CourseType> getAllCourseType();

    public int delCourseType(int coursetype_id);

    public List<Course> selectCourseByTypeId(int coursetype_id);
}
