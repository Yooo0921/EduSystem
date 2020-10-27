package jit.xyyk.edusystem.service.before;

import jit.xyyk.edusystem.bean.History;

import java.util.List;

public interface UserHistoryService {
    /**
     * 如果没有浏览记录 添加浏览记录
     * @param user_id
     * @param course_id
     * @return
     */
    public int addHistory(int user_id,int course_id);

    /**
     * 根据用户id展示浏览记录
     * @param user_id
     * @return
     */
    public List<History> showHistory(int user_id);

    /**
     * 查找是否有浏览记录
     * @param user_id
     * @param course_id
     * @return
     */
    public int selectHistory(int user_id,int course_id);

    /**
     * 如果有浏览记录，更新浏览记录
     * @param user_id
     * @param course_id
     * @return
     */
    public int updateHistory(int user_id,int course_id);
}
