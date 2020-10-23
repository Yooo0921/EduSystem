package jit.xyyk.edusystem.controller.before;

import jit.xyyk.edusystem.Util.MyUtil;
import jit.xyyk.edusystem.bean.Course;
import jit.xyyk.edusystem.bean.CourseType;
import jit.xyyk.edusystem.service.before.UserCourseService;
import jit.xyyk.edusystem.service.before.UserFocusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserCourseService courseService;



    @RequestMapping("/index")
    public String index(Model model){
        List<CourseType> courseTypeList = courseService.getAllCourseType();
        model.addAttribute("courseTypeList",courseTypeList);
        return "before/index";
    }

    //显示课程界面
    @RequestMapping("/user/course")
    public String showCourse(Model model){
        List<Course> courseList = courseService.getAllCourses();

        model.addAttribute("courseList",courseList);


        return "before/course";
    }



}
