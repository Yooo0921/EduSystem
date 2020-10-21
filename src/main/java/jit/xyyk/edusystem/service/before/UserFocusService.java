package jit.xyyk.edusystem.service.before;

import jit.xyyk.edusystem.bean.Course;

import java.util.List;

public interface UserFocusService {
    public List<Course> getAllFocusByUserId(int user_id);
}
