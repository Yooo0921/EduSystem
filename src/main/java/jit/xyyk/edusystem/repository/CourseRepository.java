package jit.xyyk.edusystem.repository;

import jit.xyyk.edusystem.bean.CourseType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseRepository {
    public List<CourseType> selectCourseType();
}
