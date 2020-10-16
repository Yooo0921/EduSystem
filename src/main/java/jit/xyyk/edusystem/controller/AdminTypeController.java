package jit.xyyk.edusystem.controller;

import jit.xyyk.edusystem.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminTypeController {

    @Autowired
    private CourseTypeService courseTypeService;

    @RequestMapping("/admin/toaddCourseType")
    public String addCourseType(){
        return "admin/addCourseType";
    }

    @RequestMapping("/admin/addCourseType")
    public String addCourseType(@ModelAttribute CourseType courseType, Model model){
        return courseTypeService.addCourseType(courseType, model);
    }

    @RequestMapping( value = "/admin/getCourseTypeData", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getCourseTypeData(){
        return courseTypeService.getCourseTypeData();
    }

}
