package jit.xyyk.edusystem.controller;

import jit.xyyk.edusystem.bean.CourseType;
import jit.xyyk.edusystem.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminTypeController extends BaseController{

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

    @RequestMapping("/admin/showCourseType")
    public String showCourseType(){
        return "admin/showCourseType";
    }


//    @RequestMapping("/admin/delCourseType")
//    public String delCourseType(HttpServletRequest request,Model model){
//        int coursetype_id = Integer.parseInt(request.getParameter("coursetype_id"));
//        if(courseTypeService.delCourseType(coursetype_id)>0){
//            model.addAttribute("msg","成功删除！");
//            return "admin/showCourseType";
//        }
//        model.addAttribute("msg","删除失败！");
//        return "admin/showCourseType";
//    }


    @RequestMapping("/admin/delCourseType")
    public void delCourseType(HttpServletRequest request, HttpServletResponse response) throws Exception{
        int coursetype_id = Integer.parseInt(request.getParameter("coursetype_id"));

        response.setHeader("content-type", "text/json;charset=utf-8");

        String flag = "0";

        if(courseTypeService.delCourseType(coursetype_id)>0){
            flag = "1";
        }

        String responseJson = "{\"flag\":\"" + flag + "\"}";

        response.getWriter().write(responseJson);


    }

}
