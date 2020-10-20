package jit.xyyk.edusystem.service.before;

import jit.xyyk.edusystem.bean.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface UserService {

    /**
     * 注册用户
     * @param user
     * @return
     */
    public int register(User user);

    /**
     * 通过用户邮箱判断用户是否存在
     * @param user_email
     * @return
     */
    public boolean ifExistUser(String user_email);

    /**
     * 用户登陆
     * @param user
     * @param model
     * @param session
     * @return
     */
    public String login(User user, Model model, HttpSession session);
}
