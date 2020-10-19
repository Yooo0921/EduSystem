package jit.xyyk.edusystem.serviceImpl;

import jit.xyyk.edusystem.bean.CourseType;
import jit.xyyk.edusystem.repository.CourseTypeRepository;
import jit.xyyk.edusystem.service.CourseTypeService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;




import java.util.List;

@Service
public class CourseTypeServiceImpl implements CourseTypeService {

    @Autowired
    private CourseTypeRepository courseTypeRepository;

    @Override
    public int addCourseType(CourseType courseType) {
        return 0;
    }

    @Override
    public boolean ifExistCourseType(String coursetype_name) {
        if (courseTypeRepository.getCourseTypeByName(coursetype_name) == null){
            return true;
        }
        return false;
    }

    @Override
    public String addCourseType(CourseType courseType, Model model) {
        if (!ifExistCourseType(courseType.getCoursetype_name())){
            model.addAttribute("msg", "已存在这种类型！添加失败！");
            return "admin/addCourseType";
        }
        if(courseTypeRepository.addCourseType(courseType)>0){
            //TODO 查看类型界面
            model.addAttribute("msg", "添加成功！");

            return "admin/addCourseType";
        }
        model.addAttribute("msg", "添加失败！");
        return "admin/addCourseType";
    }

    @Override
    public String getCourseTypeData() {
        List<CourseType> courseTypes = courseTypeRepository.getAllCourseType();
        JSONArray jsonArray = JSONArray.fromObject(new List[]{courseTypes});
        //数据的数量
        int num = courseTypes.size();
        String head = "{\"code\":0,\"msg\":\"\",\"count\":"+num+",\"data\":";

        String result = jsonArray.toString().substring(1,jsonArray.toString().length()-1);

        String courseTypesData = head+result+"}";

        return courseTypesData;

    }

    @Override
    public int delCourseType(int coursetype_id) {

        //删除时的判断 是否被用到
        if (courseTypeRepository.selectCourseByTypeId(coursetype_id).size()>0){
            return 0;
        }

        return courseTypeRepository.delCourseType(coursetype_id);
    }
}
