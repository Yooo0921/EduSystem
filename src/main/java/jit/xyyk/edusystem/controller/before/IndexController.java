package jit.xyyk.edusystem.controller.before;

import jit.xyyk.edusystem.bean.Course;
import jit.xyyk.edusystem.service.before.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserCourseService courseService;

    //显示课程界面
    @RequestMapping("/user/course")
    public String showCourse(Model model){
        List<Course> courseList = courseService.getAllCourses();
        model.addAttribute("courseList",courseList);
        return "before/course";
    }
}
