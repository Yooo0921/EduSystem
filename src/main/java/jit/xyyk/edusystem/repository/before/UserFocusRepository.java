package jit.xyyk.edusystem.repository.before;

import jit.xyyk.edusystem.bean.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserFocusRepository {

    public List<Course> getAllFocusByUserId(int user_id);
}
