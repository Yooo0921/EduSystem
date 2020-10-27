package jit.xyyk.edusystem.service.before;

import jit.xyyk.edusystem.bean.History;

import java.util.List;

public interface UserHistoryService {
    public int addHistory(int user_id,int course_id);
    public List<History> showHistory(int user_id);
}
