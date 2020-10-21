package jit.xyyk.edusystem.controller.before;

import jit.xyyk.edusystem.bean.Course;
import jit.xyyk.edusystem.service.before.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserCourseController {
    @Autowired
    private UserCourseService userCourseService;

    @RequestMapping("/user/coursedetail")
    public String showCourseDetail(Model model, HttpServletRequest request){
        int course_id = Integer.parseInt(request.getParameter("course_id"));
        Course course = userCourseService.selCourse(course_id);
        List<Course> courseList = userCourseService.getOtherCourse(course_id);
        model.addAttribute("course" ,course);
        model.addAttribute("courseList",courseList);
        return "before/coursedetail";
    }
}
