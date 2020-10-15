package jit.xyyk.edusystem.serviceImpl;

import jit.xyyk.edusystem.bean.CourseType;
import jit.xyyk.edusystem.repository.CourseRepository;
import jit.xyyk.edusystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseType> selectCourseType() {
        return courseRepository.selectCourseType();
    }
}
