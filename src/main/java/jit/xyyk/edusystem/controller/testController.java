package jit.xyyk.edusystem.controller;


import jit.xyyk.edusystem.service.admin.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {

    @Autowired
    private CourseTypeService courseTypeService;

//    @RequestMapping("/focus")
//    public String sayHello(){
//        return "before/focus";
//    }


}
