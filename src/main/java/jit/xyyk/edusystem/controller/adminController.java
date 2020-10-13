package jit.xyyk.edusystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class adminController {
    //显示管理员页面
    @RequestMapping("/admin/main")
    public String showAdmin(){
        return "admin/main";
    }


    //显示课程管理界面
    @RequestMapping("/admin/course")
    public String showCourse(){
        return "admin/course";
    }
}
