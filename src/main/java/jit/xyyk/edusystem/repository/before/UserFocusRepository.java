package jit.xyyk.edusystem.repository.before;

import jit.xyyk.edusystem.bean.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserFocusRepository {

    public List<Course> getAllFocusByUserId(int user_id);

    public int focus(Map<String, Object> map);

    public List<Map<String, Object>> isFocus(Map<String, Object> map);

    public int cancelFocus(Map<String, Object> map);

}
