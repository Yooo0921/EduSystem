package jit.xyyk.edusystem.controller;


import jit.xyyk.edusystem.Util.KitFileUtil;
import jit.xyyk.edusystem.bean.Course;
import jit.xyyk.edusystem.bean.CourseType;
import jit.xyyk.edusystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class AdminCourseController {

    @Autowired
    private CourseService courseService;

    //显示添加课程界面
    @RequestMapping(value = "/admin/addcourse")
    public String showCourse(Model model){
        List<CourseType> courseTypes = courseService.selectCourseType();
        model.addAttribute("courseTypes", courseTypes);
        return "admin/addcourse";
    }

    //添加课程的表单提交 获取课程信息 保存到数据库
    @RequestMapping(value = "/admin/savecourse")
    public String saveCourse(@ModelAttribute(value = "course") Course course){
        if (courseService.addCourse(course)>0){

            return "admin/course";
        }else {
            return "admin/addcourse";
        }


    }

    //修改课程
    @RequestMapping(value = "/admin/updatecourse")
    public String updateCourse(@ModelAttribute(value = "course") Course course){

        courseService.updateCourse(course);
        return "admin/course";

    }

    //删除课程
    @RequestMapping("/admin/delcourse")
    public String delCourse(HttpServletRequest request){
//        int course_id=0;
//        if (request.getParameter("course_id") != null && !request.getParameter("course_id").equals("")){
//            course_id = Integer.parseInt(request.getParameter("course_id"));
//        }
//
//
        int course_id = Integer.parseInt(request.getParameter("course_id"));
        courseService.delCourse(course_id);

        return "admin/course";


    }

    //显示课程信息
    @ResponseBody
    @RequestMapping(value = "/admin/showcourse",produces = {"application/json;charset=UTF-8"})
    public String showCourseDetail(){


        return courseService.showCourse();
    }


    //图片上传
    @ResponseBody
    @RequestMapping("/admin/picupload")
    public Map upload(MultipartFile file, HttpServletRequest request){

        String prefix="";
        String dateStr="";
        //保存上传
        OutputStream out = null;
        InputStream fileInput=null;
        try{
            if(file!=null){
                String originalName = file.getOriginalFilename();
                prefix=originalName.substring(originalName.lastIndexOf(".")+1);
                Date date = new Date();
                String uuid = UUID.randomUUID()+"";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateStr = simpleDateFormat.format(date);
                String filepath = "F:\\pic\\media\\" +uuid+"." + prefix;//真实路径
                String result  ="/edusystem/"+uuid+"." + prefix;//虚拟路径
                /*D:\mycode\LayUiTest\src\main\resources\static\images\*/
                File files=new File(filepath);
                //打印查看上传路径
                System.out.println(filepath);
                if(!files.getParentFile().exists()){
                    files.getParentFile().mkdirs();
                }
                file.transferTo(files);
                Map<String,Object> map2=new HashMap<>();
                Map<String,Object> map=new HashMap<>();
                map.put("code",0);
                map.put("msg"," ");
                map2.put("src",result);
                map.put("data",map2);

                return map;
            }

        }catch (Exception e){
        }finally{
            try {
                if(out!=null){
                    out.close();
                }
                if(fileInput!=null){
                    fileInput.close();
                }
            } catch (IOException e) {
            }
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",1);
        map.put("msg","");
        return map;



    }
    //视频上传
    @ResponseBody
    @RequestMapping(value = "/admin/uploadVideo",method = RequestMethod.POST)

    public Map uploadVideo(@RequestParam("layuiVideo") MultipartFile[] layuiFile, HttpServletRequest request, HttpServletResponse response){
//                     log.info("进入wph的layui视频上传接口》》》》》》》》》》》》》》》");
        Map<String,Object> map=new HashMap<>();
        Map<String,Object> map2=new HashMap<>();
        KitFileUtil kitFileUtil=new KitFileUtil();
        map = kitFileUtil.kitFileUtil(layuiFile, request, response);
        String error = map.get("error").toString();
        if("101".equals(error)){
            map2.put("error",101);
            map2.put("message",map.get("message"));
        }

        map2.put("error",0);
        String url[]=(String[])map.get("url");
        map2.put("url",url[0]);
        return map2;


    }


}
