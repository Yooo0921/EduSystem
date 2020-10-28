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
    public String showCourseDetail(Model model, int course_id){
        Course course = userCourseService.selCourse(course_id);
        List<Course> courseList = userCourseService.getOtherCourse(course_id);
        model.addAttribute("course" ,course);
        model.addAttribute("courseList",courseList);
        return "before/coursedetail";
    }

    @RequestMapping("/getAllCourseByType")
    public String getAllCourseByType(Model model,int coursetype_id){
        List<Course> courseList = userCourseService.getAllCourseByType(coursetype_id);
        if (courseList.size()==0){
            model.addAttribute("courseList",courseList);
            model.addAttribute("msg","");
            return "before/course";

        }
        model.addAttribute("courseList", courseList);
        model.addAttribute("msg",courseList.get(0).getCoursetype_name());
        return "before/course";
    }
}
