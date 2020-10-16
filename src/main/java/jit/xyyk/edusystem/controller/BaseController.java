package jit.xyyk.edusystem.controller;

import jit.xyyk.edusystem.exception.AdminLoginNoException;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseController {


    @ModelAttribute
    public void isLogin(HttpSession session, HttpServletRequest request) throws AdminLoginNoException {
        if (session.getAttribute("auser") == null) {
            throw new AdminLoginNoException("没有登录");
        }
    }

}
