package jit.xyyk.edusystem.repository;

import jit.xyyk.edusystem.bean.CourseType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseTypeRepository {
    public int addCourseType(CourseType courseType);

    public CourseType getCourseTypeByName(String course_name);

    public List<CourseType> getAllCourseType();
}
