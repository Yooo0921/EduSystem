package jit.xyyk.edusystem.serviceImpl.admin;

import jit.xyyk.edusystem.bean.Course;
import jit.xyyk.edusystem.bean.CourseType;
import jit.xyyk.edusystem.repository.admin.CourseRepository;
import jit.xyyk.edusystem.repository.admin.FocusRepository;
import jit.xyyk.edusystem.service.admin.CourseService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private FocusRepository focusRepository;

    //展示所有的课程类型
    @Override
    public List<CourseType> selectCourseType() {
        return courseRepository.selectCourseType();
    }


    //添加课程
    @Override
    public int addCourse(Course course) {

        return courseRepository.addCourse(course);
    }

    //修改课程

    public int updateCourse(Course course) {

        return courseRepository.updateCourse(course);
    }

    //删除课程
    //先删除关注表里的课程 再删除课程表里的
    @Transactional
    @Override
    public int delCourse(int course_id) {
        int flag=focusRepository.delFocus(course_id);
        int flag2=courseRepository.delCourse(course_id);
        if(flag>=0&&flag2>0){
            return 1;
        }else {
            return 0;
        }
    }


    //显示课程信息
    @Override
    public String showCourse() {
        List<Course> courseList = courseRepository.showCourse();
        JSONArray jsonArray = JSONArray.fromObject(new List[]{courseList});
        //数据的数量
        int num = courseList.size();
        String head = "{\"code\":0,\"msg\":\"\",\"count\":"+num+",\"data\":";

        String result = jsonArray.toString().substring(1,jsonArray.toString().length()-1);

        String courseListData = head+result+"}";

        return courseListData;
    }


}
