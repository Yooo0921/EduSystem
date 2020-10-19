package jit.xyyk.edusystem.serviceImpl;

import jit.xyyk.edusystem.bean.User;
import jit.xyyk.edusystem.repository.UserRepository;
import jit.xyyk.edusystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public int register(User user) {

        return userRepository.register(user);
    }

    @Override
    public boolean ifExistUser(String user_email) {
        if(userRepository.getUserByEmail(user_email) == null){
            return true;
        }
        return false;
    }
}
