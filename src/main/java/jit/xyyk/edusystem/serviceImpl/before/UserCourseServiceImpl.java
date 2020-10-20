package jit.xyyk.edusystem.serviceImpl.before;

import jit.xyyk.edusystem.bean.Course;
import jit.xyyk.edusystem.repository.before.UserCourseRepository;
import jit.xyyk.edusystem.service.before.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCourseServiceImpl implements UserCourseService {

    @Autowired
    private UserCourseRepository userCourseRepository;

    @Override
    public List<Course> getAllCourses() {
        return userCourseRepository.getAllCourses();
    }
}
