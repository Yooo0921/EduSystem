package jit.xyyk.edusystem.controller;

import jit.xyyk.edusystem.bean.Auser;
import jit.xyyk.edusystem.bean.CourseType;
import jit.xyyk.edusystem.service.AdminService;
import jit.xyyk.edusystem.service.CourseService;
import jit.xyyk.edusystem.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController extends  BaseController{

    @Autowired
    private CourseTypeService courseTypeService;

    @Autowired
    private CourseService courseService;

    //显示管理员页面
    @RequestMapping("/admin/main")
    public String showAdmin(){
        return "admin/main";
    }


    //显示课程界面
    @RequestMapping("/admin/course")
    public String showCourse(Model model){
        List<CourseType> courseTypes = courseService.selectCourseType();
        model.addAttribute("courseTypes", courseTypes);


        return "admin/course";
    }



}
