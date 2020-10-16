package jit.xyyk.edusystem.controller;


import jit.xyyk.edusystem.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {

    @Autowired
    private CourseTypeService courseTypeService;

    @RequestMapping("/index")
    public String sayHello(){
        return "admin/showCourseType";
    }


}
