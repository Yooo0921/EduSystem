package jit.xyyk.edusystem.serviceImpl.before;

import jit.xyyk.edusystem.bean.Course;
import jit.xyyk.edusystem.repository.before.UserFocusRepository;
import jit.xyyk.edusystem.service.before.UserFocusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFoucesServiceImpl implements UserFocusService {

    @Autowired
    private UserFocusRepository userFocusRepository;

    @Override
    public List<Course> getAllFocusByUserId(int user_id) {
        return userFocusRepository.getAllFocusByUserId(user_id);

    }
}
