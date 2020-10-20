package jit.xyyk.edusystem.controller.before;

import jit.xyyk.edusystem.bean.User;
import jit.xyyk.edusystem.service.before.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/toregister")
    public String toregister(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("codeError","");
        return "register";
    }

    @RequestMapping("/user/register")
    public String register(@ModelAttribute User user, Model model, HttpSession session, String code) {

        if (!userService.ifExistUser(user.getUser_email())) {
            model.addAttribute("codeError", "已存在用户！注册失败！");
            return "register";
        }
        if (!code.equalsIgnoreCase(session.getAttribute("code").toString())) {
            model.addAttribute("codeError", "验证码错误！");
            return "register";
        }

        if (userService.register(user) > 0) {
            //todo 修改
            return "index";
        }
        model.addAttribute("codeError", "注册失败！");
        return "register";

    }

    @RequestMapping("/user/tologin")
    public String tologin(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("msg","");
        return "login";
    }

    @RequestMapping("/user/login")
    public String login(@ModelAttribute User user, Model model, HttpSession session){
        return userService.login(user, model, session);
    }
}
