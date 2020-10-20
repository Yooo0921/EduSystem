package jit.xyyk.edusystem.repository.admin;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FocusRepository {
    public int delFocus(int course_id);
}
