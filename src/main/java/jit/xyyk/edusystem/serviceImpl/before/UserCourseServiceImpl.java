package jit.xyyk.edusystem.serviceImpl.before;

import jit.xyyk.edusystem.bean.Course;
import jit.xyyk.edusystem.bean.CourseType;
import jit.xyyk.edusystem.repository.before.UserCourseRepository;
import jit.xyyk.edusystem.service.before.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserCourseServiceImpl implements UserCourseService {

    @Autowired
    private UserCourseRepository userCourseRepository;

    @Override
    public List<Course> getAllCourses() {
        return userCourseRepository.getAllCourses();
    }

    @Override
    public Course selCourse(int course_id) {
        return userCourseRepository.selCourse(course_id);
    }

    @Override
    public List<Course> getOtherCourse(int course_id) {
        List<Course> courseList = userCourseRepository.selOtherCourse(course_id);
        if (courseList.size()<=4){
            return courseList;
        }else {
             return courseList.subList(0,3);
        }



    }

    @Override
    public List<CourseType> getAllCourseType() {
        return userCourseRepository.getAllCourseType();
    }


}
