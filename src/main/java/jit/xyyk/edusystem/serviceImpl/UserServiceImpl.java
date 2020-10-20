package jit.xyyk.edusystem.serviceImpl;

import jit.xyyk.edusystem.bean.User;
import jit.xyyk.edusystem.repository.UserRepository;
import jit.xyyk.edusystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @Override
    public String login(User user, Model model, HttpSession session) {
        User ruser = null;
        List<User> list = userRepository.login(user);
        if (list.size() > 0) {
            ruser = list.get(0);
        }
        if (ruser != null) {
            session.setAttribute("user", ruser);
            return "forward:/index";
        } else {
            model.addAttribute("msg", "用户名或密码错误！");
            return "/login";
        }
    }
}
