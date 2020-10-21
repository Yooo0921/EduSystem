package jit.xyyk.edusystem.controller.before;

import jit.xyyk.edusystem.exception.UserLoginNoException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserBaseController {

    @ModelAttribute
    public void isLogin(HttpSession session, HttpServletRequest request) throws UserLoginNoException {
        if (session.getAttribute("user") == null) {
            throw new UserLoginNoException("没有登录");
        }
    }
}
